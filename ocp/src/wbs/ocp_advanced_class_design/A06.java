package wbs.ocp_advanced_class_design;

//compilerfehler?
//ausgabe?
public class A06 {
	public static void main(String[] args) {
		int n = 5;
		class C {
			int m = n; // n muss efektive final sein 
			// lokal klass parameter muss efektive final sein
		}
	//	n++;
		System.out.println(n);
	}
}