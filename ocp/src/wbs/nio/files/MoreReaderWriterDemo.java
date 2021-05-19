package wbs.nio.files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MoreReaderWriterDemo {
        
        public static void main(String[] args) {
                String in = "resources/io/lines.txt";
                String out = "resources/io/lines_cp.txt";
                String line;
                try (BufferedReader br = new BufferedReader(new FileReader(in));
                                BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
                        while ((line = br.readLine()) != null) {
                                bw.write(line);
                                bw.newLine();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                
                // additional stuff...
                System.out.println(System.getProperty("file.encoding"));
                
                System.out.println("------------");
                
                Properties props = System.getProperties();
                props.forEach((k,v) -> System.out.println(k + " -> " + v));
        }
}
