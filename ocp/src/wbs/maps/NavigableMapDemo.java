package wbs.maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

  // wir illustieren die folgenden methoden von NavigableMap
//ceilingEntry(), floorEntry()
//ceilingkey(), floorKey()
//firstEntry(), lastEntry()
//tailMap()
//headMap()
//subMap()

public class NavigableMapDemo {
    
    public static void main(String[] args) {
            
            NavigableMap<Integer, String> map = new TreeMap<>();
            
            map.put(1, "eins");
            map.put(3, "drei");
            map.put(7, "sieben");
            map.put(10, "zehn");
            
            System.out.println(map.ceilingEntry(3));  // 3=drei
            System.out.println(map.ceilingEntry(4));  // 7=sieben
            
            System.out.println(map.floorEntry(6));  // 3=drei
            System.out.println(map.floorEntry(10));  // 10=zehn
            
            System.out.println(map.ceilingKey(12));  // null
            System.out.println(map.floorKey(0));  // null
            
            System.out.println(map.firstEntry() + " / " + map.lastEntry());  // 1=eins / 10=zehn
            
            System.out.println(map.tailMap(3));  // {3=drei, 7=sieben, 10=zehn}
            System.out.println(map.tailMap(3, false));  // {7=sieben, 10=zehn}
            
            System.out.println(map.headMap(3));  // {1=eins}
            System.out.println(map.headMap(3, true));  // {1=eins, 3=drei}
            
            System.out.println(map.subMap(4, 8));  // {7=sieben}
            System.out.println(map.subMap(3, true, 10, false)); // {3=drei, 7=sieben}
    }
}