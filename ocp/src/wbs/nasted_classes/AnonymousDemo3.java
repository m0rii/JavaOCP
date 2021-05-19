package wbs.nasted_classes;

public class AnonymousDemo3 {
	void m1(int n) {
		Object o = new Object() {
      int feld = n; // java 8 n ro chek mikone impilizit final bashe
		};
	//	n = 5; inja n bashe bala compile nemishe
	}

	void m2(final int n) {
		Object o = new Object() {
			int feld = n;
		};
	}
}
