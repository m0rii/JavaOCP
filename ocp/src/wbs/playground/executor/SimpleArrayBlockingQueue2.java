package wbs.playground.executor;


import java.lang.reflect.Array;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleArrayBlockingQueue2<E> implements SimpleQueue2<E> {

        private int numberOfElements = 0;
        private E[] array;

        private Lock lock = new ReentrantLock();
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();

        @SuppressWarnings("unchecked")
        public SimpleArrayBlockingQueue2(Class<E> cls, int length) {
                array = (E[]) Array.newInstance(cls, length);
        }

        public void put(E e) throws InterruptedException {
                this.lock.lock();
                try {
                        // warte, bis wieder platz verfÃ¼gbar ist
                        while (this.numberOfElements == this.array.length) {
                                this.notFull.await();
                        }
                        this.array[this.numberOfElements] = e;
                        this.numberOfElements++;
                        this.notEmpty.signal();
                } finally {
                        this.lock.unlock();
                }
        }

        public E take() throws InterruptedException {

                this.lock.lock();

                try {
                        // warte, bis produkte verfÃ¼gbar sind
                        while (this.numberOfElements == 0) {
                                this.notEmpty.await();
                        }

                        E e = this.array[0];
                        for (int i = 0; i < this.numberOfElements - 1; i++) {
                                this.array[i] = this.array[i + 1];
                        }

                        this.numberOfElements--;
                        this.notFull.signal();

                        return e;

                } finally {
                        this.lock.unlock();
                }
        }

        @Override
        public int size() {
                return numberOfElements;
        }
}
