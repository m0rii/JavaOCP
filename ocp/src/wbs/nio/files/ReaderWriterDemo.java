package wbs.nio.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class ReaderWriterDemo {
	public static void main(String[] args) {
		Path in = Paths.get("resources/io/java_keywords.txt");
		Path out = Paths.get("resources/io/java_keywords_cp.txt");
		String line;
		try (BufferedReader br = Files.newBufferedReader(in, Charset.forName("UTF-8"));
				BufferedWriter bw = Files.newBufferedWriter(out, Charset.forName("UTF-8"), StandardOpenOption.CREATE,
						StandardOpenOption.DSYNC)) {
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
