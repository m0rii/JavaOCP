package wbs.threads.sync;

import java.util.Arrays;

//kann das ergebnis exakt vorausgesagt werden?

public class StaticSynchDemo2 {

     static class ST {
             static int n = 0;
             static Object o = new Object();

             public static void inc() {
                     synchronized (o) {
                             n++;
                     }
             }
     }

     static class STThread extends Thread {

             @Override
             public void run() {
                     for (int i = 0; i < 1_000_000; i++) {
                             ST.inc();
                     }
             }
     }

     public static void main(String[] args) throws InterruptedException {
             STThread t1 = new STThread();
             STThread t2 = new STThread();
             t1.start();
             t2.start();
             t1.join();
             t2.join();
             System.out.println(ST.n);
          

     }

}
