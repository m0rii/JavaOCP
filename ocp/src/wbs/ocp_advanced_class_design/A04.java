package wbs.ocp_advanced_class_design;

//welche der folgenden behauptung sind richtig:
//beim compilieren eines enum wird stets genau eine class- datei erzeugt. falshe 

//enums dürfen keine abstrakten methoden deklarieren. falsch aber 

//compilerfehler? nein
//ausgabe? b 
public class A04 {
	abstract class C {
		CharSequence m() {
			return "a";
		}
	}

	static void m(C c) {
		System.out.println(c.m());
	}

	public static void main(String[] args) {
		m(new A04().new C() {
			@Override
			CharSequence m() { // String , Stringbuilder and Stringbuffer auch geht
//TODO Auto-generated method stub
				return "b";
			}
		});
	}
}