package wbs.nio.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
 // wie StreamDemo aber wir verwenden ausschlisselich klassen aus io und keine aus nio
public class MoreStreamDemo {
	public static void main(String[] args) {
		File in = new File ("bin/wbs/nio/files/StreamDemo.class");
		File out = new File("resources/io/StreamDemo.class");
		int size = 1024;
		byte[] buffer = new byte[size];
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(in));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(out))) { // StandardOpenOption.CREATE_NEW age nanevisim hey dobare misaze va exception nemide
			while (bis.read(buffer, 0, size) != -1) {
				bos.write(buffer, 0, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}