package cs.otomasyon.tasarim;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import cs.otomasyon.tasarim.uys.UyeEkleView;
import cs.otomasyon.tasarim.uys.UyeListeleView;

public class GenelTutucuView extends JFrame {

	private JDesktopPane jDesktopPane;
	private static GenelTutucuView frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GenelTutucuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenelTutucuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jDesktopPane = new JDesktopPane() {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(800, 800);
			}
		};
		jDesktopPane.setBackground(getForeground());
		jDesktopPane.setLayout(null);
		setContentPane(jDesktopPane);
		jDesktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
		pack();

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				Modul.OTOMASYON_SISTEMI.getModulAd()) {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode(Modul.UYE_ISLEMLERI
						.getModulAd());
				node_1.add(new DefaultMutableTreeNode(Modul.UYE_EKLE
						.getModulAd()));
				node_1.add(new DefaultMutableTreeNode(Modul.UYE_LISTESI
						.getModulAd()));
				add(node_1);
				node_1 = new DefaultMutableTreeNode(Modul.ETKINLIK.getModulAd());
				node_1.add(new DefaultMutableTreeNode(Modul.ETKINLIK_OLUSTUR
						.getModulAd()));
				node_1.add(new DefaultMutableTreeNode(Modul.ETKINLIK_LISTESI
						.getModulAd()));
				add(node_1);
			}
		}));
		tree.setBounds(6, 6, 145, getWidth());
		tree.addTreeSelectionListener(new AgacSecmeOlayi());
		jDesktopPane.add(tree);
	}

	private class AgacSecmeOlayi implements TreeSelectionListener {
		@Override
		public void valueChanged(TreeSelectionEvent event) {
			if (event.getPath().getLastPathComponent().toString()
					.equals(Modul.UYE_EKLE.getModulAd())) {
				UyeEkleView view = UyeEkleView.olustur(null);
				jDesktopPane.add(view);
			} else if (event.getPath().getLastPathComponent().toString()
					.equals(Modul.UYE_LISTESI.getModulAd())) {
				UyeListeleView view = UyeListeleView.olustur();
				jDesktopPane.add(view);
			}
		}
	}
}
