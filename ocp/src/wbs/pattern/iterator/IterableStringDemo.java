package wbs.pattern.iterator;
import java.util.Iterator;

public class IterableStringDemo {

/*
 * retroanalyse is fun :)
 * 
 * was können sie alles über die klasse IterableString sagen?
 * 
 * 1 welches interface wird von IterableString implementiert?
 * => Iterable<Character>
 * 2 welche methode(n) muss die klasse IterableString anbieten?
 * => public Iterator<Character> iterator()
 * 3 kann die klasse IterableString abstract sein?
 * => nein , wir haben new
 * 4 welche(n) konstruktor(en) muss die klasse anbieten?
 * =>einen konstruktor mit einem parameter von type String oder Charsequence 
 * 5 welche hilfsklasse wird benötigt?
 * => StringItr ,
 * 6 welches interface muss diese hilfsklasse implementieren?
 * => Iterator implementiert so Iterator<Character>
 * 7 welche methoden muss diese hilfsklasse implementieren?
 * =>  public Character next() , public boolean hasNext(), public void remove() -> default chon string immutable hast va nemishe pakehs konim;
 */

	public static void main(String[] args) {

		// mit foreach		
		IterableString s = new IterableString("what a wonderful day");
		
		for (Character c : s) {
			
			System.out.println(c);
		}

		// so geht es auch...
		System.out.println("------------");
		Iterator<Character> itr = s.iterator();
		while (itr.hasNext()) {
		//	itr.remove();
			System.out.println(itr.next());
		}
	}
}