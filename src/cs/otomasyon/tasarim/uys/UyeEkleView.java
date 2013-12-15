package cs.otomasyon.tasarim.uys;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UyeEkleView extends JInternalFrame {
	private JTextField txtAd;
	private JTextField txtSoyad;

	public UyeEkleView() {
		setBounds(100, 100, 450, 300);
		setLayout(null);
		setLocation(30, 30);

		txtAd = new JTextField();
		txtAd.setBounds(196, 27, 134, 28);
		add(txtAd);
		txtAd.setColumns(10);

		JLabel lblAd = new JLabel("Ad");
		lblAd.setBounds(52, 33, 61, 16);
		add(lblAd);

		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(196, 67, 134, 28);
		add(txtSoyad);

		JLabel label = new JLabel("Soyad");
		label.setBounds(52, 73, 61, 16);
		add(label);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.setBounds(132, 146, 117, 29);
		add(btnEkle);

	}
}
