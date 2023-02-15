package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class View_Accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Accueil window = new View_Accueil();
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
	public View_Accueil() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				View_Livre e1 = null;
				try {
					e1 = new View_Livre();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(106, 284, 166, 55);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("réserver un livre ");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (3).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_emprunter e1 = new view_emprunter();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(506, 284, 181, 55);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("espace adhérent");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (4).png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_espace_adherent e1 = new view_espace_adherent();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(442, 384, 172, 37);
		frame.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2 = new JButton("réstituer un livre ");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (2).png"));
		btnNewButton_2.setBackground(new Color(240, 240, 240));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_restituer e1 = new view_restituer();
				e1.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(300, 284, 181, 54);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\livre3.jpg"));
		lblNewLabel.setBounds(101, 35, 564, 196);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnlistauteur = new JButton("liste auteurs ");
		btnlistauteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {view_auteur e1 = new view_auteur();
			e1.main(null);
			frame.setVisible(false);
		
			}
		});
		btnlistauteur.setBounds(205, 384, 154, 37);
		frame.getContentPane().add(btnlistauteur);
	}
}
