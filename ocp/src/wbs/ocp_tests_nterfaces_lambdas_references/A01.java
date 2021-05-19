package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

//wie lautet die definition der nachfolgenden functional interfaces
//(type-parameter, parameter types, return type, bezeichner der abstrakten methode)
//
//Function   public <R> apply(T parameter); subinterface is UnaryOperator 
//BiFunction  Represents a function that accepts two arguments and produces a result.  	apply(T t, U u)  subinterface is BinaryOperator
//Predicate    boolean test(T t);
//BiPredicate  Represents a predicate (boolean-valued function) of two arguments   test(T t, U u)
//UnaryOperator   takes a single parameter and returns a parameter of the same type. 
//BinaryOperator   takes two parameters and returns a single value. Both parameters and the return type must be of the same type. 
//Consumer          consumes a value without returning any value
//BiConsumer   Represents an operation that accepts two input arguments and returns no result.
//Supplier    represents an function that supplies a value of some sorts.
//Runnable       	run()
//Callable              V - the result type of method call  	call()
//welche der folgenden deklaration sind korrekt?
public class A01 {
	public static void main(String[] args) {
//A
//Supplier<Integer> sup_1 = Integer::new; // Klasse Integer hat keine parameterlose cunstructor
// get methode in supplier ist parameter lose so geht nicht auch in andere lambda form ()-> new Integer()		
		
//B
Function<String, Integer> fun1 = Integer::new;
		
//C
IntFunction<String> fun2 = Integer::toBinaryString; // Integer.toBinaryString(x)
		
//D
ToDoubleFunction<Number> fun3 = Number::doubleValue;
		
//E
//BiConsumer<String, Integer> bi1 = (s, i) -> { return s.length() + i;};
		
//F
		  BiConsumer<String, Integer> bi2 = (s, i) -> { int n = s.length() + i;
		  System.out.println(n); };
		  
		  // mehr las ein parameter so {} is notwendig
		  // semicolona moheme
		 
	}
}
