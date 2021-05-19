package wbs.ocp_advanced_class_design;

//compilerfehler?
//exception?
//ausgabe?
interface I141 {
	double distance(double x);
}

public class A14 {
	public static void main(String[] args) {
		double p = 3;
		double[] da = { 1, 2, 3, 4, 5 };
		I141 i141 = new I141() {
			
			public double distance(double y) {
				// anonyme klasse griff das p zu 
			//	return Math.abs(p - y); // Local variable p defined in an enclosing scope must be final or effectively final
			
				return 0; // nur for funktoniert
						
			}
		};
		for (double x : da) {
			System.out.println(i141.distance(p));
		}
		p = 4;
		for (double x : da) {
			System.out.println(i141.distance(p));
		}
	}
}