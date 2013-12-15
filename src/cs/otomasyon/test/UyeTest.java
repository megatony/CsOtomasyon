package cs.otomasyon.test;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import cs.otomasyon.dao.model.Uye;

public class UyeTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void uyeEkle() {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();

		entityManager.getTransaction().begin();
		try {
			Uye eklenecekUye = new Uye();

			eklenecekUye.setUyeAd("Akın");
			eklenecekUye.setUyeSoyad("Akgul");
			eklenecekUye.setUyeKayitTarih("04.12.2013");
			eklenecekUye.setUyeMailAdresi("ugurcansengit@gmail.com");
			eklenecekUye.setUyeTelNo("0555555555");
			eklenecekUye.setUyeOgrenciNo("151220102070");
			eklenecekUye.setUyeBolum("Bilgisayar M�hendisli�i");

			entityManager.persist(eklenecekUye);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}

		entityManager.close();

		System.out.println("finish");

	}

}
