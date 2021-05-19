package wbs.playground.executor;


public interface SimpleQueue2<E> {

        public abstract void put(E e) throws InterruptedException;

        public abstract E take() throws InterruptedException;
        
        public abstract int size();
}
