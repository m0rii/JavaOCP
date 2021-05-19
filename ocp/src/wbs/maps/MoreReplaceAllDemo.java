package wbs.maps;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MoreReplaceAllDemo {

        public static void main(String[] args) {
                
                Map<String, Integer> map = new HashMap<>();
                
                map.put("anna", 4);
                map.put("hanna",5);
                
                BiFunction<CharSequence, Number , Integer> f = (c,n) -> {  // CharSequence supertype von string , Number supertype von Integer
                        return c.length() * n.intValue();
                };
                
                System.out.println(map); // {anna=4, hanna=5}
                
                map.replaceAll(f);
                System.out.println(map); // {anna=16, hanna=25}
                
                /*
                bitte erläutert, warum die BiFunction in
                replaceAll() wie folgt deklariert ist:
                BiFunction<? super K,? super V,? extends V> function
                warum 2 mal ? super..., und einmal ? extends ?
                
      		 */
        }

}
