package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.ArrayList;
import java.util.List;

//in welchen zeilen kann die auskommentierung zurückgenommen werden,
//ohne dass es einen compilerfehler gibt?
public class A03 {
	public static void main(String[] args) {
		List<CharSequence> l11; 
		List<? extends CharSequence> l12;
		List<? super CharSequence> l13;
		List<StringBuffer> l21 = new ArrayList<>();
		List<StringBuilder> l22 = new ArrayList<>();
		List<String> l23 = new ArrayList<>();
		List<Object> l24 = new ArrayList<>();
		
		
//A
// l11 = l21; Type mismatch: cannot convert from List<StringBuffer> to List<CharSequence>
// 	compiler checked typesicherheit  
		
//B
l12 = l21; // ja das geht String , StringBuffer , StringBuilder = IS-A Charsequence

//C
//l13 = l23; // compiler fehler , Type mismatch: cannot convert from List<String> to List<? super CharSequence>
// String kein super klasse von Charsequence

//D
l13 = l24; // object ist superklasse von charsequence

	}
}
