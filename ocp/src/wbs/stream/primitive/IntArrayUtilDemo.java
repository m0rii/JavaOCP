package wbs.stream.primitive;

import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;

public class IntArrayUtilDemo {

	public static OptionalInt reduce(int[] ia, IntBinaryOperator op) {
		OptionalInt result;
		if (ia.length == 0) {
			result = OptionalInt.empty();
		} else {
			int val = ia[0];
			for (int i = 1; i < ia.length; i++) {
				val = op.applyAsInt(val, ia[i]);
			}
			result = OptionalInt.of(val);
		}
		return result;
	}

	public static int reduce(int[] ia, int identity, IntBinaryOperator op) {
		int result = identity;
		for (int i = 0; i < ia.length; i++) {
			result = op.applyAsInt(result, ia[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] ia0 = {};
		int[] ia1 = { 10 };
		int[] ia = { 1, 2, 3, 4, 5 };

		IntBinaryOperator plus = (n1, n2) -> n1 + n2;
		IntBinaryOperator mal = (n1, n2) -> n1 * n2;

		System.out.println("---- array ohne identity -----");

		System.out.println(reduce(ia0, plus)); // kein identity , ia0 length is 0 dann optional empty
		System.out.println(reduce(ia1, plus));// 10
		System.out.println(reduce(ia, plus)); // 15
		System.out.println(reduce(ia0, mal)); // wieder leer
		System.out.println(reduce(ia1, mal)); // 10
		System.out.println(reduce(ia, mal)); // 120 -> 1 * 2 * 3 * 4 * 5

		System.out.println("---- stream ohne identity -----");

		System.out.println(Arrays.stream(ia0).reduce(plus)); 
		System.out.println(Arrays.stream(ia1).reduce(plus));
		System.out.println(Arrays.stream(ia).reduce(plus));
		System.out.println(Arrays.stream(ia0).reduce(mal));
		System.out.println(Arrays.stream(ia1).reduce(mal));
		System.out.println(Arrays.stream(ia).reduce(mal));

		System.out.println("---- array mit identity -----");

		System.out.println(reduce(ia0, 0, plus)); // 0
		System.out.println(reduce(ia1, 0, plus)); // 10
		System.out.println(reduce(ia, 0, plus)); // 15
		System.out.println(reduce(ia0, 1, mal)); // 1
		System.out.println(reduce(ia1, 1, mal)); // 10
		System.out.println(reduce(ia, 1, mal)); // 120

		System.out.println("---- stream mit identity -----");

		System.out.println(Arrays.stream(ia0).reduce(0, plus)); // wie oben
		System.out.println(Arrays.stream(ia1).reduce(0, plus));
		System.out.println(Arrays.stream(ia).reduce(0, plus));
		System.out.println(Arrays.stream(ia0).reduce(1, mal));
		System.out.println(Arrays.stream(ia1).reduce(1, mal));
		System.out.println(Arrays.stream(ia).reduce(1, mal));

	}

}
