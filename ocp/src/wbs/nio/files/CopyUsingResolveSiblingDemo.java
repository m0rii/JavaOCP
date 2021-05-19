package wbs.nio.files;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 * wir kopieren die datei resources/io/books.ser in die
 * datei books2.ser (ebenfalls im verzeichnis resources/io).
 * 
 * wir verwenden dazu die methode resolveSibling() von Path 
 * und die methode copy() von Files.
 * 
 * wir untersuchen, was passiert, wenn die zieldatei bereits existiert.
 * 
 * wie können wir das beeinflussen?
 */

public class CopyUsingResolveSiblingDemo {

        public static void main(String[] args) throws IOException {
                Path src = Paths.get("resources/io/books.ser");
                Path dst = Paths.get("books2.ser");
                // TODO
                
                try {
                	
				Files.copy(src, src.resolveSibling(dst));
			//	 Files.copy(src,src.resolveSibling(dst),StandardCopyOption.REPLACE_EXISTING);
				} catch (FileAlreadyExistsException e) {
					System.out.println(e);
				}
                // achtung: in nio NoSuchFileException , in io FileNotException!
                catch(NoSuchFileException e) {
                	System.out.println(e);
                }
        }
}
