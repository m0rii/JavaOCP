package wbs.threads.misc;
public class ExceptionsAndLocksDemo {
    
    static class MyThread extends Thread {

            private Object o;

            public MyThread(Object o) {
            	   this.o = o;
            //	 UncaughtExceptionHandler us;
            //    us =  (t, e) -> System.out.println(
                         //   "thread " + t + " has thrown " + e);
                    this.setUncaughtExceptionHandler( // functional interface chon ba lamda kar mikone (Thread , Throwable)
                                    (t, e) -> System.out.println(
                                                    "thread " + t + " has thrown " + e));
            }

            @Override
            public void run() {
                    synchronized (o) {
                            while (true) {
                                    try {
                                            Thread.sleep(5000);
                                    } catch (InterruptedException e) {
                                            e.printStackTrace();
                                    }
                                    if (Math.random() > 0.5) { // bad az har 5 sanie yebar random seda zade mishe va age balatar az sfer basshe exception miad
                                            throw new IllegalArgumentException();
                                    }
                            }
                    }
            }
    }

    public static void main(String[] args) throws InterruptedException {
            Object o = new Object();
            Thread thread = new MyThread(o);
            thread.start();
            Thread.sleep(1000);
            System.out.println("waitung for lock...");
            synchronized (o) {
                    System.out.println("lock acquired"); // nemishe goft vheghadr tool mikeshe ta biad in , be random rabt darer
            }
            System.out.println("finis...");
    }
} 
