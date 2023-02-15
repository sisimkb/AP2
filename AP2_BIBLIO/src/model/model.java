package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class model {
	private Connection con;
	private ArrayList<LIVRE> ListLivre;
	private ArrayList<Auteur> ListAuteur;
	private ArrayList<ADHERENT> ListAdherent;
	public Object nblivres;
	
	public ArrayList<LIVRE> getListLivre() {
		return ListLivre;
	}
	public ArrayList<Auteur> getListAuteur() {
		return ListAuteur;
	}

	public model(Connection con, ArrayList<LIVRE> listLivre, ArrayList<Auteur> listAuteur,
			ArrayList<ADHERENT> listAdherent) {
		super();
		this.con = con;
		ListLivre = listLivre;
		ListAuteur = listAuteur;
		ListAdherent = listAdherent;
	}

	public void getAll() throws SQLException {
		ListAdherent.clear();
		ListAuteur.clear();
		ListLivre.clear();
		ListLivre = new ArrayList<LIVRE>();
		ListAuteur = new ArrayList<Auteur>();
		ListAdherent = new ArrayList<ADHERENT>();
		
        
		ResultSet resultats;
		String requete;
		// *********************************************
		// CREATION DES AuteurS
		// *********************************************
		requete = "SELECT * FROM Auteur";

		Statement stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			Auteur a = new Auteur(resultats.getString(1), resultats.getString(2), resultats.getString(3),
					resultats.getString(4), resultats.getString(5));
			ListAuteur.add(a);
		}

		// *********************************************
		// CREATION DES LIVRES
		// *********************************************
		requete = "SELECT * FROM livre";

		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			LIVRE l = new LIVRE(resultats.getString(1), resultats.getString(2), resultats.getInt(3));
			ListLivre.add(l);
		}

		// *********************************************
		// CREATION DES ADHERENTS
		// *********************************************
		requete = "SELECT * FROM adherent";

		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			ADHERENT ad = new ADHERENT(resultats.getString(1), resultats.getString(2), resultats.getString(3),
					resultats.getString(4));
			ListAdherent.add(ad);
		}

		// *********************************************
		// AJOUT liste de livre e ADHERENT
		// AJOUT de l'emprunteur e LIVRE
		// *********************************************
		requete = "SELECT ISBN,adherent FROM livre, adherent WHERE livre.adherent = adherent.num";

		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String ISBN, numadherent;
		while (resultats.next()) {
			ISBN = resultats.getString(1);
			numadherent = resultats.getString(2);
			findlivre(ISBN).setEmprunteur(findadherent(numadherent));
			findadherent(numadherent).ajouterLivre(findlivre(ISBN));
		}

		// *********************************************
		// Ajout de l'Auteur au LIVRE
		// *********************************************
		requete = "SELECT ISBN,Auteur FROM livre, Auteur WHERE livre.Auteur = Auteur.num";

		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String numAuteur;
		while (resultats.next()) {
			ISBN = resultats.getString(1);
			numAuteur = resultats.getString(2);
			findlivre(ISBN).setAuteur(findAuteur(numAuteur));

		}

		/*
		 * 
		 * System.out.println("nb Livre :"+ListLivre.size());
		 * System.out.println("nb Adherent :"+ListAdherent.size());
		 * System.out.println("nb Auteur :"+ListAuteur.size());
		 */
		System.out.println("chargement BDD OK");

	}

	public Auteur findAuteur(String num) {
		for (int i = 0; i < ListAuteur.size(); i++) 
		{
			if (ListAuteur.get(i).getNum().equals(num)) {
				return ListAuteur.get(i);
			}
		}

		return null;
	}

	public LIVRE findlivre(String ISBN) {
		for (int i = 0; i < ListLivre.size(); i++) {
			if (ListLivre.get(i).getISBN().equals(ISBN)) {
				return ListLivre.get(i);
			}
		}

		return null;
	}

	public ADHERENT findadherent(String num) {
		for (int i = 0; i < ListAdherent.size(); i++) {
			if (ListAdherent.get(i).getNum().equals(num))
			{
				return ListAdherent.get(i);
			}
		}

		return null;
	}

	public void setListLivre(ArrayList<LIVRE> listLivre) {
		ListLivre = listLivre;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public model() {
		ListLivre = new ArrayList<LIVRE>();
		ListAuteur = new ArrayList<Auteur>();
		ListAdherent = new ArrayList<ADHERENT>();
		String BDD = "ap2";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			this.con = conn;
			System.out.println("Connection OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void restituer_livre(String l) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();
		
		requete = "UPDATE `livre` SET `adherent` = NULL WHERE `livre`.`ISBN` = "+l+";";
		System.out.println(requete);
		
		stmt.executeUpdate(requete);
		
		


	}

	public void emprunter_livre(String ad, String l) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();

		requete = "UPDATE livre set adherent="+ad+" WHERE ISBN="+l+";";
		stmt.executeUpdate(requete);		
		
	


	}
	public void nblivres(String num) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();

		requete = "SELECT COUNT(*) FROM livre WHERE auteur = "+num+";";
		System.out.println(requete);
		stmt.executeUpdate(requete);
		
		
	}
 		


}
