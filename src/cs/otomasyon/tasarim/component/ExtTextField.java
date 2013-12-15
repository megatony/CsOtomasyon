package cs.otomasyon.tasarim.component;

import javax.swing.JTextField;

public class ExtTextField extends JTextField{
	private static ExtTextField txtField;
	
	private ExtTextField() {
		super();
	}
	public static ExtTextField olustur(String baslik,int genislik, int uzunluk){
		txtField = new ExtTextField();
		txtField.setName(baslik);
		txtField.setSize(genislik, uzunluk);
		return txtField;
	}
}
