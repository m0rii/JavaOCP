package wbs.concurrent.locks_conditions;

public interface SimpleQueue<E> {

    public abstract void put(E e) throws InterruptedException;

    public abstract E take() throws InterruptedException;
}
