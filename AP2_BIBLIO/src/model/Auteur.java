package model;

import controller.mainMVC;

public class Auteur {
	private String num;
	private String nom;
	private String prenom;
	private String date_naissance;
	private String description;

	public Auteur(String num, String nom, String prenom, String date_naissance, String description) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.description = description;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Auteur(String nom, String prenom, String date_naissance, String description) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.description = description;
	}

	public Auteur() {
		// TODO Auto-generated constructor stub
		num = "";
		nom = "";
		prenom = "";
		date_naissance = "";
		description = "";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String Ligne2() {
		String str;
		str = num + " - ";
		if (prenom == null)
			str = str + " de " + " prenom inconnu ";
		else
			str = str + " de " + prenom;
		if (nom == null)
			str = str + " - " + " nom inconnu ";
		else {
			str = str + " - " + nom;
		}
		if (date_naissance == null)
				str = str + " - " + " date de naissance inconnu ";
		else {
				str = str + " - " + date_naissance;
		}
		if (mainMVC.getM().nblivres == null)
			str = str + " - " + " aucun livres";
	else {
			str = str + " - " + mainMVC.getM().nblivres;
	}
		return str;
	}

}
