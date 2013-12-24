package cs.otomasyon.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import cs.otomasyon.dao.dao.UyeDao;
import cs.otomasyon.dao.model.Uye;

public class UyeTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void uyeEkle() {
		try {
			Uye eklenecekUye = new Uye();

			eklenecekUye.setAd("Gökçenur");
			eklenecekUye.setSoyad("Oral");
			eklenecekUye.setKayitTarih("04.12.2013");
			eklenecekUye.setMailAdresi("ugurcansengit@gmail.com");
			eklenecekUye.setTelNo("0555555555");
			eklenecekUye.setOgrenciNo("151220102070");
			eklenecekUye.setBolumId(1);

			UyeDao uyeDao = new UyeDao();
			uyeDao.kaydetKurali(eklenecekUye);
		} catch (Exception e) {
			System.out.println("Hata!");
		}
		System.out.println("finish");
	}

	@Test
	public void UyeListele() {
		UyeDao uyeDao = new UyeDao();
		List<Uye> list = uyeDao.listele();
	}

}
