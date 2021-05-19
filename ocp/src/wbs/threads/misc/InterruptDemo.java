package wbs.threads.misc;

class Sleeper extends Thread {
    private Object o;
    private Thread thread;

    public Sleeper(Object o, Thread thread) {
            this.o = o;
            this.thread = thread;
    }

    @Override
    public void run() {
            if (Math.random() > 0.5) {
                    synchronized (o) {
                            System.out.println("have a nice day...");
                    }
            } else {
                    thread.interrupt();
            }
    }
}

public class InterruptDemo {

    public static void main(String[] args) {
            Object o = new Object();
            try {
                    synchronized (o) {
                            Thread thread = new Sleeper(o, Thread.currentThread()); // zwei threads , main by JVM and code
                                                          // referenz of main thread
                            thread.start();
                            Thread.sleep(5_000);
                            System.out.println("waking up...");
                    }
            } catch (InterruptedException e) {
                    System.out.println("good bye...");
            }
    }
}
