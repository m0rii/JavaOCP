package wbs.generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// das natural ordering der klasse Person basiert auf dem alter
// wir spendieren einen constructor und eine passende überschreibung von toString()
class Person implements Comparable<Person> {
	String name;
	int alter;
	

	public Person(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.alter, o.alter);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [name=" + name + ", alter=" + alter + "]";
	}
}

// constructor, passende überschreibung von toString()
class Mitarbeiter extends Person  {
	LocalDate einstellungsDatum;

	public Mitarbeiter(String name, int alter,LocalDate einstellungsDatum) {
		super(name,alter);
		this.einstellungsDatum = einstellungsDatum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mitarbeiter [einstellungsDatum=" +einstellungsDatum +", name " + name + ", alter=" + alter + "]";
	}
	
	// klasse Mitarbeiter hat natural ordering (vererb von Person)
	
	
}

public class BinarySearchDemo {

	// wir bestücken eine list mit einigen mitarbeitern.
	// dann sortieren wir die list.
	// dann wenden wir die erste überladung von binarySearch() in geeigneter weise
	// an
	public static void main(String[] args) {
		Mitarbeiter anna = new Mitarbeiter("anna",30,LocalDate.of(2000, 1, 1));
		Mitarbeiter jo = new Mitarbeiter("jo",20,LocalDate.of(1998, 5, 5));
		Mitarbeiter mori = new Mitarbeiter("mori",41,LocalDate.of(1989, 4, 5));
		Mitarbeiter behnaz = new Mitarbeiter("behnaz",36,LocalDate.of(1983, 7, 21));
		
		List<Mitarbeiter> list = Arrays.asList(anna,jo,mori,behnaz);
		Collections.sort(list);
		
		for(Mitarbeiter m : list) {
			System.out.println(m);
		}
		
		
      Mitarbeiter m = anna;
      System.out.println(Collections.binarySearch(list, m)); // 1
      
      m = new Mitarbeiter("elvira", 25, LocalDate.of(2015, 5, 4));
      
      System.out.println(Collections.binarySearch(list, m));// -2  bayad too index 1 bood bad manfi mishe va yeki baz kam mishe ke mishe -2
      
      // wir sortieren nun die list nach dem einstellungsdatum;
      // fuer das sortieren verwenden wir einen Comparator und einen geeigneten labda fuer diese comparator
      // wir gebe die liste nochmal aus
      // dann rufen wir zweite ueaberladung von binary search auf
      System.out.println("------------------------------------");
    
    Comparator<Mitarbeiter> cmp = (a,b) -> a.einstellungsDatum.compareTo(b.einstellungsDatum);

  	Collections.sort(list,cmp);
  	
  	for(Mitarbeiter m2 : list) {
		System.out.println(m2);
	}
  	
  	System.out.println(Collections.binarySearch(list, anna,cmp)); // 3
  	
  	 Mitarbeiter m3 = mori;
      System.out.println(Collections.binarySearch(list, m3,cmp)); // 1
      
  m3 = new Mitarbeiter("elvira", 25, LocalDate.of(2015, 5, 4));
      
      System.out.println(Collections.binarySearch(list, m3,cmp));//-5
      
      // if collection is empty dann haben wir Exception -> NoSuchElementException
      
      System.out.println("Max: " + Collections.max( list)); //sort based on alter -> Comparable -> compareto override
      System.out.println("Min " + Collections.min(list)); //sort based on alter -> Comparable -> compareto override
      System.out.println();
      
      System.out.println(Collections.max(list,(n1,n2)-> n1.name.compareTo(n2.name))); //sort based on name(String)
      System.out.println(Collections.min(list,(n1,n2)-> n1.name.compareTo(n2.name))); //sort  based on name(String)
      
      System.out.println();
      
      System.out.println(Collections.max(list,cmp)); // sort based on einstellungsDatum
      System.out.println(Collections.min(list,cmp)); // sort based on einstellungsDatum

	}

}