package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

// wie lautet die definition der nachfolgenden functional interfaces
//(typ-parameter, parameter types, return type, bezeichner der abstrakten methode)
// IntUnaryOperator
// IntBinaryOperator
// ToIntFunction
// ToIntBiFunction
// DoubleToIntFunction
// LongToIntFunction
// ausgabe
public class A12 {
	public static void main(String[] args) {
		IntUnaryOperator op1 = (n) -> n + 1;
		IntUnaryOperator op2 = n -> n * 2;
		IntConsumer consumer = System.out::println;
		IntStream.rangeClosed(1, 5).map(op1.andThen(op2)).forEach(consumer);
	}
}