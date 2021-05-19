package wbs.generics;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

class Mensch {

	String name;
	LocalDate geburtsDatum;

	public Mensch(String name, LocalDate geburtsDatum) {
		this.name = name;
		this.geburtsDatum = geburtsDatum;
	}

	@Override
	public String toString() {
		return "Mensch [name=" + name + ", geburtsDatum=" + geburtsDatum + "]";
	}
}

public class PartioningByDemo {

	public static void main(String[] args) {

		Mensch anna = new Mensch("anna", LocalDate.of(2010, 01, 10));
		Mensch bernd = new Mensch("bernd", LocalDate.of(2000, 01, 10));
		Mensch christa = new Mensch("christa", LocalDate.of(1960, 01, 10));
		Mensch dora = new Mensch("dora", LocalDate.of(2001, 12, 11));
		Mensch emil = new Mensch("emil", LocalDate.of(2001, 12, 13));

		Predicate<Mensch> predicate = m -> {
			return ChronoUnit.YEARS.between(m.geburtsDatum, LocalDate.now()) >= 18;
		};

		Set<Mensch> menschen = new HashSet<>();

		menschen.addAll(Arrays.asList(anna, bernd, christa, dora, emil));

		Map<Boolean, Set<Mensch>> partition = SetUtil.partitioningBy(menschen, predicate);
	System.out.println("volljährig: " + partition.get(true));
		System.out.println("minderjährig: " + partition.get(false));
		
		
		System.out.println();
		System.out.println("-----------die Methode foreach von map--------------------");// die Methode foreach von map
		partition.forEach((k,v) -> System.out.println(k+  " -> " + v));
		
		System.out.println();
		System.out.println("----------foreach-schleife ueber Map.Entry--------------------------");// foreach-schleife ueber Map.Entry
		for (Map.Entry<Boolean,Set<Mensch>> entry : partition.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue()); // performance is besser und schneller
		}
		
		
		System.out.println();
		System.out.println(partition);
		
		
	}

}
