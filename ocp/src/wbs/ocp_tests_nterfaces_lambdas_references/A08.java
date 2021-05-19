package wbs.ocp_tests_nterfaces_lambdas_references;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt der code?
@FunctionalInterface
interface FI81 {
	int m(String s);
}

@FunctionalInterface
interface FI82 {
	int m(String s1, String s2);
}

public class A08 {
	public static int f1(FI81 fi81) {
		return fi81.m("abc");
	}

	public static void f2(FI82 fi82) {
	}

	public static void main(String[] args) {
		int n1 = f1(s -> s.length());
		System.out.println(n1);
	}
}