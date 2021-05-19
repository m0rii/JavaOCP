package wbs.threads;
import java.util.stream.IntStream;

public class MoreCountDownDemo {

      public static void main(String[] args) throws InterruptedException {

              Runnable runnable = () -> {
                      IntStream.iterate(10, i -> i - 1).limit(10).forEach(i -> {
                              try {
                                      System.out.println(i);
                                      Thread.sleep(1000);
                              } catch (InterruptedException e) {
                                      e.printStackTrace();
                              }
                      });
              };

              System.out.println("countdown beginnt");
              Thread countDown = new Thread(runnable);
              countDown.start();
              countDown.join();
              System.out.println("countdown beendet");
              
              
      }
}
