package wbs.generics;

import java.util.ArrayList;
import java.util.List;

class Frucht{
}

class Apfel extends Frucht {
}

class Birne extends Frucht {
}


public class WildcardDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Frucht> fruechte = new ArrayList<>();
		
		// auf extendsFruechte darf jede List zugewiesen werden, deren deklarierte elementyp Frucht oder ein subtyp von Frucht ist.
		List<? extends Frucht > extendsFruechte = new ArrayList<>(); 
		List<Apfel> apfels = new ArrayList<>();
		List<Birne> birnens = new ArrayList<>();
	//	extendsFruechte = new ArrayList<Apfel>(); // ok
	//	extendsFruechte = new ArrayList<Birne>(); // ok
		extendsFruechte = apfels; // ok
		apfels.add(new Apfel()); // ok
		extendsFruechte = birnens; // ok
		birnens.add(new Birne());// ok type Birne
	//extendsFruechte.add(new Birne()); // compilerfehler
		// extendsFruechte.add(new Apfel()); // compilerfehler
		
		
		// auf extendsFruechte darf jede List zugewiesen werden, deren deklarierte elementyp Frucht oder ein supertyp (basistyp) von Frucht ist.
		List<? super Frucht> superFruechte = new ArrayList<>();
		superFruechte.add(new Apfel()); // ok
		superFruechte.add(new Birne()); // ok
		superFruechte.add(new Frucht()); // ok
	  // superFruechte.add(new Object()); // geht nicht , warum? weil <? super Frucht> ist nicht garantiert
		superFruechte.add(null);
		
		
		fruechte.add(new Apfel()); // ok
		fruechte.add(new Birne()); // ok
		List<Birne> birnen = new ArrayList<>();
        // fruechte = birnen; // compilerfehler nemitoone joz <Frucht> type dige ei dashte bashe
		
		extendsFruechte.add(null); // ok
		Frucht frucht = extendsFruechte.get(0); // ok

// frucht = superFruechte.get(0); // compilerfehler
		Object o = superFruechte.get(0); // ok
	}
}