/**
 * 
 */
package stitis.m2liuwei;

import java.util.ArrayList;

/**
 * @author weiliu
 *
 */
public class CIM10 {

	private String CodeCIM10;
	private String LibelleCIM10;
	private ArrayList<Diagnostic> listeDiagnostics =new ArrayList<Diagnostic>();
	/**
	 * @param codeCIM10
	 * @param libelleCIM10
	 * @param listeDiagnostics
	 */
	public CIM10(String codeCIM10, String libelleCIM10, ArrayList<Diagnostic> listeDiagnostics) {
		super();
		CodeCIM10 = codeCIM10;
		LibelleCIM10 = libelleCIM10;
		this.listeDiagnostics = listeDiagnostics;
	}
	/**
	 * @return the codeCIM10
	 */
	public String getCodeCIM10() {
		return CodeCIM10;
	}
	/**
	 * @param codeCIM10 the codeCIM10 to set
	 */
	public void setCodeCIM10(String codeCIM10) {
		CodeCIM10 = codeCIM10;
	}
	/**
	 * @return the libelleCIM10
	 */
	public String getLibelleCIM10() {
		return LibelleCIM10;
	}
	/**
	 * @param libelleCIM10 the libelleCIM10 to set
	 */
	public void setLibelleCIM10(String libelleCIM10) {
		LibelleCIM10 = libelleCIM10;
	}
	/**
	 * @return the listeDiagnostics
	 */
	public ArrayList<Diagnostic> getListeDiagnostics() {
		return listeDiagnostics;
	}
	/**
	 * @param listeDiagnostics the listeDiagnostics to set
	 */
	public void setListeDiagnostics(ArrayList<Diagnostic> listeDiagnostics) {
		this.listeDiagnostics = listeDiagnostics;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CIM10 CodeCIM10=" + CodeCIM10 + ", LibelleCIM10=" + LibelleCIM10 + ", listeDiagnostics="
				+ listeDiagnostics ;
	}
	
	
	
	
}
