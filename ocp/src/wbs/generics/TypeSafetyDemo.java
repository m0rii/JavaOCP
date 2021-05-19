package wbs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeSafetyDemo {

	public static void main(String[] args) {
		Object[] oa = {1,"aha",4.0,66};
		String[] sa = {"aha","nana"};
		oa = sa;
	 //  oa[0] = 17; // compiler okay , aber runtime java.lang.ArrayStoreException
		
		
		
		// bitte uebertragt das Beispiel von Array auf List
		List<Object> ol =new ArrayList<>();
		List<? extends Object> olExtends = new ArrayList<>();
		ol.add(1);
		ol.add("aha");
		ol.add(4.0);
		ol.add(66);
		
		List<String> sl =new ArrayList<>();
	//	List<? extends String> slExtends = new ArrayList<>();
		sl.add("aha");
		sl.add("nana");
		
		
	
	// ol = sl; compilerfehler!
		olExtends = sl; // ok!
		System.out.println(olExtends);
	//	olExtends = slExtends; // ok!
	//	olExtends.add(17); compilerfehler! 
		
		
		List<StringBuilder> bl = new ArrayList<StringBuilder>();
        olExtends = bl;
        
        
        
	}

}
