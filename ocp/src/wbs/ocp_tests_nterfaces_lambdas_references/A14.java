package wbs.ocp_tests_nterfaces_lambdas_references;

//compilerfehler?
//exception?
//ausgabe?
interface I141 {
	double distance(double point, double x);
}

public class A14 {
	public static void distances(double point, double[] da, I141 metric) {
		for (double x : da) {
			System.out.println(metric.distance(point, x));
		}
	}

	public static void main(String[] args) {
		double point = 3;
		double[] da = { 1, 2, 3, 4, 5 };
	//	distances(point, da, (p, x) -> Math.abs(point - x)); //Local variable point defined in an enclosing scope must be final or effectively final
		point = 3;
	//	distances(point, da, (p, x) -> Math.abs(point - x));
	}
}