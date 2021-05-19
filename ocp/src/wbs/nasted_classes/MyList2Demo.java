package wbs.nasted_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyList2Demo {

	public static void main(String[] args) {

		  List<String> list = Arrays.asList("a", "b", "c", "d"); // 0 - 31
          MyList2<String> mylist = new MyList2<>(list);
          int n = 0;
          for (List<String> sublist : mylist) {
          		
          	
                  System.out.printf("%15s   %5s %10s%n", sublist, n,
                                  "0b" + Integer.toBinaryString(n));
                  n++;
          	
          }
          
          System.out.println("-----------------------------------");
        
          Iterator<List<String>> itr =  mylist.iterator();
          
          while(itr.hasNext()) {
          	System.out.println(itr.next());
          }

	}

}
