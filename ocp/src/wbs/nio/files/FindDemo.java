package wbs.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FindDemo {

	// wir durchlaufen den kompletten verzeichnisbaum von ocp/src
	// und geben den namen und die groesse aller java-files aus,
	// deren groesse zwischen 100 und 300 byte liegt

	// methode: find() von Files

	public static void main(String[] args) throws IOException {

		Path dir = Paths.get("src");

		BiPredicate<Path, BasicFileAttributes> matcher = (path, attrs) -> {
			return attrs.size() >= 100 && attrs.size() <= 300 && path.toString().endsWith(".java");
		};

		Consumer<Path> action = (p) -> {
			System.out.println(p.getFileName() + "(" + p.toFile().length() + ")");
		};

		Comparator<Path> cmp = (p1, p2) -> {
			return p1.getFileName().compareTo(p2.getFileName());
		};

		Files.find(dir, Integer.MAX_VALUE, matcher).sorted(cmp).forEach(action);
	}
}
