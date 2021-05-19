package wbs.concurrent.misc;

import java.util.concurrent.Semaphore;

class SemaphorUser extends Thread {
        private Semaphore machines;

        public SemaphorUser(Semaphore resources, String name) {
                this.machines = resources;
                this.setName(name);
                this.start();
        }

        public void run() {
                try {
                        System.out.println(getName() + " waiting to access resource");
                        machines.acquire();
                        System.out.println(getName() + " accessing resource");
                        Thread.sleep(500);
                        System.out.println(getName() + " releasing resource");
                        machines.release();
                } catch (InterruptedException ie) {
                        // ignore
                }
        }
}

public class SemaphoreDemo {
        public static void main(String[] args) {
                Semaphore machines = new Semaphore(2); // wie viel paralell aquire einstellungen
              //  Semaphore machines = new Semaphore(-1);
                new SemaphorUser(machines, "Anton");
                new SemaphorUser(machines, "Berta");
                new SemaphorUser(machines, "Chris");
                new SemaphorUser(machines, "Dorothea");
        }
}
