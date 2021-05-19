package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.ArrayList;
import java.util.List;

//ausgabe
public class A11 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(1);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		System.out.println(list); // [2, 4, 6, 8]
		
		list.remove(2);
 // Parameters:index the index of the element to be removed
		System.out.println(list); // [2, 4, 8]
		
		
		list.remove(Integer.valueOf(2));
//	boolean java.util.List.remove(Object o)
// Parameters:o element to be removed from this list, if present  , Returns:true if this list contained the specified element
		
		System.out.println(list); // [4, 8]
	}
}