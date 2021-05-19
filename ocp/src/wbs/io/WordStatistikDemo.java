package wbs.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class WordStatistikDemo {

        public static void main(String[] args) throws IOException {
        //	Supplier<Map<String, AtomicInteger>> suplier =TreeMap::new ;
        	
                Path path = Paths.get("resources/io/song_of_myself_whitman.txt");
                Map<String, AtomicInteger> map = Files.lines(path)
                                .flatMap(s -> Arrays.stream(s.split("[^a-zA-Z]+"))) // leer zeihcnen als trener
                                .filter(s -> s.length() > 0).map(s -> s.toLowerCase())
                                                            // key              value
                                .collect(Collectors.toMap(s -> s, s -> new AtomicInteger(1), // chon  Map<String, AtomicInteger>
                                                (a, b) -> { // aktuele key values
                                                        a.incrementAndGet(); // binary operator inja yedoone parametro mikhad // suplier 
                                                        return a;
                                                }, TreeMap::new)); // suplier bala
                map.forEach((k, v) -> System.out.println(k + "-> " + v));

                // wie koennte man vorgehen , um die ausgabe abstifend nach heufigkeit zu sortieren
                //(und ggf bei gleicher heufigerkeit austeigend alphabetisch)
        }
        
        
        /*
         * warum wird hier AtomicInteger und nicht Integer verwendet? thread safe

           was bedeutet der reguläre ausdruck [^a-zA-Z] regex pattern

        was macht noch mal flatMap()? 

          was macht noch mal map()?

           wie ist die methode toMap() von collectors parametrisiert,
          und was macht sie?

        welche ausgabe erzeugt der code?
         */
}
