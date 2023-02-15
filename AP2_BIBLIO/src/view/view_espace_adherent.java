package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.mainMVC;
import model.ADHERENT;
import model.historique;

import javax.swing.JLabel;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_espace_adherent {

	private JFrame frame;
	private JTextField txtAD;
	private JTextField TXTINFO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_espace_adherent window = new view_espace_adherent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public view_espace_adherent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtAD = new JTextField();
		txtAD.setBounds(139, 10, 96, 19);
		frame.getContentPane().add(txtAD);
		txtAD.setColumns(10);

		JLabel lblNewLabel = new JLabel("numéro d'adherent :");
		lblNewLabel.setBounds(10, 10, 129, 19);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("informations:");
		lblNewLabel_1.setBounds(10, 52, 113, 27);
		frame.getContentPane().add(lblNewLabel_1);

		TXTINFO = new JTextField();
		TXTINFO.setBounds(139, 52, 252, 59);
		frame.getContentPane().add(TXTINFO);
		TXTINFO.setColumns(10);
		


		JLabel lblNewLabel_2 = new JLabel("livres empruntés");
		lblNewLabel_2.setBounds(10, 122, 113, 13);
		frame.getContentPane().add(lblNewLabel_2);

		List TXThisto = new List();
		TXThisto.setBounds(139, 124, 159, 76);
		frame.getContentPane().add(TXThisto);
		
		JButton btnretour = new JButton("retour");
		btnretour.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (5).png"));
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Accueil e1 = new View_Accueil();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnretour.setBounds(178, 232, 85, 21);
		frame.getContentPane().add(btnretour);
		
		JButton btnAD = new JButton("valider");
		btnAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADHERENT ad = mainMVC.getM().findadherent(txtAD.getText());
				System.out.println(mainMVC.getM().getListLivre().size());

				for (int i = 0; i != ad.getListLivre().size(); i++) {
					TXThisto.add(ad.getListLivre().get(i).Ligne());
					
				}
			
				/*
				System.out.println(ad.getNom());
				for (historique element : ad.gethistorique()) {

					TXThisto.add(element.getLIVRE().getISBN() +" - "+ element.getLivre().getTitre()+" - "+ element.getDateD() + " - "+ element.getDateF());

				}*/
				//btnAD.setEnabled(false);

			
			}
		});
		btnAD.setBounds(246, 9, 85, 21);
		frame.getContentPane().add(btnAD);
	}
}
