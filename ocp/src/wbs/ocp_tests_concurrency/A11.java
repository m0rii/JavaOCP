package wbs.ocp_tests_concurrency;

//wann spricht man im kontext von threads von
//- deadlock
// bedutet viele oder zewei treads andere object nehmen und nicht konnen

//- livelock
// 

//- starvation


//compilerfehler bei A?
//compilerfehler bei B?
//compilerfehler bei C?
public class A11 {
	int n;
	static int m;
	Object o;

	void m1(int k) {
//A   // primitive type nicht for synchronized
//synchronized (n) { //   int is not a valid type's argument for the synchronized statement
//System.out.println("aha...");
//}
		
		
//B
//synchronized (m) { // int is not a valid type's argument for the synchronized statement
//System.out.println("aha...");
//}
		
		
//C
synchronized (o) {
System.out.println("aha...");
}
	}
}
