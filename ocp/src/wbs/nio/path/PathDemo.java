package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
	public static void main(String[] args) {
		String s = "src\\wbs\\nio\\PathDemo.java"; // warum zwei bacckslash ? :  
		Path path = Paths.get(s);
		System.out.println(path.toAbsolutePath()); // C:\Users\Administrator\eclipse-workspace\ocp\src\wbs\nio\PathDemo.java
		System.out.println(path.getNameCount()); // 4
		System.out.println(path.getRoot()); // null
		System.out.println(path.toAbsolutePath().getRoot()); // C:\
		System.out.println(path.getFileName()); // PathDemo.java
		System.out.println(path.getParent()); // src\wbs\nio
		System.out.println(path.toUri()); // file:///C:/Users/Administrator/eclipse-workspace/ocp/src/wbs/nio/PathDemo.java
		
	
		for (Path pathElement : path) {
			System.out.println(pathElement);
		} 
		/*
		 * src
           wbs
           nio
           PathDemo.java
		 */
		
		// path.forEach(s2->System.out.println(s2));
	}
}
