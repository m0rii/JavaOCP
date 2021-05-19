package wbs.generics;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.BiPredicate;

class Stellenangebot {

	private String bezeichnung;
	private int gebotenesGehalt;

	public Stellenangebot(String bezeichnung, int gebotenesGehalt) {
		this.bezeichnung = bezeichnung;
		this.gebotenesGehalt = gebotenesGehalt;
	}

	@Override
	public String toString() {
		return bezeichnung + "(" + gebotenesGehalt + ")";
	}

	public int getGebotenesGehalt() {
		return gebotenesGehalt;
	}

	public void setGebotenesGehalt(int gebotenesGehalt) {
		this.gebotenesGehalt = gebotenesGehalt;
	}
}

class Stellensuchender {

	private String name;
	private int wunschGehalt;

	public Stellensuchender(String name, int wunschGehalt) {
		this.name = name;
		this.wunschGehalt = wunschGehalt;
	}

	public int getWunschGehalt() {
		return wunschGehalt;
	}

	public void setWunschGehalt(int wunschGehalt) {
		this.wunschGehalt = wunschGehalt;
	}

	@Override
	public String toString() {
		return name + "(" + wunschGehalt + ")";
	}

}

public class CandidatesDemo {

	public static void main(String[] args) {

		Random random = new Random();

		Set<Stellenangebot> angebote = new HashSet<>();
		Set<Stellensuchender> suchende = new HashSet<>();
		Set<Stellenangebot> candidates;

		for (int i = 1; i <= 10; i++) {
			angebote.add(new Stellenangebot("angebot" + i, random.nextInt(5000)));
		}

		for (int i = 1; i <= 10; i++) {
			suchende.add(new Stellensuchender("suchender" + i, random.nextInt(5000)));
		}
		

		/*
		 * wir listen nun für jeden stellensuchenden alle stellenangebote auf, die zum
		 * stellensuchenden passen. wir nehmen an, dass ein angebot passt, wenn der
		 * unterschied zwischen wunschgehalt und gebotenem gehalt kleiner oder gleich
		 * 500 ist.
		 */
		BiPredicate<Stellensuchender, Stellenangebot> predicate = (s,a) ->{
			int diff = Math.abs(s.getWunschGehalt()-a.getGebotenesGehalt());
			return diff <= 500 ;
		};
		
		for(Stellensuchender suchender : suchende) {
			candidates = SetUtil.candidates(suchender, angebote, predicate);
			System.out.println(suchender);
			System.out.println(candidates);
			System.out.println("------------------------");
		}
	
	
	}
}
