package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// welche ausgabe erzeugt der nachstehende code?
class A161 implements Comparable<A161> {
	String vorname;
	String nachname;

	public A161(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[vorname=" + vorname + ", nachname=" + nachname + "]";
	}

	@Override
	public int compareTo(A161 a161) {
		int diff = nachname.compareTo(a161.nachname); // aval family check mikone
		return diff != 0 ? diff : vorname.compareTo(nachname); // age mosavi boodan esm ro chek mikone
	}
}

class A162 extends A161 {
	public A162(String vorname, String nachname) {
		super(vorname, nachname);
	}
}

public class A16 {
	public static void main(String[] args) {
		A162 bernd = new A162("bernd", "maurer");
		A162 anna = new A162("anna", "mechatroniker");
		A162 dieter1 = new A162("dieter", "klempner");
		A162 dieter2 = new A162("dieter", "klempner");
		List<A161> list = Arrays.asList(bernd, anna, dieter1, dieter2);
		list.sort(Comparator.naturalOrder());
		list.forEach(System.out::println);
		/*
		 *   A162[vorname=dieter, nachname=klempner]
             A162[vorname=dieter, nachname=klempner]
             A162[vorname=bernd, nachname=maurer]
             A162[vorname=anna, nachname=mechatroniker]
		 */
	}
}