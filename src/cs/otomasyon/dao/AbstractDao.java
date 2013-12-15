package cs.otomasyon.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AbstractDao<T> {

	protected T guncelleKurali(T obj) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();

		entityManager.merge(obj);

		return obj;
	}
}
