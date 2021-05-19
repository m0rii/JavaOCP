package wbs.nasted_classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyListDemo {

        // das element an der list-position 0 wird auf das bit an der bitposition 0
        // gemappt
        // das element an der list-position 1 wird auf das bit an der bitposition 1
        // gemappt
        // das element an der list-position 2 wird auf das bit an der bitposition 2
        // gemappt
        // usw
        // für eine list mit n elementen werden 2 ^ n teillisten generiert

        public static void main(String[] args) {

                /*
                 * wir geben alle teillisten einer liste mit den elementen
                 * "a","b","c","d" aus
                 */

                List<String> list = Arrays.asList("a", "b", "c", "d"); // 0 - 31
                MyList<String> mylist = new MyList<>(list);
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

