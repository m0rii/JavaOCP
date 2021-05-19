package wbs.stream.references;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class StaticMethodReferenceDemo {
	public static void m1(Supplier<Double> supplier) {
		// achtung h i e r heisst es get()...
		System.out.println(Math.sqrt(supplier.get()));
	}

	public static void m2(DoubleSupplier supplier) {
		// ... und h i e r getDouble
		System.out.println(Math.sqrt(supplier.getAsDouble()));
	}

	public static void main(String[] args) {
		// ok , die statiche methode random() von Math hat keine parameter 
		// und liefert einen Double, der ueber autoboxing zu einem Double geboxt werden kann
		Supplier<Double> supplier1 = Math::random;
		
		// ok. die statiche methode random() von Math hat keine parametr und liefert einen double
		DoubleSupplier supplier2 = Math::random; // besser performance weil ohne autoboxing ist
		m1(supplier1);
		m2(supplier2);
	}
}