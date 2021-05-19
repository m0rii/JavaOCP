package wbs.nio.path;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// wir erkunden die spielregeln von toRealPath()

public class ToRealPathDemo {

        public static void main(String[] args) throws IOException {
                // - wirft IOException!
                // - die angegebene datei m u s s existieren!
                // - normalisierung!
                // - umwandlung in absoluten pfad (nach vorheriger normalisierung)!
                // - symbolischen links wird per default gefolgt!
                // - das kann mit dem argument LinkOption.NOFOLLOW_LINKS geändert
                //   werden!

                Path p1 = Paths.get("dummy");
                
                Path p2 = Paths.get("../ocp/src");

                Files.deleteIfExists(p1);

                try {
                        System.out.println(p1.toRealPath());
                } catch (IOException e) {
                        System.out.println(e);  // NoSuchFileException

                }
                try {
                        System.out.println(p2.toRealPath());
                        System.out.println(p2.toAbsolutePath());
                        System.out.println(p2.toAbsolutePath().normalize());
                        System.out.println(p2.toRealPath().equals(p2.toAbsolutePath()
                                .normalize()));
                } catch (IOException e) {
                        System.out.println(e);
                }

        }
}
