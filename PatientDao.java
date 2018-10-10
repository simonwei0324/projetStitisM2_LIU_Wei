/**
 * 
 */
package stitis.m2liuwei;

 import java.util.List;
 import stitis.m2liuwei.Patient;


/**
 * @author weiliu
 *
 */
public interface PatientDao { //crud patient
	
	//chercher tous les patients
	public List<Patient> query();
	//chercher un patient par numpatient
	public Patient queryById(Integer NumPatient);
	//ajouter un patient
	public boolean addPatient(Patient patient);
	public boolean updatePatient(Patient patient);
	public boolean deletePatient(Integer NumPatient);
	
	
	//chercher un patient par numpatient
	public boolean queryByNumPatient(Patient patient);

	
}
