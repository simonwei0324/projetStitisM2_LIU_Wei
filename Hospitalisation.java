/**
 * 
 */
package stitis.m2liuwei;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author weiliu
 *
 */
public class Hospitalisation {
	private int NumHospitalisation;
	private int NumPatient;
	private Date DateEntree;
	private Date DateSortie;
	private ArrayList<Patient> listePatients= new ArrayList<Patient>();
	private ArrayList<Diagnostic> listsDiagnostics= new ArrayList<Diagnostic>();
	
	
	/**
	 * 
	 */
	public Hospitalisation() {
		super();
	}
	
	

	/**
	 * @param numHospitalisation
	 * @param numPatient
	 * @param dateEntree
	 * @param dateSortie
	 */
	public Hospitalisation(int numHospitalisation, int numPatient, Date dateEntree, Date dateSortie) {
		super();
		NumHospitalisation = numHospitalisation;
		NumPatient = numPatient;
		DateEntree = dateEntree;
		DateSortie = dateSortie;
	}



	/**
	 * @param numHospitalisation
	 * @param numPatient
	 * @param dateEntree
	 * @param dateSortie
	 * @param listePatients
	 * @param listsDiagnostics
	 */
	public Hospitalisation(int numHospitalisation, int numPatient, Date dateEntree, Date dateSortie,
			ArrayList<Patient> listePatients, ArrayList<Diagnostic> listsDiagnostics) {
		super();
		NumHospitalisation = numHospitalisation;
		NumPatient = numPatient;
		DateEntree = dateEntree;
		DateSortie = dateSortie;
		this.listePatients = listePatients;
		this.listsDiagnostics = listsDiagnostics;
	}
	
	/**
	 * @return the numHospitalisation
	 */
	public int getNumHospitalisation() {
		return NumHospitalisation;
	}
	/**
	 * @param numHospitalisation the numHospitalisation to set
	 */
	public void setNumHospitalisation(int numHospitalisation) {
		NumHospitalisation = numHospitalisation;
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
	 * @return the dateEntree
	 */
	public Date getDateEntree() {
		return DateEntree;
	}
	/**
	 * @param dateEntree the dateEntree to set
	 */
	public void setDateEntree(Date dateEntree) {
		DateEntree = dateEntree;
	}
	/**
	 * @return the dateSortie
	 */
	public Date getDateSortie() {
		return DateSortie;
	}
	/**
	 * @param dateSortie the dateSortie to set
	 */
	public void setDateSortie(Date dateSortie) {
		DateSortie = dateSortie;
	}
	/**
	 * @return the listePatients
	 */
	public ArrayList<Patient> getListePatients() {
		return listePatients;
	}
	/**
	 * @param listePatients the listePatients to set
	 */
	public void setListePatients(ArrayList<Patient> listePatients) {
		this.listePatients = listePatients;
	}
	/**
	 * @return the listsDiagnostics
	 */
	public ArrayList<Diagnostic> getListsDiagnostics() {
		return listsDiagnostics;
	}
	/**
	 * @param listsDiagnostics the listsDiagnostics to set
	 */
	public void setListsDiagnostics(ArrayList<Diagnostic> listsDiagnostics) {
		this.listsDiagnostics = listsDiagnostics;
	}
	

	
	
}
