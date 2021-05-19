package wbs.nio.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

class MySimpleFileVisitor implements FileVisitor<Path> {
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {
                System.out.println("preVisitDirectory -> " + dir.toAbsolutePath());
                return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
                System.out.println("visitFile -> " + file.toAbsolutePath());
                return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult postVisitDirectory(Path dir,
                        IOException ioe) throws IOException {
                System.out.println("postVisitDirectory -> " + dir.toAbsolutePath());
                return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc)
                        throws IOException {
                System.out.println("visitFileFailed -> " + exc);
                return FileVisitResult.CONTINUE;
        }
}

public class WalkFileTreeDemo {
        public static void main(String[] args) throws IOException {
                Files.walkFileTree(Paths.get("src"), new MySimpleFileVisitor());
        }
}
