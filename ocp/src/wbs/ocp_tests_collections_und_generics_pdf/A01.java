package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//nennen sie 3 interfaces, die eine methode namens foreach() deklarieren
// iterable<T> ->parameter  consumer <? super T>  
// Stream -> consumer <? super T> 
// Map -> BiConsumer <? super k , ? super V>


//wie ist die obige methode jeweils parametrisiert?
//

//welcher zusammenhang besteht zwischen Iterable und der foreach- schleife?
// iterator :: 

//nennen sie die 3 wichtigsten subinterfaces von Collection
// List , Set , Dequeue

//nennen sie eine thread-sichere List-implementierung in java.util
// Vector

//nennen sie eine thread-sichere Map-implementierung in java.util
// Hashtable

//bitte geben sie für jeden der blöcke von A bis H an, was passiert, wenn die
//auskommentierung zurückgenommen wird (jeweils unabhängig voneinander).
//

//gibt es einen compilerfehler, eine exception, eine ausgabe?
//

// type sicher java  sind ?
public class A01 {
	public static void main(String[] args) {
		Integer[] ia1 = { 4, 2, 3, 3, 4 }; // integer hat natural ordering
		AtomicInteger[] ia2 = { new AtomicInteger(1), new AtomicInteger(4), new AtomicInteger(2), new AtomicInteger(3),
				new AtomicInteger(3), new AtomicInteger(4) }; // atomic integer hat kein natural ordering , arrays sind nicht type sicher
		List<Integer> list1 = Arrays.asList(ia1); 
		List<AtomicInteger> list2 = Arrays.asList(ia2);
//A
  Arrays.sort(ia1);
  System.out.println(Arrays.toString(ia1)); // [2, 3, 3, 4, 4] bedoone tostring hash miad nakhanas
//B
//Arrays.sort(ia2);
//System.out.println(Arrays.toString(ia2)); // java.lang.ClassCastException: java.util.concurrent.atomic.AtomicInteger cannot be cast to java.lang.Comparable
  
//C
Arrays.sort(ia1, null); // sort methode null als comparator -> natural ordering und nicht nulklpoiunt exception
System.out.println(Arrays.toString(ia1)); // [2, 3, 3, 4, 4]

//D
// Arrays.sort(ia2, null);   java.lang.ClassCastException
// System.out.println(Arrays.toString(ia2)); 

//E
list1.sort(null); // kein nullpointerexception and its ok
System.out.println(list1); // [2, 3, 3, 4, 4]
//F
//list2.sort(null);
//System.out.println(list2); // java.lang.ClassCastException: java.util.concurrent.atomic.AtomicInteger cannot be cast to java.lang.Comparable
//G
Collections.sort(list1);
System.out.println(list1); // [2, 3, 3, 4, 4]
//H
//Collections.sort(list2); compiler fehler chon compartor nist age dasht mishod
//System.out.println(list2);
	}
}