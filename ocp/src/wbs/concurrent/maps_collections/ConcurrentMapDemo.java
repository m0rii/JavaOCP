package wbs.concurrent.maps_collections;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapDemo {

        public static void main(String[] args) throws InterruptedException {
                int n = 100_000;
                Map<Integer, String> map = Math.random()> 0.5 ? new Hashtable<>() : new HashMap<>(); // hashmap adad dorost nemide va threrad safe nist
                
                ConcurrentMap<Integer, String> cmap = new ConcurrentHashMap<>();
                Runnable runnable = () -> {
                        for (int i = 0; i < n; i++) {
                                map.putIfAbsent(i, Integer.toString(i));
                                cmap.putIfAbsent(i, Integer.toString(i));
                        }
                };

                Thread t1 = new Thread(runnable);
                Thread t2 = new Thread(runnable);

                t1.start();
                t2.start();

                t1.join();
                t2.join();
                
                System.out.println(map.getClass());
                System.out.println("map.size(): " + map.size());
                System.out.println("cmap.size(): " + cmap.size());

        }
}
