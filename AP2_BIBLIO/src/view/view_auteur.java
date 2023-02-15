package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JLabel;

import controller.mainMVC;
import model.LIVRE;

public class view_auteur {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_auteur window = new view_auteur();
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
	public view_auteur() {
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
		
		List list = new List();
		list.setBounds(129, 117, 226, 96);
		frame.getContentPane().add(list);
		
		System.out.println(mainMVC.getM().getListAuteur().size());
		
		for (int i = 0; i != mainMVC.getM().getListAuteur().size(); i++) {
			list.add(mainMVC.getM().getListAuteur().get(i).Ligne2());
		}

	
		JLabel lblauteur = new JLabel("liste des auteurs:");
		lblauteur.setBounds(85, 83, 119, 13);
		frame.getContentPane().add(lblauteur);
	}
}
