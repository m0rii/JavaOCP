package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

//compilerfehler?
//exception?
//ausgabe?
public class A15 {
	public static void main(String[] args) {
		IntUnaryOperator op1 = n -> 1 / n;
		IntUnaryOperator op2 = n -> n * 2;
		IntUnaryOperator op = op2.andThen(op1);
		IntConsumer consumer = System.out::println;
		IntStream.rangeClosed(0, 5).map(op).forEach(consumer);
	}
}