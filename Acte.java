/**
 * 
 */
package stitis.m2liuwei;
import java.sql.Timestamp;
/**
 * @author weiliu
 *
 */
public class Acte {
	private int NumActe;
	private String CodeCCAM;
	private  Timestamp DateActe;
	private int NumHospitalisation;
	private boolean Anesthesie;
	
	
	
	
	
	/**
	 * 
	 */
	public Acte() {
		super();
	}

	//constructeur
	/**
	 * @param numActe
	 * @param codeCCAM
	 * @param dateActe
	 * @param numHospitalisation
	 * @param anesthesie
	 */
	public Acte(int numActe, String codeCCAM, Timestamp dateActe, int numHospitalisation, boolean anesthesie) {
		super();
		NumActe = numActe;
		CodeCCAM = codeCCAM;
		DateActe = dateActe;
		NumHospitalisation = numHospitalisation;
		Anesthesie = anesthesie;
	}
	
	//getteur/setteur
	/**
	 * @return the numActe
	 */
	public int getNumActe() {
		return NumActe;
	}
	/**
	 * @param numActe the numActe to set
	 */
	public void setNumActe(int numActe) {
		NumActe = numActe;
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
	 * @return the dateActe
	 */
	public Timestamp getDateActe() {
		return DateActe;
	}
	/**
	 * @param dateActe the dateActe to set
	 */
	public void setDateActe(Timestamp dateActe) {
		DateActe = dateActe;
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
	 * @return the anesthesie
	 */
	public boolean isAnesthesie() {
		return Anesthesie;
	}
	/**
	 * @param anesthesie the anesthesie to set
	 */
	public void setAnesthesie(boolean anesthesie) {
		Anesthesie = anesthesie;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Acte NumActe=" + NumActe + ", CodeCCAM=" + CodeCCAM + ", DateActe=" + DateActe
				+ ", NumHospitalisation=" + NumHospitalisation + ", Anesthesie=" + Anesthesie + "";
	}

	
	
	
}
