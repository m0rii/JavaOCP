package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.List;

//welche blöcke können aktiviert werden?
public class A10 {
	
//A

public static void m1(List<? super Number> list) {
 // Number n =  list.get(0); // diese zeile geht nicht 
list.add(3);
}

	
//B

public static void m2(List<? extends Number> list) {
Number n = list.get(0);
 // list.add(3); diese geht nicht  , list kann double sein
}

	
//C

public static Object m3(List<?> list) { // ? nur add(null) geht aber list von object alles geht 
return list.get(0);
}

}