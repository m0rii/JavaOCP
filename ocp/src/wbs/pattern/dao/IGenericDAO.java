package wbs.pattern.dao;

import java.util.List;

public interface IGenericDAO<E,P> {
	public void create(E e);
	public void delete(E e);
	public void update(E e);
	public E read(P p);
	public List<E> readAll();  
}
