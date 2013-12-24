package cs.otomasyon.test;

import java.util.List;

import org.junit.Test;

import cs.otomasyon.dao.dao.BolumDao;
import cs.otomasyon.dao.model.Bolum;

public class BolumTest {

	@Test
	public void bolumListele() {
		BolumDao bolumDao = new BolumDao();
		List<Bolum> deneme = bolumDao.listele();
	}
}
