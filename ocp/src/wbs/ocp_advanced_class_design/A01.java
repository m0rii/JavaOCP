package wbs.ocp_advanced_class_design;

//welche sichtbarkeit dürfen konstruktoren eines enum nicht haben?
// protected , public

//wann muss nach der deklaration der letzten konstanten eines enum ein semikolon stehen?
// wenn enum hat egentliche class
//haben enums ein natural ordering?
// ja , 

//welche der folgenden methoden können in einem enum überschrieben werden?
//toString(), equals(), hashCode()? nur toString geht


//was muss man beachten bei einem switch-case über einen enum?
// constantant unqualizifiert

//welcher zusammenhang besteht zwischen enums und anonymen klassen?
// 

//welche methoden bekommt man frei haus, wenn man einen enum definiert?
// toString , values -> static und return type ist ein array element von array ist konstant au enum
// ordinal type ist Integer und erste konstant istr 0 , name methode nicht statice methode liefert bezeichnen den konstanten als string

//welche der obigen methoden sind static? bala j dadam

//welche der folgenden zeilen können ohne compilerfehler aktiviert werden?

public class A01 {
	class C {
		int m = 2;
	}

	static class D {
	}

	public static void main(String[] args) { // agfe methode main static nabood mishod
	//	C c = new C(); // geht nich , nich static  , instance
		D d = new D();
		A01.D a1d = new D();
		C a1c = new A01().new C();
		C a2c = new A01().new C();
	}
}
