package cs.otomasyon.tasarim.uys;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cs.otomasyon.dao.dao.BolumDao;
import cs.otomasyon.dao.dao.UyeDao;
import cs.otomasyon.dao.model.Bolum;
import cs.otomasyon.dao.model.Uye;

public class UyeEkleView extends JInternalFrame {
	private static UyeEkleView view;

	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtMail;
	private JTextField txtOgrenciNo;
	private JTextField txtTelefon;
	private List<JTextField> txtFieldList = new ArrayList<JTextField>();
	private JButton btnEkle;
	private Uye doldurulacakNesne;
	private JLabel lblBlm;
	private JComboBox cmbBolum;
	private BolumDao bolumDao = new BolumDao();
	private UyeDao uyeDao = new UyeDao();
	private JButton btnVazgec;

	private UyeEkleView() {
		super("Üye Ekle", true, true, true, true);
		GUIOlustur();

		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				getContentPane(), txtAd, txtSoyad, txtMail, txtOgrenciNo,
				txtTelefon, cmbBolum, btnVazgec, btnEkle }));
	}

	private UyeEkleView(Uye doldurulacakNesne) {
		super("Üye Ekle", true, true, true, true);
		this.doldurulacakNesne = doldurulacakNesne;
		GUIOlustur();
		btnEkle.setText("Güncelle");
		if (doldurulacakNesne != null) {
			bilesenleriDoldur();
		}

		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				getContentPane(), txtAd, txtSoyad, btnEkle }));
	}

	public static UyeEkleView olustur(Uye doldurulacakNesne) {
		if (doldurulacakNesne == null) {
			view = new UyeEkleView();
		} else
			view = new UyeEkleView(doldurulacakNesne);
		return view;
	}

	private void GUIOlustur() {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		setLocation(150, 100);

		txtAd = new JTextField();
		txtAd.setBounds(196, 27, 134, 28);
		getContentPane().add(txtAd);
		txtAd.setColumns(10);

		JLabel lblAd = new JLabel("Ad*");
		lblAd.setBounds(52, 33, 132, 16);
		getContentPane().add(lblAd);
		lblAd.setLabelFor(txtAd);

		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(196, 61, 134, 28);
		getContentPane().add(txtSoyad);

		JLabel lblSoyad = new JLabel("Soyad*");
		lblSoyad.setBounds(52, 67, 132, 16);
		getContentPane().add(lblSoyad);

		btnEkle = new JButton("Ekle");
		btnEkle.setBounds(52, 319, 117, 29);
		getContentPane().add(btnEkle);
		btnEkle.addActionListener(new KaydetClickListener());

		JLabel lblMailAdresi = new JLabel("Mail Adresi*");
		lblMailAdresi.setBounds(52, 101, 132, 16);
		getContentPane().add(lblMailAdresi);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(196, 95, 134, 28);
		getContentPane().add(txtMail);

		JLabel lblrenciNo = new JLabel("Öğrenci No*");
		lblrenciNo.setBounds(52, 135, 132, 16);
		getContentPane().add(lblrenciNo);

		txtOgrenciNo = new JTextField();
		txtOgrenciNo.setColumns(10);
		txtOgrenciNo.setBounds(196, 129, 134, 28);
		getContentPane().add(txtOgrenciNo);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(52, 169, 132, 16);
		getContentPane().add(lblTelefon);

		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(196, 163, 134, 28);
		getContentPane().add(txtTelefon);

		lblBlm = new JLabel("Bölüm*");
		lblBlm.setBounds(52, 201, 132, 16);
		getContentPane().add(lblBlm);

		cmbBolum = new JComboBox(bolumDao.listele().toArray());
		cmbBolum.setBounds(196, 197, 224, 27);
		cmbBolum.setRenderer(new BolumAdRenderer());
		cmbBolum.setSelectedItem(null);
		getContentPane().add(cmbBolum);

		btnVazgec = new JButton("Vazgeç");
		btnVazgec.setBounds(213, 319, 117, 29);
		btnVazgec.addActionListener(new VazgecClickListener());
		getContentPane().add(btnVazgec);

		txtFieldList.add(txtAd);
		txtFieldList.add(txtMail);
		txtFieldList.add(txtOgrenciNo);
		txtFieldList.add(txtSoyad);
		getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { txtAd, txtSoyad,
						txtMail, txtOgrenciNo, txtTelefon, cmbBolum, btnEkle,
						btnVazgec }));
	}

	private void bilesenleriDoldur() {

	}

	private void nesneyiDoldur() {
		if (doldurulacakNesne == null) {
			doldurulacakNesne = new Uye();
		}
		doldurulacakNesne.setAd(txtAd.getText());
		doldurulacakNesne.setSoyad(txtSoyad.getText());
		doldurulacakNesne.setOgrenciNo(txtOgrenciNo.getText());
		doldurulacakNesne.setMailAdresi(txtMail.getText());
		doldurulacakNesne.setTelNo(txtTelefon.getText());
		doldurulacakNesne.setBolumId(((Bolum) cmbBolum.getSelectedItem())
				.getId());
	}

	private void kaydet() {
		if (zorunluAlanKontrol()) {
			if (uyeDao.kaydetKurali(doldurulacakNesne) != null) {
				JOptionPane.showMessageDialog(null,
						"Kayıt işlemi başarıyla gerçekleşmiştir!", "Kayıt",
						JOptionPane.INFORMATION_MESSAGE);
				temizle();
			} else {
				JOptionPane.showMessageDialog(null,
						"Kayıt işlemi sırasında bir hata oluştu!", "Hata",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class KaydetClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			nesneyiDoldur();
			kaydet();
		}
	}

	private class VazgecClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
		}
	}

	private class BolumAdRenderer implements ListCellRenderer {
		protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			JLabel renderer = (JLabel) defaultRenderer
					.getListCellRendererComponent(list, value, index, true,
							cellHasFocus);
			if (value instanceof Bolum) {
				renderer.setText(((Bolum) value).getAd());
			}
			return renderer;
		}
	}

	private void temizle() {
		for (JTextField textField : txtFieldList) {
			textField.setText("");
		}
		txtTelefon.setText("");
		cmbBolum.setSelectedItem(null);
	}

	private boolean zorunluAlanKontrol() {
		for (JTextField textField : txtFieldList) {
			if (textField.getText() == null
					&& !(textField.getText().trim().length() > 0)) {
				JOptionPane.showMessageDialog(null,
						"Lütfen zorunlu alanları doldurun!", "Hata",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
}
