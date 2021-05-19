package wbs.nio.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StreamDemo {
	public static void main(String[] args) {
		Path in = Paths.get("bin/wbs/nio/files/StreamDemo.class");
		Path out = Paths.get("resources/io/StreamDemo.class");
		int size = 1024;
		byte[] buffer = new byte[size];
		try (InputStream is = Files.newInputStream(in, StandardOpenOption.READ);
				OutputStream os = Files.newOutputStream(out, StandardOpenOption.CREATE_NEW)) { // StandardOpenOption.CREATE_NEW age nanevisim hey dobare misaze va exception nemide
			while (is.read(buffer, 0, size) != -1) {
				os.write(buffer, 0, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
was passiert, wenn die zieldatei bereits existiert?  java.nio.file.FileAlreadyExistsException:
was passiert, wenn die quelldatei nicht existiert? NoSuchfileException from nio exception
was liefert read() von InputStream am dateiende?
wie könnte der code so umgeschrieben werden, dass
ausschliesslich klassen aus java.io verwendet werden?
was macht die hier verwendete read()- methode genau?
was macht die hier verwendete write()- methode genau?
*/










