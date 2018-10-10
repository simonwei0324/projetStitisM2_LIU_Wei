/**
 * 
 */
package stitis.m2liuwei;

import java.util.ArrayList;

/**
 * @author weiliu
 *
 */
public class Sexe {
	private int NumSexe;
	private String LibelleSexe;
	private ArrayList<Patient> listePatients=new ArrayList<Patient>();
	/**
	 * @param numSexe
	 * @param libelleSexe
	 * @param listePatients
	 */
	public Sexe(int numSexe, String libelleSexe, ArrayList<Patient> listePatients) {
		super();
		NumSexe = numSexe;
		LibelleSexe = libelleSexe;
		this.listePatients = listePatients;
	}
	/**
	 * @return the numSexe
	 */
	public int getNumSexe() {
		return NumSexe;
	}
	/**
	 * @param numSexe the numSexe to set
	 */
	public void setNumSexe(int numSexe) {
		NumSexe = numSexe;
	}
	/**
	 * @return the libelleSexe
	 */
	public String getLibelleSexe() {
		return LibelleSexe;
	}
	/**
	 * @param libelleSexe the libelleSexe to set
	 */
	public void setLibelleSexe(String libelleSexe) {
		LibelleSexe = libelleSexe;
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
	
	
	

}
