package wbs.ocp_tests_collections_und_generics_pdf;

//welche zeilen liefern einen compilerfehler?
//welche zeilen werfen eine exception?
//welche zeilen werden fehlerfrei compiliert und ausgeführt?
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A02 {
	public static void main(String[] args) {
		List<StringBuilder> sbList = Arrays.asList(new StringBuilder(), new StringBuilder());
		List<String> sList = Arrays.asList("c", "a", "b");
//A
//Collections.sort(Arrays.asList(sbList); compiler fehler
		                     
//B
//Collections.sort(sbList, null); // java.lang.ClassCastException

//C
Collections.sort(Arrays.asList("c", "a", "b"));

//D
Collections.sort(Arrays.asList("c", "a", "b"), null);
	}
}