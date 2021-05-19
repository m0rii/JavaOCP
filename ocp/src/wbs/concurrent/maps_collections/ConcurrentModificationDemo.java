package wbs.concurrent.maps_collections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ConcurrentModificationDemo {

        public static void main(String[] args) throws ConcurrentModificationException {
                
                List<Integer> list = new ArrayList<>();
                
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(6);
                
//                for(Integer i : list) {
//                        System.out.println(i);
//                        if(i % 2 == 0) {
//                               list.remove(i);  // uuups... nemishe inja list ro taghir dad
//                        }
//                }
                
                list.removeIf(i -> i % 2 ==0);
                System.out.println(list);
               
                
            
        }
}
