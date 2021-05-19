package wbs.stream.parallel;

import java.util.ArrayList;
import java.util.List;

public class WhaleDataCalculator {

        public int processRecord(int input) {
                try {
                        Thread.sleep(10);
                }
                catch(InterruptedException e) {
                        
                }
                return input + 1;
        }
        
        public void processAllData(List<Integer> data) {
                data.stream().parallel().map(a -> processRecord(a)).count(); // ohne parallel auch checken
        }
        
        public static void main(String[] args) {
                WhaleDataCalculator calculator = new WhaleDataCalculator();
                List<Integer> data = new ArrayList<>();
                for(int i = 0;i < 400;i++) {
                        data.add(i);
                }
                long start = System.currentTimeMillis();
                
                calculator.processAllData(data);
                System.out.println(System.currentTimeMillis() - start);
                
                // ungefahr 4 thousand time rechner

        }

}