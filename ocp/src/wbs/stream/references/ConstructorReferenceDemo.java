package wbs.stream.references;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceDemo {
	static class C {
		String s;
		Integer i;
		
		public C(String s , Integer i) {
			this.s = s;
			this.i = i;
		}
		@Override
		public String toString() {
			
			return "C [s= " + s + " , i=" + i +"]";
		}
	}
        public static void main(String[] args) {
                
                Supplier<Random> supplier = Random::new; // random ye cunstructor bedoon parametr dare va suppplier baremigardoone radiiif
                Function<String, Integer> function1 = Integer::new; // Integer cunstructor dare string begire va integer bede pas kar mikone radif
                                
                System.out.println(supplier.get().nextInt(1000));
                System.out.println(function1.apply("123"));
                
                BiFunction<String, Integer,C> bifunction = C::new;
                System.out.println(bifunction.apply("eins", 1));
                
        }
}