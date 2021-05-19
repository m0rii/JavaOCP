package wbs.generics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Menge<E> extends HashSet<E> {
	private static final long serialVersionUID = 1L;

	public Menge() {
	}

	public Menge(Collection<? extends E> collection) {
		super(collection);
	}

	public <E2> Menge<Dupel<E, E2>> cartesischesProdukt(Set<E2> set) {
		Menge<Dupel<E, E2>> result = new Menge<Dupel<E, E2>>();
		for (E e : this) {
			for (E2 e2 : set) {
				result.add(new Dupel<E, E2>(e, e2));
			}
		}
		return result;
	}
}
