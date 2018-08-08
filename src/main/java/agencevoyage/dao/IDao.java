package agencevoyage.dao;

import java.util.List;

public interface IDao<T, PK> {

	List<T> findAll();

	T find(PK id);

	void save(T obj);

	void delete(T obj);

	void deleteById(PK id);
}
