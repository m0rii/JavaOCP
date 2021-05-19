package wbs.io.serialization;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;
import wbs.jdbc.dao.Buch;
import wbs.jdbc.dao.DAOFactory;

/*
 * wir lesen alle bücher aus der tabelle buch aus
 * (unter verwendung des dao), und speichern sie serialisiert
 * in der datei resources/io/books.ser
 */
public class SerializeBooksDemo {

        public static void main(String[] args) throws IOException {
        	List<Buch> buecher = DAOFactory.getBuchDAO().findAll();
        	String path = "resources/io/book.ser";
        	try(ObjectOutput oos = new ObjectOutputStream(
        			new BufferedOutputStream(new FileOutputStream(path)))){
        		oos.writeObject(buecher);
        	}

        }
}
