package wbs.nasted_classes;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;
// lokale klasse
public class MyList2<T> implements Iterable<List<T>> {
	private List<T> list;

	public MyList2(List<T> list) {
		this.list = list;
	}

	public Iterator<List<T>> iterator() {
		
		class Itr implements Iterator<List<T>> {
			int size = (1 << list.size());
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
		return new Itr();
	}
}
