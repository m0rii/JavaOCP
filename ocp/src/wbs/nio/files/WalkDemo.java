package wbs.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LongSummaryStatistics;

// wir ermitteln für alle java-files im projekt ocp
// - die groesse der kleinsten datei
// - die groesse der groessten datei
// - die mittlere dateigroesse
// - die anzahl aller dateien

// - wir verwenden die methode walk() von Files
// - hinweis: mapToLong() und LongSummaryStatistics könnten nützlich sein...

public class WalkDemo {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("src");

		LongSummaryStatistics statistics = Files.walk(path).filter(p -> p.toString().endsWith(".java"))
				.mapToLong(p -> p.toFile().length()).summaryStatistics();
		System.out.println(statistics);
	}
}
