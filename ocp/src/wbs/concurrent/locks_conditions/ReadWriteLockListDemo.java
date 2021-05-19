package wbs.concurrent.locks_conditions;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


interface RWLConfig {
        int LOOPS = 100000;
        int LISTSIZE = 1000;
        double P = 0.999;
}

class ReadWriteLockList<E extends Number> {

        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        private List<E> list = new ArrayList<>();

        public ReadWriteLockList(List<E> list) {
                this.list.addAll(list);
        }

        public void lockAdd(E e) {
                readWriteLock.writeLock().lock();
                try {
                        list.add(e);
                } finally {
                        readWriteLock.writeLock().unlock();
                }
        }

        public synchronized void synchronizedAdd(E e) {
                list.add(e);
        }

        public double lockArithmetischesMittel() {
                readWriteLock.readLock().lock();
                try {
                        double x = 0;
                        for (Number number : list) {
                                x += number.doubleValue();
                        }
                        return x / list.size();
                } finally {
                        readWriteLock.readLock().unlock();
                }
        }

        public synchronized double synchronizedArithmetischesMittel() {
                double x = 0;
                for (Number number : list) {
                        x += number.doubleValue();
                }
                return x / list.size();
        }

        public void clear() {
                list.clear();
        }
}


class SynchronizedThread extends Thread {

    private ReadWriteLockList<Integer> list;
    private CountDownLatch latch;

    public SynchronizedThread(ReadWriteLockList<Integer> list,
                    CountDownLatch latch) {
            this.list = list;
            this.latch = latch;
    }

    @Override
    public void run() {
            for (int i = 0; i < RWLConfig.LOOPS; i++) {
                    if (Math.random() > RWLConfig.P) { // mehr readable
                            list.synchronizedAdd((int) (Math.random() * 1000));
                    } else {
                            list.synchronizedArithmetischesMittel();
                    }
            }
            latch.countDown();
    }
}

class LockThread extends Thread {

    private ReadWriteLockList<Integer> list;
    private CountDownLatch latch;

    public LockThread(ReadWriteLockList<Integer> list, CountDownLatch latch) {
            this.list = list;
            this.latch = latch;
    }

    @Override
    public void run() {
            for (int i = 0; i < RWLConfig.LOOPS; i++) {
                    if (Math.random() > RWLConfig.P) {
                            list.lockAdd((int) (Math.random() * 1000));
                    } else {
                            list.lockArithmetischesMittel();
                    }
            }
            latch.countDown();
    }
}

public class ReadWriteLockListDemo {

    public static void main(String[] args) throws InterruptedException {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < RWLConfig.LISTSIZE; i++) {
                    list.add(i);
            }
            ReadWriteLockList<Integer> rwl;
            CountDownLatch latch = new CountDownLatch(5);
            long time1;
            long time2;
            
            for (int i = 0; i < RWLConfig.LISTSIZE; i++) {
                    list.add(i);
            }

            System.out.println("--- synchronized ---"); // inja blockiert new threads

            
            rwl = new ReadWriteLockList<>(list);

            latch = new CountDownLatch(5);
            time1 = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                    new SynchronizedThread(rwl, latch).start();
            }
            latch.await();
            time2 = System.currentTimeMillis();
            System.out.println((time2 - time1));
            
            System.out.println("--- ReadWriteLock ---");
            
            rwl = new ReadWriteLockList<>(list);
            latch = new CountDownLatch(5);

            time1 = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                    new LockThread(rwl, latch).start();
            }
            latch.await();
            time2 = System.currentTimeMillis();
            System.out.println((time2 - time1));
    }
}
