package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.mainMVC;
import model.LIVRE;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class view_restituer {

	private JFrame frame;
	private JTextField numISBN;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lbl_info_livre;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_restituer window = new view_restituer();
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
	public view_restituer() {
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

		JLabel lblNewLabel = new JLabel("entrer l'ISBN du livre:");
		lblNewLabel.setBounds(62, 127, 169, 13);
		frame.getContentPane().add(lblNewLabel);

		numISBN = new JTextField();
		numISBN.setBounds(241, 124, 96, 19);
		frame.getContentPane().add(numISBN);
		numISBN.setColumns(10);

		JButton restituer = new JButton("restituer le livre");
		restituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE l;
				l=mainMVC.getM().findlivre(numISBN.getText());
				if(l==null)
				{
					lbl_info_livre.setText("Livre non trouvé");
				}
				else
				{
					if(l.getEmprunteur()==null)
					{
						
					
						lbl_info_livre.setText("Erreur ");

					}
					else
					{
						lbl_info_livre.setText(l.getTitre());
						restituer.setEnabled(true);
						lbl_info_livre.setEnabled(false);
						
						try {
							mainMVC.getM().restituer_livre(numISBN.getText());
							restituer.setEnabled(false);
							lbl_info_livre.setText("le livre a bien été restituer");
						}
						catch(SQLException e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
		restituer.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (6).png"));
		restituer.setBounds(105, 201, 183, 21);
		frame.getContentPane().add(restituer);
		
		btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (5).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Accueil e1 = new View_Accueil();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(161, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\emprunter.png"));
		lblNewLabel_2.setBounds(174, 35, 72, 64);
		frame.getContentPane().add(lblNewLabel_2);
		
		lbl_info_livre = new JLabel("");
		lbl_info_livre.setBounds(105, 164, 198, 13);
		frame.getContentPane().add(lbl_info_livre);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\livre4.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 266);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
