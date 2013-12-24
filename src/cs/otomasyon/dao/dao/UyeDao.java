package cs.otomasyon.dao.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import cs.otomasyon.dao.AbstractDao;
import cs.otomasyon.dao.model.Uye;

public class UyeDao extends AbstractDao<Uye> {
	@Override
	public Uye kaydetKurali(Uye obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		dateFormat.format(date);
		obj.setKayitTarih(date.toString());
		return super.kaydetKurali(obj);
	}
}
