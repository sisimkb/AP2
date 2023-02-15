package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class view_emprunter {

	protected static final String SQLException = null;
	private JFrame frame;
	private JTextField numad;
	private JTextField numISBN;
	private JLabel lblNewLabel_3;
	private JLabel label_nomad;
	private JLabel lbl_info_livre;
	private JLabel lbl_info_fin;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_emprunter window = new view_emprunter();
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
	public view_emprunter() {
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

		JLabel lblNewLabel = new JLabel("Entrez l'ISBN du livre:");
		lblNewLabel.setBounds(29, 134, 191, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Entrer votre numéro d'adhérent:");
		lblNewLabel_1.setBounds(29, 111, 191, 13);
		frame.getContentPane().add(lblNewLabel_1);

		numad = new JTextField();
		numad.setBounds(230, 108, 96, 19);
		frame.getContentPane().add(numad);
		numad.setColumns(10);

		numISBN = new JTextField();
		numISBN.setBounds(230, 131, 96, 19);
		frame.getContentPane().add(numISBN);
		numISBN.setColumns(10);

		JButton emprunter = new JButton("emprunter livre ");
		emprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADHERENT ad;
				ad=mainMVC.getM().findadherent(numad.getText());
				if(ad==null)
					numad.setText("Adhérent non trouvé!");
				else
				{
					label_nomad.setText(ad.getNom());
				 
				}	
				LIVRE l;
				l=mainMVC.getM().findlivre(numISBN.getText());
				if(l==null)
				{
					lbl_info_livre.setText("Livre non trouvé");
				}
				else
				{
					System.out.println(l.getEmprunteur());
					if(l.getEmprunteur()==null)
					{
						lbl_info_livre.setText(l.getTitre());
						emprunter.setEnabled(true);
						lbl_info_livre.setEnabled(false);
						
						try {
							mainMVC.getM().emprunter_livre(numad.getText(),numISBN.getText());
							emprunter.setEnabled(false);
							lbl_info_fin.setText("le livre a bien été emprunté");
						}
						catch(SQLException e1){
							e1.printStackTrace();
						}
						
					}
					else
					{
						lbl_info_livre.setText("Erreur Livre indisponible");
					}
				}
			}
		});
		emprunter.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (7).png"));
		emprunter.setBounds(111, 173, 202, 21);
		frame.getContentPane().add(emprunter);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (5).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Accueil e1 = new View_Accueil();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(163, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\livre.png"));
		lblNewLabel_3.setBounds(179, 25, 69, 64);
		frame.getContentPane().add(lblNewLabel_3);
		
		label_nomad = new JLabel("");
		label_nomad.setBounds(336, 111, 100, 13);
		frame.getContentPane().add(label_nomad);
		
		lbl_info_livre = new JLabel("");
		lbl_info_livre.setBounds(336, 134, 100, 13);
		frame.getContentPane().add(lbl_info_livre);
		
		lbl_info_fin = new JLabel("");
		lbl_info_fin.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_info_fin.setBounds(111, 204, 200, 13);
		frame.getContentPane().add(lbl_info_fin);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\livre4.jpg"));
		lblNewLabel_2.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
