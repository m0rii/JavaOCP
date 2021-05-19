package wbs.concurrent.locks_conditions;

public interface SimpleQueue2<E> {

    public abstract void put(E e) throws InterruptedException;

    public abstract E take() throws InterruptedException;
    
    public abstract int size();
}
