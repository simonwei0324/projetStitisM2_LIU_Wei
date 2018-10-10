/**
 * 
 */
package stitis.m2liuwei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import stitis.m2liuwei.Acte;

/**
 * @author weiliu
 *
 */
public class ActeAction {
	
	
	
	
	static Scanner in = new Scanner(System.in);
    int  choose = 0;
    static int numpatient;
    static boolean error=false;
    Date date = null;
    static int choix;
	
	static	int ligneActeDonnees=0;
	public static void NombreActePatient() {
		ActeAction acte_action =new ActeAction();
    	System.out.println("Entrer numpatient Par exemple(NumPatient=100130)");
    	do {
        	
    		try {
    	 numpatient=in.nextInt();
    	PatientDaoImp patientdao=new PatientDaoImp();
    	Patient patient=patientdao.queryById(numpatient);
 

        if (patient==null) {
            System.out.println("Ce patient n'exsite pas , entrez un chiffre correct:");
    		System.out.println("vous voulez quitter? : (1/0)");
    		choix=in.nextInt();
    		if(choix==1) {
    			break;
    		}else {
    			System.out.println("Continuer: ");
    		}
            error=true;
        } else {
        	List<Acte> ListeActes=acte_action.nombre_acte(numpatient) ;
        	 
        	    for (Acte acte : ListeActes)
        	         {
        	    		System.out.println("NumActe"+" DateActe\n" );
        	             System.out.println(acte.getNumActe()+" "+acte.getDateActe()+"\n");
                 }
        	    
        	    System.out.println("");
        	    System.out.println(patient+"\n nombre_acte: " +ListeActes.size());
        	    break;
        }
    		}catch(InputMismatchException e) {
    			System.out.println("Entrer un type de nombre");
    			error=true;
    			 
    		}finally {
    			in = new Scanner(System.in);
    		}
    	}while(error);
	}
	
	
	public  List<Acte> nombre_acte(int numpatient ) {

    	HospitalisationAction hospAction= new HospitalisationAction();
    	Hospitalisation patientHosp=hospAction.queryById(numpatient);
    	 return queryById(patientHosp);
    	
    	
	}
	

	   //chercher un hospitalisation par numpatient
    public List<Acte> queryById(Hospitalisation hosp)
         {
             
   
            Connection conn = null;
            PreparedStatement ptmt = null;
            ResultSet rs = null;
            List<Acte> listeActes= new ArrayList<Acte>();// met try
            
            try
            {
                conn = DBConnection.getConnection();
    
                String sql = "" + " select distinct NumActe,DateActe from tab_hospitalisation inner join tab_acte on NumHospitalisation= tab_hospitalisation.NumHospitalisation " + " where  NumPatient=? and DateActe between DateEntree and DateSortie ";
    
                ptmt = conn.prepareStatement(sql);
    
                ptmt.setInt(1, hosp.getNumPatient());
    
                rs = ptmt.executeQuery();
                
                while (rs.next())
                {
                	Acte acte=new Acte();
                	ligneActeDonnees++;
                	acte.setNumActe(rs.getInt("NumActe"));
                	//acte.setNumHospitalisation(rs.getInt("NumHospitalisation"));
                	acte.setDateActe(rs.getTimestamp("DateActe"));
                	listeActes.add(acte);
                	

                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (ptmt != null)
                     {
                        ptmt.close();
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
    
          
			return  listeActes;
        }
	

	
}
