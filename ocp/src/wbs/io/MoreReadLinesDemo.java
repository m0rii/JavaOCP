package wbs.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MoreReadLinesDemo {
	public static void main(String[] args) throws IOException {
		String path = "src/wbs/io/MoreReadLinesDemo.java";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Stream<String> lines = br.lines();
			lines.forEach(System.out::println);
			
			
			 // weitere varianten
			// new bufferedReader() von Files
			System.out.println("----------------bufferedReader() von Files-----------------------------");
			Files.newBufferedReader(Paths.get(path)).lines().forEach(System.out::println);
			
			// readAllLines von Files
			System.out.println("-------------------readAllLines von Files--------------------------");
			Files.lines(Paths.get(path)).forEach(System.out::println);
			// lines in classe Files 
			System.out.println("--------------------lines in classe Files -------------------------");
			String s = new String(Files.readAllBytes(Paths.get(path)));
			Arrays.stream(s.split("\\n")).forEach(System.out::println);
		
			
		
			

		}
	}
}
