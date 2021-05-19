package wbs.nasted_classes;

public class AnonymousDemo4 {
	private int n;
	Object o = new Object() {
		int feld = n;
	};
	
	private static void m() {
		System.out.println("m klass");
	}
	
	Object o2 = new Object() {
		public void m() {
			System.out.println("m subklass");
		}
	};
	public static void main(String[] args) {
		m();
		
	}
	
	
}
