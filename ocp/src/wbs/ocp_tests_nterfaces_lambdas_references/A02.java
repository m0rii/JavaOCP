package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

//welche streams für primitive datentypen gibt es?
//wie lautet die definition der nachfolgenden functional interfaces
//(type-parameter, parameter types, return type, bezeichner der abstrakten methode)
//IntFunction
//ToIntFunction type T rein Int zuruck
//IntConsumer 
//IntSupplier
//IntPredicate
//IntToLongFunction
//IntToDoubleFunction
//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt er?
public class A02 {
	
	public static int f(int i1, int i2) {
		
		return i1 + i2;
	}

	public static void f() {
		IntBinaryOperator op1 = A02::f;// binary opertaopr braucht 2 int
		IntConsumer consumer = System.out::println;
		OptionalInt o = IntStream.rangeClosed(1, 10).reduce(op1);
		o.ifPresent(consumer);
	}

	public static void main(String[] args) {
		A02.f();
	}
}