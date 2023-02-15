package model;
import java.sql.Date;
import java.util.ArrayList;
public class historique {
	
	private Date dateD;
	private Date dateF;
	private LIVRE ISBN;
	private ADHERENT AD;
	
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public LIVRE getISBN() {
		return ISBN;
	}
	public void setISBN(LIVRE iSBN) {
		ISBN = iSBN;
	}
	public ADHERENT getAD() {
		return AD;
	}
	public void setAD(ADHERENT aD) {
		AD = aD;
	}
	public historique(Date dateD, Date dateF, LIVRE iSBN, ADHERENT aD) {
		super();
		this.dateD = dateD;
		this.dateF = dateF;
		ISBN = iSBN;
		AD = aD;
	}
	
	public void AFFICHE_HISTO() {
		System.out.println("ISBN dulivre " + ISBN);
		System.out.println("date de début : " + dateD);
		
		if (dateF == null)
			System.out.println("livre pas encore restitué");
		else
			System.out.println("livrre rendu le  :" + dateF);
		
	}	
	
	
	

}
