import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C39 {
 
                public static void main(String[] arg) throws InterruptedException {
                               ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                                                               10);
                               Runnable command = () -> {
                                               System.out.println("---------");
                                               try {
                                                               Thread.sleep(500);
                                               } catch (InterruptedException e) {
                                               }
                               };
                               executor.scheduleAtFixedRate(command, 1000, 1000,
                                                               TimeUnit.MILLISECONDS);
 
                               Thread.sleep(10000);
                               executor.shutdownNow();
                }
}