package cs.otomasyon.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AbstractDao<T> {

	protected Class modelSinif = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	private final String SELECT = "select t from " + modelSinif.getSimpleName()
			+ " t";

	public T guncelleKurali(T obj) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(obj);
		entityManager.flush();

		entityManager.getTransaction().commit();
		return obj;
	}

	public T kaydetKurali(T obj) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(obj);
		entityManager.flush();

		entityManager.getTransaction().commit();

		return obj;
	}

	public List<T> listele() {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();
		Query query = entityManager.createQuery(SELECT);

		return query.getResultList();
	}

	public T getir(int id) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();

		StringBuilder builder = new StringBuilder();
		builder.append(SELECT + " where id= :pId");
		Query query = entityManager.createQuery(builder.toString());
		query.setParameter("pId", id);

		return (T) query.getSingleResult();
	}

	public void sil(int id) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();
		entityManager.getTransaction().begin();

		Object silinecekObje = entityManager.find(modelSinif, id);
		if (silinecekObje != null) {
			entityManager.remove(silinecekObje);
			entityManager.flush();
			entityManager.getTransaction().commit();
		}

	}

	public int kayitSayisi(T obj) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();

		StringBuilder builder = new StringBuilder();
		builder.append("select COUNT(t) from " + modelSinif.getSimpleName()
				+ " t");
		Query query = entityManager.createQuery(builder.toString());
		Long toplam = (Long) query.getSingleResult();
		entityManager.close();

		return toplam.intValue();
	}

}
