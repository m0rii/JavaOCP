package wbs.stream.references;

import java.util.stream.Stream;

public class InstanceMethodOfTypeDemo {
	public static void main(String[] args) {
		Stream.of("A", "BB", "CCC", "DDDD").mapToInt(String::length).forEach(System.out::println);
		System.out.println("==========lambda============");
		Stream.of("A", "BB", "CCC", "DDDD").mapToInt(a-> a.length()).forEach(a-> System.out.println(a));
	}
}

