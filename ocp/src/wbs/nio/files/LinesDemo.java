package wbs.nio.files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Aufruf z.B.:  src/wbs/nio/files/LinesDemo.java

// Ist Stream AutoCloseable?
/*
 * 
 */
// Haben wir hier try with resources?
/*
 * Yep. Ist etwas anderes als das klassische try/catch
 */
// Was ist der aktuelle Pfad, in dem ein Java-Programm ausgeführt wird, das unter Eclipse gestartet wurde?
/*
 * src/wbs/nio/files/LinesDemo.java  (Projekt-Pfad)
 */

public class LinesDemo {

        /*
         * das programm wird mit einem dateinamen als argument aufgerufen. das programm
         * gibt alle zeilen der angegebenen datei aus unter verwendung der methode
         * lines() der klasse Files.
         */
        public static void main(String[] args) throws IOException {
                Path file = Paths.get(args[0]); // via Run Configurations... ==> Arguments ==> src/wbs/nio/files/LinesDemo.java
                try (Stream<String> lines = Files.lines(file)) { // Stream implementiert das in der Klammer benötigte Interface "AutoCloseable"
                        lines.forEach(System.out::println);
                }

        }

}
