import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ADHERENT;
import model.Auteur;
import model.LIVRE;

public class TDSQL {

	private static ArrayList<LIVRE> ListLivre;
	private static ArrayList<Auteur> ListAuteur;
	private static ArrayList<ADHERENT> ListAdherent;

	public static LIVRE findlivre(String ISBN) {
		for (int i = 0; i != ListLivre.size(); i++) {
			if (ListLivre.get(i).getISBN().equals(ISBN)) {
				return ListLivre.get(i);
			}
		}
		return null;
	}

	public static ADHERENT findadherent(String num) {
		for (int i = 0; i != ListAdherent.size(); i++) {
			if (ListAdherent.get(i).getNum().equals(num)) {
				return ListAdherent.get(i);
			}
		}
		return null;
	}

	public static Auteur findauteur(String num) {
		for (int i = 0; i != ListAuteur.size(); i++) {
			if (ListAuteur.get(i).getNum().equals(num)) {
				return ListAuteur.get(i);
			}
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String BDD = "AP2";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		ListLivre = new ArrayList<LIVRE>();
		ListAuteur = new ArrayList<Auteur>();
		ListAdherent = new ArrayList<ADHERENT>();

		// ************************************************
		// CONNEXION A LA BDD ****************************
		// ************************************************
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd);

		// ************************************************
		// charger les AUTEURS ***************************
		// ************************************************
		Statement stmt = conn.createStatement();
		String sql = "SELECT * from auteur";
		ResultSet resultat;
		resultat = stmt.executeQuery(sql);
		while (resultat.next()) {
			Auteur a = new Auteur(resultat.getString(1), resultat.getString(2), resultat.getString(3),
					resultat.getString(4), resultat.getString(5));
			ListAuteur.add(a);

		}

		// ************************************************
		// charger les LIVRES ***************************
		// ************************************************
		stmt = conn.createStatement();
		sql = "SELECT * from livre";
		resultat = stmt.executeQuery(sql);
		while (resultat.next()) {
			LIVRE l = new LIVRE(resultat.getString(1), resultat.getString(2), resultat.getInt(3));
			ListLivre.add(l);

		}

		// ************************************************
		// charger les ADHERENTS**************************
		// ************************************************
		stmt = conn.createStatement();
		sql = "SELECT * from adherent";
		resultat = stmt.executeQuery(sql);
		while (resultat.next()) {
			ADHERENT a = new ADHERENT(resultat.getString(1), resultat.getString(2), resultat.getString(3),
					resultat.getString(4));
			ListAdherent.add(a);

		}

		// ************************************************
		// mettre les auteurs dans les livres ************
		// ************************************************
		stmt = conn.createStatement();
		sql = "SELECT livre.ISBN, auteur.num FROM livre,auteur WHERE livre.auteur=auteur.num ";
		resultat = stmt.executeQuery(sql);
		while (resultat.next()) {
			String ISBN = resultat.getString(1);
			String numAuteur = resultat.getString(2);
			LIVRE l = findlivre(ISBN);
			Auteur a = findauteur(numAuteur);
			l.setAuteur(a);
		}

		// ************************************************
		// mettre les emprunteurs dans les livres *********
		// mettre la liste des livres aux adhérents *******
		// ************************************************
		stmt = conn.createStatement();
		sql = "SELECT livre.ISBN,adherent.num FROM livre, adherent WHERE livre.adherent=adherent.num";
		resultat = stmt.executeQuery(sql);
		while (resultat.next()) {
			String ISBN = resultat.getString(1);
			String numA = resultat.getString(2);
			LIVRE l = findlivre(ISBN);
			ADHERENT a = findadherent(numA);
			l.setEmprunteur(a);
			a.ajouterLivre(l);
		}

		/*
		 * sql="INSERT INTO livre VALUES ('5','test',10,2,2)"; int maj =
		 * stmt.executeUpdate(sql);
		 */
		System.out.println("ok");

	}

}
