package wbs.io;

import java.io.File;
import java.io.IOException;
 
public class CanonicalPathDemo {
        
        public static void main(String[] args) throws IOException{
                
                File file = new File("src/abc/../../cde");
                
                String asString = file.getCanonicalPath();
                File asFile = file.getCanonicalFile();
                
                System.out.println(asString);
                System.out.println(asFile);
        }
}

 
