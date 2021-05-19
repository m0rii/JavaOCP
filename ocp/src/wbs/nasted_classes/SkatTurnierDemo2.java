package wbs.nasted_classes;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SkatTurnierDemo2 {

        /*
         * wir organisieren ein skat-turnier, an dem 10 spieler teilnehmen. wir listen
         * alle möglichen kombinationen von genau 3 skatspielern auf. wie viele
         * kombinationen gibt es insgesamt?
         */
        public static void main(String[] args) {
                String[] skatSpieler = { "anton", "bernd", "chris", "dieter", "elfriede", "friedrich", "gustav", "heinrich",
                                "isidor", "judith" };
                /*
                 * Es gibt bereits die Klasse MyList<T> mit der Methode iterator(), 
                 * die alle Sublisten einer List<T> zurückgibt. Von diesen sind jetzt
                 * nur diejenigen interessant, die genau drei Elemente enthalten. 
                 */
                
                List<String> spieler = Arrays.asList(skatSpieler);
                MyList<String> turnier = new MyList<>(spieler);
                List<List<String>> tripel = nurTupel(turnier, 3);
                Comparator<List<String>> cmpLStr = (l1, l2) -> {
                        int v = 0;
                        l1.sort(null);
                        l2.sort(null);
                        Iterator<String> itr1 = l1.iterator();
                        Iterator<String> itr2 = l2.iterator();
                        while(itr1.hasNext() && itr2.hasNext()) {
                                String s1 = itr1.next();
                                String s2 = itr2.next();
                                if((v = s1.compareTo(s2)) != 0) {
                                        break; 
                                }
                        }
                        
                        return v == 0 ? Integer.compare(l1.size(), l2.size()) : v;
                };
                tripel.sort(cmpLStr);
                tripel.forEach(t -> System.out.println(t));
                System.out.println("Es gibt " + tripel.size() + " verschiedene Kombinationen.");
        }
        
        public static <T> List<List<T>> nurTupel(MyList<T> l, int n) {
                List<List<T>> ergebnis = new Vector<List<T>>();
                Iterator<List<T>> itr = l.iterator();
                while(itr.hasNext()) {
                        List<T> tmp = itr.next();
                        if(tmp.size() == n) {
                                ergebnis.add(tmp);
                        }
                }
                return ergebnis;
        }

}
