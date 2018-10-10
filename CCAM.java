/**
 * 
 */
package stitis.m2liuwei;

import java.util.ArrayList;


/**
 * @author weiliu
 *
 */
public class CCAM {
	private String CodeCCAM;
	private String LibelleCCAM;
	private ArrayList<Acte> listeActes=new ArrayList<Acte>();
	//ArrayList<Patient> listePatients = new ArrayList();
	
	//constructeur
	/**
	 * @param codeCCAM
	 * @param libelleCCAM
	 * @param listeActes
	 */
	public CCAM(String codeCCAM, String libelleCCAM, ArrayList<Acte> listeActes) {
		super();
		CodeCCAM = codeCCAM;
		LibelleCCAM = libelleCCAM;
		this.listeActes = listeActes;
	}

	/**
	 * @return the codeCCAM
	 */
	public String getCodeCCAM() {
		return CodeCCAM;
	}

	/**
	 * @param codeCCAM the codeCCAM to set
	 */
	public void setCodeCCAM(String codeCCAM) {
		CodeCCAM = codeCCAM;
	}

	/**
	 * @return the libelleCCAM
	 */
	public String getLibelleCCAM() {
		return LibelleCCAM;
	}

	/**
	 * @param libelleCCAM the libelleCCAM to set
	 */
	public void setLibelleCCAM(String libelleCCAM) {
		LibelleCCAM = libelleCCAM;
	}

	/**
	 * @return the listeActes
	 */
	public ArrayList<Acte> getListeActes() {
		return listeActes;
	}

	/**
	 * @param listeActes the listeActes to set
	 */
	public void setListeActes(ArrayList<Acte> listeActes) {
		this.listeActes = listeActes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CCAM CodeCCAM=" + CodeCCAM + ", LibelleCCAM=" + LibelleCCAM + ", listeActes=" + listeActes;
	}
	
	
	
	
	
	

}
