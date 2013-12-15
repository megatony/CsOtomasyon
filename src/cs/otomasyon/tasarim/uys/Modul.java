package cs.otomasyon.tasarim.uys;

public enum Modul {
	OTOMASYON_SISTEMI("Otomasyon Sistemi"), UYE_EKLE("Üye Ekle"), UYE_ISLEMLERI(
			"Üye İşlemleri"), UYE_LISTESI("Üye Listesi"), ETKINLIK("Etkinlik"), ETKINLIK_OLUSTUR(
			"Etkinlik Oluştur"), ETKINLIK_LISTESI("Etkinlik Listesi");

	private final String modulDegeri;

	private Modul(String modulDegeri) {
		this.modulDegeri = modulDegeri;
	}

	public String getModulAd() {
		return modulDegeri;
	}
}
