package wbs.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

/*
 * wie verwenden irgendeine der synchronized - methoden von Collections,
 * um auf eine Collection thread-safe zuzugrifen
 */
public class SynchronizedCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		///////////////////////////////// kurs losung/////////////////////////////////////////////////////
		// List<Integer> listKurs = new ArrayList<Integer>(); // -> Exception miad
		//List<Integer> listKurs = new Vector<Integer>(); // Vector okeye va thread safe , khorooji true miad
		 List<Integer> listKurs = Collections.synchronizedList(new ArrayList<Integer>());
		int n =1000;
		Runnable r = () ->{
			IntStream.rangeClosed(1, n).forEach(i->listKurs.add(i));
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		  t1.start();
		  t2.start();
		  t1.join();
		  t2.join();
		  System.out.println(listKurs.size() == 2 * n );
		  
		}
		
	}





