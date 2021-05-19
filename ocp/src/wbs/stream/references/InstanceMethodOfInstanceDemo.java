package wbs.stream.references;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodOfInstanceDemo {
	static class C {
		int n;

		void m(String s) {
			System.out.println(n + ":" + s.length());
			n++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		List<String> names = Arrays.asList("A", "BBB", "CC", "DDDD");
		C c = new C();
		// hie wird uener jedes element von names iteriet , und bei 
		// jedem iterationschritt fuer das durch c referenzierte objekt
		// die methode m aufgerufen
		
		names.forEach(c::m); // age m 2ta parametr dasht nemishe azin methodereferenz estefade kard
		
		System.out.println("============ mit lambda ============");
		C c2 = new C();
		names.forEach(s->c2.m(s));
	}
}
