package wbs.nio.files;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class JavaKeywordsStatistikDemo1 {
	///          Guenter kurs

        public static void main(String[] args) throws IOException {
                
                String pathToKeywords = "resources/io/java_keywords.txt";
                String pathToSrc = "src";
                
                Map<String, AtomicInteger> statistik = new TreeMap<>();

                Comparator<Map.Entry<String, AtomicInteger>> cmp1 = (e1, e2) -> Integer
                                .compare(e2.getValue().intValue(), e1.getValue().intValue());
                
                Comparator<Map.Entry<String, AtomicInteger>> cmp2 = (e1, e2) -> e1
                                .getKey().compareTo(e2.getKey());
                
                Comparator<Map.Entry<String, AtomicInteger>> cmp = cmp1
                                .thenComparing(cmp2);

                Consumer<Path> consumer = p -> {
                        try {
                                Files.lines(p).flatMap(s -> Arrays.stream(s.split("\\W+")))
                                                .forEach(word -> statistik.computeIfPresent(word,
                                                                (s, a) -> {
                                                                        a.getAndIncrement();
                                                                        return a;
                                                                }));
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }
                };

                try (Stream<String> lines = Files.lines(Paths.get(pathToKeywords))) {
                        
                        // map aufbauen
                        lines.flatMap(s -> Arrays.stream(s.split(","))).forEach(
                                        s -> statistik.merge(s, new AtomicInteger(0), (k, v) -> v));
                        
                        // map bestücken
                        Files.find(Paths.get(pathToSrc), Integer.MAX_VALUE,
                                        (p, f) -> p.toString().endsWith(".java")).forEach(consumer);
                }

                System.out.println("  --- aphabetisch aufsteigend ---");
                statistik.forEach((k, v) -> System.out.println(k + " -> " + v));

                System.out.println(
                                "  --- absteigend nach häufigkeit / alphabetisch aufsteigend ---");
                statistik.entrySet().stream().sorted(cmp).forEach(
                                (e -> System.out.println(e.getKey() + " -> " + e.getValue())));
        }

}






