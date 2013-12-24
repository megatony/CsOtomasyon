package cs.otomasyon.tasarim.uys;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import cs.otomasyon.dao.dao.BolumDao;
import cs.otomasyon.dao.dao.UyeDao;
import cs.otomasyon.dao.model.Uye;

public class UyeListeleView extends JInternalFrame {
	private static UyeListeleView view;
	private JTable table;

	/**
	 * Create the frame.
	 */
	private UyeListeleView() {
		super("Üye Listesi", true, true, true, true);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);

		setLocation(150, 150);
		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		GUIOlustur();
	}

	public static UyeListeleView olustur() {
		view = new UyeListeleView();
		return view;
	}

	private void GUIOlustur() {
		table = new JTable();
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		UyeDao uyeDao = new UyeDao();
		List<Uye> veriListesi = uyeDao.listele();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Ad", "Soyad", "Öğrenci No", "Telefon No", "Kayıt Tarihi",
				"Bölüm" }) {
			boolean[] columnEditables = new boolean[] { true, true, false,
					false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setMinWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setShowGrid(true);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Uye uye : veriListesi) {
			Object[] o = new Object[6];
			o[0] = uye.getAd();
			o[1] = uye.getSoyad();
			o[2] = uye.getOgrenciNo();
			o[3] = uye.getTelNo();
			o[4] = uye.getKayitTarih();
			o[5] = new BolumDao().getir(uye.getBolumId()).getAd();
			model.addRow(o);
		}

		JScrollPane scPane = new JScrollPane(table);
		scPane.setBounds(6, 121, 564, 252);
		getContentPane().add(scPane);

	}
}
