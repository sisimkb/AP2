package view;

import java.awt.EventQueue;
import controller.mainMVC;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.List;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class View_Livre {

	private JFrame frame;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Livre window = new View_Livre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public View_Livre() throws SQLException {
		mainMVC.getM().getAll();
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

		JList list = new JList();
		list.setBounds(212, 210, -105, -41);
		frame.getContentPane().add(list);

		List list_1 = new List();
		list_1.setBounds(102, 70, 230, 104);
		frame.getContentPane().add(list_1);

		System.out.println(mainMVC.getM().getListLivre().size());

		for (int i = 0; i != mainMVC.getM().getListLivre().size(); i++) {
			list_1.add(mainMVC.getM().getListLivre().get(i).Ligne());
		}

		JLabel lblNewLabel = new JLabel("liste des livres:");
		lblNewLabel.setBounds(92, 23, 154, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("retour");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\button (5).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Accueil e1 = new View_Accueil();
				e1.main(null);
				frame.setVisible(false);
			
			}
	
	
		});
		btnNewButton.setBounds(180, 197, 76, 20);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\benbr\\Downloads\\livre4.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_1);

	}
}
