package wbs.ocp_tests_concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//wie bekommt man eine instanz auf ThreadLocalRandom?
//wie bekommt man eine referenz auf einen ExecutorService, der zur abarbeitung der
//tasks nur einen einzigen thread verwendet?
//wie bekommt man eine referenz auf einen ScheduledExecutorService?
//welche blöcke sind compilierungsfähig?
//nur A
//nur B
//A und B
//weder A noch B
public class A03<E> {
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private List<E> list = new ArrayList<>();

	public A03(List<E> list) {
		this.list.addAll(list);
	}
//A
	/*
	 * public void lock1(E e) { readWriteLock.writeLock().lock(); try { //read... }
	 * finally { readWriteLock.writeLock().unlock(); } } public synchronized void
	 * synchronizedAdd(E e) { list.add(e); }
	 */
//B
	/*
	 * public double lockArithmetischesMittel() { readWriteLock.lock(); try { double
	 * x = 0; for (E e : list) { concurrency [6] // write... } return x /
	 * list.size(); } finally { readWriteLock.unlock(); } }
	 */
}
