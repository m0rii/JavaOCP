package wbs.generics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class SetUtil  {
	// wir schreiben die methode count().
	// sie ermittelt, wie viele elemente eines sets eine gegebene eigenschaft haben.
	// bsp1.: wie viele elemente eines sets von String haben die länge 3?
	// bsp2.: wie viele einwohner einer stadt sind jünger als 65?
	
     public static <T> int count(Set<T> set, Predicate<? super T> predicate)  {
    	 int counter =0;
    	 for(T t : set) {
    		 if(predicate.test(t)) {
    			 counter++;
    		 }
    	 }
    	 return counter;
     }
 
  // wir schreiben die methode filter().
  // sie liefert zu einem set ein subset, das alle elemente des sets enthält,
  // die eine gegebene eigenschaft haben
     
   //  <E extends Comprable<? super E>>
     public static <E> Set<E> filter(Set<E> set, Predicate<? super E> predicate) {
    	Set<E> subset = new HashSet<>(); // age new Treeset bashe kar nemikone vase string ke natural ordering nadare
		for(E e : set) {
			if(predicate.test(e)) {
				subset.add(e);
			}
		}
    	 return subset;
     }
     
  // wir überladen die methode filter().
  // die überladene version stellt sicher, dass das gelieferte subset
  // sortiert ist.
  // die sortierung übernimmt ein comparator, der der methode als 3. argument
  // übergeben wird.
     
     //NavigableSet ist sortiert
     public static <E> NavigableSet<E> filter(Set<E> set, Predicate<? super E> predicate,
             Comparator<? super E> cmp) {
     NavigableSet<E> subset = new TreeSet<>(cmp);
     for (E e : set) {
             if (predicate.test(e)) {
                     subset.add(e);
             }
     }
     return subset;
      }
     
     // ein stellenvermittler listet zu einem stellenangebot alle stellensuchenden
     // auf,
     // die zu diesem stellenangebot passen.
     // ein partnervermittler listet zu einem partnersuchenden alle partnersuchenden
     // auf, die zum partnersuchenden passen...
     // methodenname: candidates()
     
     public static <T1,T2> Set<T2> candidates(T1 t1,Set<T2> set,
    		 BiPredicate<? super T1,? super T2> predicate){ // BiPredicate chon 2ta angebot stelen o suchen ro mikhaim moghayese konim
    	Set<T2> candidates = new HashSet<>();
    	 for (T2 t2 : set) {
             if (predicate.test(t1,t2)) {
            	 candidates.add(t2);
             }
     } 
		return candidates;
    	 
     }
     
     /*
      * wir schreiben die methode pairBuilder(). sie liefert ein Set von Dupeln.
      * die elemente eines Dupels "passen zueinander".
      * 
      * bsp.: ein set von dupeln von stellensuchenden und stellenangeboten (die
      * zueinander passen...)
      * bsp.: ein set von dupeln von partnersuchenden (die
      * zueinander passen...).
      * 
      * wir testen in PairBuilderDemo
      */
     
    public static <E1,E2> Set<Dupel<E1,E2>> pairBuilder(Set<E1> set1,
    		Set<E2> set2 , BiPredicate<? super E1, ? super E2> predicate){
    	Set<Dupel<E1,E2>> result = new HashSet<Dupel<E1,E2>>();
    	for(E1 e1: set1) {
    		for(E2 e2 :set2) {
    			if(predicate.test(e1, e2)) {
    				result.add(new Dupel<>(e1,e2));
    			}
    		}
    	}
				return result;
    	
    }
    
 // wir ordnen alle abgordneten des bundestages in gruppen.
 // alle abgeordneten einer gruppe gehören zur selben partei.

 // wir ordnen alle wahlberechtigten eines bundeslandes in gruppen.
 // alle wahlberechtigten einer gruppe gehören zum selben wahlkreis.

 // wir ordnen alle zahlen zwischen 100 und 200 in gruppen.
 // alle zahlen in derselben gruppe haben dieselbe quersumme.

 // methodenname: groupingBy() (in SetUtil)

 // wir testen in GroupingByDemo

 // T: typ (abgeordneter, wahlberechtigter, integer)
 // P: property (partei, wahlkreis, integer)
    
    public static <T, P> Map<P, Set<T>> groupingBy(Set<T> set,
            Function<T, P> function) {
    Map<P, Set<T>> result = new HashMap<>();
    P property;
    Set<T> subSet;
    for (T t : set) {
            property = function.apply(t);
            subSet = result.get(property);
            if (subSet == null) {
                    subSet = new HashSet<>();
                    result.put(property, subSet);
            }
            subSet.add(t);
    }
    return result;
   }
    
    /*
     * wir schreiben die methode partioningBy() (in SetUtil). sie zerlegt eine
     * menge in 2 teilmengen: solche, die eine bestimmte eigenschaft haben,
     * und solche, die diese eigenschaft nicht haben.
     * bsp.: personen -> minderjährig, volljährig
     * bsp.: zahlen -> gerade, ungerade
     * bsp.: strings -> palindrom, kein palindrom
     */
   
    // wir testen in PartioningByDemo
    
    public static <T> Map<Boolean, Set<T>> partitioningBy(Set<T> set,
            Predicate<? super T> predicate) {
    	
    Map<Boolean, Set<T>> result = new HashMap<>();
    Set<T> trueValues = new HashSet<>();
    Set<T> falseValues = new HashSet<>();;
    for (T t : set) {
            if(predicate.test(t)) {
            	trueValues.add(t);
            }else {
            	falseValues.add(t);
            }
    }
           result.put(true, trueValues);
           result.put(false, falseValues);
    
    return result;
   }
     



}
