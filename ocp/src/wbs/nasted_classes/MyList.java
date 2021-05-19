package wbs.nasted_classes;

import java.util.Iterator;
/*
 * welcher typ von nested class wird hier verwendet?
 eine Member klasse
wo und wann wird eine instanz der nested class erzeugt?
 in die methode iterator  new Itr()
welche felder hat die nested class?
int size , int pos
kann die nested class auf private fields ihrer umgebenden
klasse zugreifen? falls ja: macht sie das auch?
ja,ja zwei mal zeile 30 und 16
könnte man hier auch eine lokale klasse verwenden?
ja
könnte man hier auch eine anonyme klasse verwenden?

was kann man mit dieser klasse eigentlich machen?

wie könnte eine demoklasse aussehen, die die funktionsweise
dieser klasse illustriert?

ist die implementierung der methode remove() erforderlich?
in java 7? in java 8?
7 mus implementieren aber 8  ist ok
 */
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

public class MyList<T> implements Iterable<List<T>> {
	private List<T> list;

	public MyList(List<T> list) {
		this.list = list;
	}

	class Itr implements Iterator<List<T>> {
		int size = (1 << list.size()); // age null bashe -> 0, yeki  2, 4 ,8 
		int pos = 0;

		public boolean hasNext() {
			return pos < size;
		}

		public List<T> next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}
			List<T> subList = new Vector<T>();
			for (int n = 0; (1 << n) <= pos; n++) {
				if (((1 << n) & pos) != 0) {
					subList.add(list.get(n));
				}
			}
			pos++;
			return subList;
		}

		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<List<T>> iterator() {
		return new Itr();
	}
}