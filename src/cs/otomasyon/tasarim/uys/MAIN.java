package cs.otomasyon.tasarim.uys;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cs.otomasyon.dao.model.Uye;

public class MAIN {
	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"CsOtomasyon").createEntityManager();

		entityManager.getTransaction().begin();
		try {
			Uye eklenecekUye = new Uye();

			eklenecekUye.setUyeAd("Mithat");
			eklenecekUye.setUyeSoyad("Gemici");
			eklenecekUye.setUyeKayitTarih("04.12.2013");
			eklenecekUye.setUyeMailAdresi("ugurcansengit@gmail.com");
			eklenecekUye.setUyeTelNo("0555555555");
			eklenecekUye.setUyeBolum("Bilgisayar Mühendisli€i");

			entityManager.persist(eklenecekUye);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}

		entityManager.close();

		System.out.println("finish");

	}
}
