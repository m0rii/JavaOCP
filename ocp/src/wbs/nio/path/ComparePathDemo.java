package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePathDemo {
	public static void main(String[] args) {
		String s1 = "src\\wbs\\nio\\ComparePathDemo.java";
		String s2 = ".\\src\\wbs\\nio\\ComparePathDemo.java";
		Path p1 = Paths.get(s1);
		Path p2 = Paths.get(s2);
            // -37
		System.out.println(p1.compareTo(p2));
              // false
		System.out.println(p1.equals(p2));
              // toAbsolutePath() normalisiert nicht...
              // false
		System.out.println(p1.toAbsolutePath().equals(p2.toAbsolutePath()));
                  // true
		System.out.println(p1.equals(p2.normalize()));
		
		System.out.println('S' - '.');
	}
}
