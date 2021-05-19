package wbs.io.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import wbs.jdbc.dao.Buch;

/*
 * wir lesen nun alle serialisierten bücher aus der datei
 * io/resources/io/books.ser ein und geben sie buch für buch aus.
 */


public class DeserializeBooksDemo {
        
        
        @SuppressWarnings("unchecked")
		public static void main(String[] args)
                        throws IOException, ClassNotFoundException {
        	List<Buch> buecher;
        	String path = "resources/io/book.ser";
        	try(ObjectInputStream ois = new ObjectInputStream(
        			new BufferedInputStream(new FileInputStream(path)))){
        		buecher =(List<Buch>) ois.readObject();
        	}
        	buecher.forEach(System.out::println);
        	
        }
}
/*
 * was ändert sich, wenn das feld preis als transient 
deklariert wird? 

wir kommentieren die serialVersionUID aus.
wir serialisieren alle bücher.
dann fügen wir ein neues feld in die klasse
buch (z.b. verlag) ein. dann deserialisieren wir.
was passiert?

wir wiederholen die obigen schritte,
jetzt aber mit nicht auskommentierter serialVersionUID
(die gleich sein soll für beide versionen der klasse).
was passiert nun?


 */
