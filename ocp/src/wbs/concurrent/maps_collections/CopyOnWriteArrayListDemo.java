package wbs.concurrent.maps_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

class ReaderThread extends Thread {

        private CountDownLatch latch;
        private List<Integer> list;

        public ReaderThread(CountDownLatch latch, List<Integer> list) {
                this.latch = latch;
                this.list = list;
        }

        @Override
        public void run() {
                for (Integer i : list) {
                        try {
                                if (i.equals(5)) {
                                        latch.await();
                                }
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        System.out.printf("%s(%d,%d)%n",
                                        Thread.currentThread().getName(), i, list.size());
                }
        }
}

class WriterThread extends Thread {

        private CountDownLatch latch;
        private List<Integer> list;

        public WriterThread(CountDownLatch latch, List<Integer> list) {
                this.latch = latch;
                this.list = list;
        }

        @Override
        public void run() {
                try {
                        latch.await();
                        list.add(11);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }
}

public class CopyOnWriteArrayListDemo {

        public static void main(String[] args)
                        throws InterruptedException {
                CountDownLatch readerLatch = new CountDownLatch(1);
                CountDownLatch writerLatch = new CountDownLatch(1);
                List<Integer> list = Math.random() > 0.5
                                ? new CopyOnWriteArrayList<Integer>() // ohne exception , iteration geht nur bis 10
                                : new ArrayList<Integer>(); // exception
                list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
                ReaderThread reader = new ReaderThread(readerLatch, list);
                WriterThread writer = new WriterThread(writerLatch, list);
                reader.start();
                writer.start();
                Thread.sleep(1000);
                writerLatch.countDown();
                Thread.sleep(1000);
                readerLatch.countDown();
                reader.join();
                writer.join();
                System.out.println(list);
        }
}











