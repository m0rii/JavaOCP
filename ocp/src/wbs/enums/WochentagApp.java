package wbs.enums;

import java.util.Arrays;
import java.util.TreeSet;

enum Wochentag {
	MO, DI, MI, DO, FR, SA, SO
}

public class WochentagApp  {
	public static void m(Wochentag tag) {
		switch (tag) {
		case MO:
		case DI:
		case MI:
		case DO:
		case FR:
System.out.println("arbeitstag");
			break;
		case SA:
// do some stuff
			break;
		case SO:
// do some stuff
			break;
		default:
// strange!
			break;
		}
	}
	
	// enum hat natural ordering Comparable

	public static void main(String[] args) {
		Wochentag[] values = Wochentag.values();
		for (Wochentag tag : values) {
			System.out.println(tag.name() + " " + tag.ordinal());
		}
		
		System.out.println(Wochentag.MI.getClass()); //  class wbs.enums.Wochentag
		
		// natural ordering
		
		System.out.println(new TreeSet<>(
				Arrays.asList(Wochentag.SA,Wochentag.MO,Wochentag.FR)));
		
		m(Wochentag.MI);

}
}
