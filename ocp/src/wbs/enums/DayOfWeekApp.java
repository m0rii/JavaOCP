package wbs.enums;

import java.io.Serializable;


enum DayOfWeek {
	MO("montag"), DI("dienstag"); // semikolon ist notwendig

// class body
	private String bez;

	private DayOfWeek(String bez)  { // private oder default , kann nicht public oder protected schreiben 
		this.bez = bez;
	}

	public String getBez() {
		return this.bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	
	@Override
	public String toString() {
		return this.bez;
	}
}

public class DayOfWeekApp {
	public static void main(String[] args) throws Exception {
		DayOfWeek day = DayOfWeek.MO;
		System.out.println(day); // montag
		day.setBez("monday");
		System.out.println(day); // monday
		System.out.println(day.name()); // MO , kann man nicht andern
	}
}
