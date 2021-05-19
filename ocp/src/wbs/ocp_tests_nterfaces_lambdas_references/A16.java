package wbs.ocp_tests_nterfaces_lambdas_references;

//compilerfehler?
//exception?
//ausgabe
interface I161 {
	default void m() {
		System.out.println("a");
	}
}

interface I162 {
	default void m() {
		System.out.println("b");
	}
}

public class A16 implements I161, I162 {
	public static void main(String[] args) {
		new A16().m();
	}

	@Override
	public void m() {
		I161.super.m();
	}
}
