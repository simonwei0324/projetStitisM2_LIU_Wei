/**
 * 
 */
package stitis.m2liuwei;

import java.util.Date;

/**
 * @author weiliu
 *
 */
public class Patient {
	private int NumPatient;
	private int Sexe;
	private Date DateNaissance;
	private String Prenom;
	private String Nom;
	
	
	/**
	 * 
	 */
	public Patient() {
		super();
	}
	/**
	 * @param numPatient
	 * @param sexe
	 * @param dateNaissance
	 * @param prenom
	 * @param nom
	 */
	public Patient(int numPatient, int sexe, Date dateNaissance, String prenom, String nom) {
		super();
		NumPatient = numPatient;
		Sexe = sexe;
		DateNaissance = dateNaissance;
		Prenom = prenom;
		Nom = nom;
	}
	/**
	 * @return the numPatient
	 */
	public int getNumPatient() {
		return NumPatient;
	}
	/**
	 * @param numPatient the numPatient to set
	 */
	public void setNumPatient(int numPatient) {
		NumPatient = numPatient;
	}
	/**
	 * @return the sexe
	 */
	public int getSexe() {
		return Sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(int sexe) {
		Sexe = sexe;
	}
	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return DateNaissance;
	}
	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return Prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return Nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Patient NumPatient=" + NumPatient + ", Sexe(1 HOMME 2 FEMME)=" + Sexe + ", DateNaissance=" + DateNaissance + ", Prenom="
				+ Prenom + ", Nom=" + Nom ;
	}
	
	
	

}
