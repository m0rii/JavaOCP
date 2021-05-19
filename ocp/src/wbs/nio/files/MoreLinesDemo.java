package wbs.nio.files;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//wir geben alle zeilen einer textdatei aus.
//der pfad zur datei wird beim aufruf als argument mitgegeben.

//wir verwenden die methoden newBufferedReader() von Files und
//lines() von BufferedReader.

//wir verwenden try with resources (so dass der BufferedReader
//automatisch geschlossen wird)

public class MoreLinesDemo {      
	// path z.b : src/wbs/nio/files/MoreLinesDemo.java
     public static void main(String[] args) throws IOException {
    	 
    	 Path path = Paths.get(args[0]);
    	 try(BufferedReader br = Files.newBufferedReader(path)) {
    		 br.lines().forEach(System.out::println);
    	 }
        
     }
}
