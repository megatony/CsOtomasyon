package cs.otomasyon.tasarim;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import cs.otomasyon.tasarim.uys.Modul;
import cs.otomasyon.tasarim.uys.UyeEkleView;

public class GenelTutucuView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane = new JDesktopPane();
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
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		desktopPane.setPreferredSize(new Dimension(600, 600));

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
		tree.setBounds(6, 6, 145, 266);
		tree.addTreeSelectionListener(new AgacSecmeOlayi());
		contentPane.add(tree);
	}

	private class AgacSecmeOlayi implements TreeSelectionListener {
		@Override
		public void valueChanged(TreeSelectionEvent event) {
			System.out.println(event.getPath().getLastPathComponent());
			if (event.getPath().getLastPathComponent().toString()
					.equals(Modul.UYE_EKLE.getModulAd())) {
				UyeEkleView view = new UyeEkleView();
				view.setVisible(true);
				desktopPane.add(view);
				desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
				contentPane.add(desktopPane);
			}
		}
	}
}
