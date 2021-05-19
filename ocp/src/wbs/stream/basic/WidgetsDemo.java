package wbs.stream.basic;

import java.awt.Color;
import java.util.Collection;
import java.util.HashSet;

class Widget {
        Color col;
        int weight;
        Widget(Color col, int weight){
                this.col = col;
                this.weight = weight;
        }
        public Color getColor() {                return this.col;        }
        public int getWeight() {                return this.weight;        }
}

public class WidgetsDemo {
        
        public static void main(String[] args) {
                 // Variante ohne Stream
                Collection<Widget> widgets = new HashSet<>();
                int sum = 0;
                widgets.add(new Widget(Color.RED, 3));
                //...
                for (Widget widget : widgets) {
                        if (widget.getColor() == Color.RED) {
                                sum += widget.getWeight();
                        }
                }
                System.out.println(sum);
                
                // Variante mit stream
                
                int sum2 = widgets.stream()
                                .filter(w -> w.getColor() == Color.RED)
                                .mapToInt(w -> w.getWeight())
                                .sum();
                System.out.println(sum2);
        }
}


	
/*
 *   int sum = widgets.stream()
          .filter(w -> w.getColor() == RED)
            .mapToInt(w -> w.getWeight())
              .sum();
 *    welche vor- / nachteile hat diese variante
     gegenüber der pipeline-variante?
      kriterien:
     - verständlichkeit (das ist relativ...)
      - wartbarkeit
      - composability
      - parallelisierung
       - memory impact
        - execution time
 */


