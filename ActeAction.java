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
        	List<String> InfoActes=acte_action.nombre_acte(numpatient) ;
        	 
        	    for (String acte : InfoActes)
        	         {
        	    	System.out.println(" ");
        	    		System.out.println("CodeCCAM"+" LibelleCCAM\n" );
        	             System.out.println(acte);
                 }
        	    
        	    System.out.println("");
        	    System.out.println(patient+"\n nombre_acte: " +InfoActes.size());
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
	
	
	public  List<String> nombre_acte(int numpatient ) {

  
    	 ActeAction acte_action =new ActeAction();
    	 return acte_action.queryById(numpatient);
    	
    	
	}
	

	   //chercher un CCAM ET LIBELLECCAM par numpatient
    public List<String> queryById(int numpatient )
         {
             
   
            Connection conn = null;
            PreparedStatement ptmt = null;
            ResultSet rs = null;
            List<String> InfoActes= new ArrayList<String>();// met try
            
            
            try
            {
                conn = DBConnection.getConnection();
    

                String sql="select tab_acte.CodeCCAM,ths_ccam.LibelleCCAM from ths_ccam,tab_hospitalisation,tab_acte where NumPatient=? and tab_hospitalisation.NumHospitalisation=tab_acte.NumHopitalisation and tab_acte.CodeCCAM=ths_ccam.CodeCCAM ";
                ptmt = conn.prepareStatement(sql);
    
                ptmt.setInt(1, numpatient );
    
                rs = ptmt.executeQuery();
                
                while (rs.next())
                {
                	
                	String infoActe=rs.getString("CodeCCAM")+" | "+rs.getString("LibelleCCAM");
                	
                	InfoActes.add(infoActe);
                	

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
    
          
			return  InfoActes;
        }
	

	
}
