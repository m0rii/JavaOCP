package wbs.threads;

public class IncDemo {

    static class Counter {   
            long v1 = 0;
            long v2 = 0;

            void add(long l) {
                    v1 += l;
            }
            synchronized void sync_add(long l) {
                    v2 += l;
            }
    } 
    public static void main(String[] args) throws InterruptedException {       
            Counter counter = new Counter();
            
            Runnable runnable = () -> {
                    for(int i = 0;i < 100_000;i++) {
                            counter.add(1);
                            counter.sync_add(1);
                    }
            };    
            Thread t1 = new Thread(runnable);
            Thread t2 = new Thread(runnable);
            
            t1.start();
            t2.start();
            
            t1.join();
            t2.join();
            
            System.out.println("v1: " + counter.v1);
            System.out.println("v2: " + counter.v2);
           
            
            
    }
}
