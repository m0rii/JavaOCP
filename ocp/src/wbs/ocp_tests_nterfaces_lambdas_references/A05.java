package wbs.ocp_tests_nterfaces_lambdas_references;

//wo kann die annotation @FunctionalInterface aktiviert werden?
//A
@FunctionalInterface
interface I1 {
	void m();
}

//B
//@FunctionalInterface
interface I2 {
	static void m() {
	}
}

//C
@FunctionalInterface
interface I3 {
	default void m() {
	}

	void n();
}

//D
@FunctionalInterface
interface I121 extends I1, I2 {
}

//E
@FunctionalInterface
interface I122 extends I1, I2 {
	default void k() {
	}
}

//F
//@FunctionalInterface
interface I123 extends I1, I2 {
	void k();
}