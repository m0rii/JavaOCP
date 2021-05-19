package wbsocp_tests_Streams;

import java.util.stream.DoubleStream;

//welche der folgenden methoden von Stream sind terminal?
//empty()
//count()
//foreach()
//flatMap()
//filter()
//für welche der folgenden zeilen kann die ausgabe genau vorausgesagt werden? B,C
public class A02 {
	public static void main(String[] args) {
//A
		System.out.println(DoubleStream.of(1.0, 3.0, 2.0, 5.0).parallel().findAny()); //findAny keine garanti und veraussagbar  OptionalDouble[2.0]
//B
		System.out.println(DoubleStream.of(1.0, 2.0, 3.0, 4.0).parallel().findFirst()); // OptionalDouble[1.0]
//C
		System.out.println(DoubleStream.of(1.0, 2.0, 3.0, 4.0).parallel().sorted().findFirst()); // OptionalDouble[1.0]
	}
}