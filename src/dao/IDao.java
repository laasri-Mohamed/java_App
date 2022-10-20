package dao;

import java.util.List;

public interface IDao<T> {

	// les crud
	boolean create(T o);

	boolean delete(T o);

	boolean update(T o);

	List<T> findAll();

	T findById(int id);

}
