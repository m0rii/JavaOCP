import java.util.concurrent.ConcurrentSkipListSet;

 

import java.util.stream.IntStream;

 

public class C28 {

	 public static void main(String[] args)

             throws InterruptedException {

Thread.sleep(1000);

Thread.currentThread().interrupt();

}

}