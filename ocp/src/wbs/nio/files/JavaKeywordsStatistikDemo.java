package wbs.nio.files;


/**
 * @author Klaus
 */
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JavaKeywordsStatistikDemo {

        /*
         * Wir erstellen die Klasse JavaKeywordsStatistikDemo.
         *  
         * Es gibt die folgenden Java-Keywords:
         * 
         *        class,interface,enum,for,case,switch,while,do,if,else,package,import
         *        boolean,byte,short,char,long,int,double,float,instanceof
         *        default,break,volatile,transient,static,public,protected,private
         *        extends,implements,return,void,try,catch,finally
         *        native,synchronized,abstract,final,strictfp,goto,const
         *
         * Diese Java-Keywords werden aus der Textdatei 
         * "resources/io/java_keywords.txt" geladen.
         * 
         * Alle Java-Sourcen im Ordner ocp/src werden durchlaufen. Für jedes
         * Java-Schlüsselwort wird die absolute Häufigkeit ermittelt, mit der es
         * vorkommt.
         * 
         * Es erfolgen zwei Ausgaben: 
         * 
         * 1. Alle Schlüsselwörter werden alphabetisch aufsteigend mit ihrer 
         * Häufigkeit aufgelistet. 
         * -> SortedMap<K,V> mit natürlicher Ordnung für K 
         * 
         * 2. Alle Schlüsselwörter werden absteigend nach ihrer Häufigkeit 
         * aufgelistet. Bei gleicher Häufigkeit soll alphabetisch aufsteigend 
         * sortiert werden.
         * -> SortedMap<K,V> mit speziellem Comparator<K>, der V berücksichtigt
         */
        final static int EQUALS = 0; 
        final static String KEYWORDS_FILE = "resources/io/java_keywords.txt";
        final static String ROOT_DIR = "src";
        
        final TreeMap<String, AtomicInteger> statistik = new TreeMap<>();
        final AtomicInteger aiFiles = new AtomicInteger(0);
        
        private void go() throws IOException {
                /*
                 * Durchsuche Dateisystem nach Java-Dateien 
                 * und analysiere gefundene Java-Dateien
                 */
                Path dir = Paths.get(ROOT_DIR);

                BiPredicate<Path, BasicFileAttributes> matcher = (path, attrs) -> {
                        return path.toString().endsWith(".java");
                };
                
                /*
                 * 
                 */
                Consumer<Path> fileAction = (p) -> {
                        try(Reader r = Files.newBufferedReader(p)) {
                                StreamTokenizer st = new StreamTokenizer(r);
                                /*
                                 * Standard für die Zeichenzuordnungen löschen
                                 */
                                st.resetSyntax();
                                /*
                                 * Zeilentrenner werden als Leerzweichen behandelt
                                 */
                                st.eolIsSignificant(false);
                                /*
                                 * Es erfolgt keine automatische Umwandlung in Kleinbuchstaben
                                 */
                                st.lowerCaseMode(false);
                                /*
                                 * Kommentare sollen ignoriert werden
                                 */
                                st.slashSlashComments(true);
                                st.slashStarComments(true);
                                /*
                                 * Zeichenketten werden mit " eingeleitet.
                                 * Zeichenketten werden nicht ausgewertet.
                                 * volatile
                                 */
                                // volatile
                                st.quoteChar('\u0022'); // QUOTATION MARK
                                /*
                                 * Trennzeichen
                                 */
                                st.whitespaceChars('\u0020', '\u0020'); // SPACE
                                st.whitespaceChars('\u0028', '\u0029'); // LEFT PARENTHESIS, RIGHT PARENTHESIS
                                st.whitespaceChars('\u003a', '\u003c'); // COLON, SEMICOLON, LESS-THAN SIGN
                                st.whitespaceChars('\u003e', '\u003e'); // GREATER-THAN SIGN
                                st.whitespaceChars('\u005b', '\u005b'); // LEFT SQUARE BRACKET
                                st.whitespaceChars('\u005d', '\u005d'); // RIGHT SQUARE BRACKET
                                st.whitespaceChars('\u007b', '\u007d'); // LEFT CURLY BRACKET, VERTICAL LINE, RIGHT CURLY BRACKET
                                /*
                                 * Zeichen für die Worte
                                 */
                                st.wordChars('a', 'z');
                                /*
                                 * Alle Token werden analysiert
                                 */
                                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                                    if(st.ttype == StreamTokenizer.TT_WORD) {
                                        if(statistik.containsKey(st.sval)) {
                                                statistik.get(st.sval).incrementAndGet();
                                        }
                                    }
                                }
                        } catch(IOException iox) {
                                iox.printStackTrace();
                        }
                };
                
                /*
                 * Los geht's!
                 */
                Files.find(dir, Integer.MAX_VALUE, matcher).peek((f) -> aiFiles.incrementAndGet()).forEach(fileAction);
        }
        
        private void ausgabe()  {
                /*
                 * Es wird eine TreeMap mit einem eigenen Comparator<String>
                 * erzeugt.
                 * Diese wird mit den erfassten Werten aus statistik gefüllt.  
                 */
                Comparator<String> komparator = (s1, s2) -> {
                        int cmp = 0;
                        if(statistik.containsKey(s1) && statistik.containsKey(s2)) {
                                cmp = -Integer.compare(statistik.get(s1).intValue(), statistik.get(s2).intValue());
                                if(cmp == EQUALS) {
                                        cmp = s1.compareTo(s2);
                                }
                        }
                        return cmp;
                };
                
                final TreeMap<String, AtomicInteger> statistikSortiert = new TreeMap<>(komparator);
                statistikSortiert.putAll(statistik);
                
                /*
                 * Für die Ausgabe wird ein BiConsumer<String, AtomicInteger> definiert
                 */
                BiConsumer<String, AtomicInteger> prn = (k,v) -> {
                        System.out.println(k + " => " + v);
                };

                System.out.println("----> Statistik für " + aiFiles + " Java-Quelltextdateien <----");
                statistik.forEach(prn);
                System.out.println("----> sortierte Statistik für " + aiFiles + " Java-Quelltextdateien <----");
                statistikSortiert.forEach(prn);
        }

        public JavaKeywordsStatistikDemo() throws IOException {
                /*
                 * Datenstruktur TreeMap wird mit den Java-Keywords initialisiert
                 */
                Files.lines(Paths.get(KEYWORDS_FILE))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(s -> s.length() > 0)
                .map(s -> s.trim().toLowerCase())
                .collect(Collectors.toMap(s -> s, s -> new AtomicInteger(0), (a, b) -> {
                        a.incrementAndGet();
                        return a;
                }, () -> statistik));
        }
        
        public static void main(String[] args) throws IOException {
                JavaKeywordsStatistikDemo jks = new JavaKeywordsStatistikDemo();
                jks.ausgabe();
                jks.go();
                jks.ausgabe();
        }

}
