package wbs.io;

import java.io.File;
import java.util.Arrays;
 
public class FilterDemo {
        
        public static void main(String[] args) {
                
                String path = "resources/io";
                File dir = new File(path);
                                
                Arrays.stream(dir.listFiles(f ->  {
                                return f.length() > 10 && f.length() < 50;
                        }
                )).forEach(System.out::println);
                
                System.out.println("------------");
                
                Arrays.stream(dir.listFiles((f, n) -> {
                                return n.endsWith(".txt");
                        }
                )).forEach(System.out::println);
                
        }
}
