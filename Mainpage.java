/**
 * 
 */
package stitis.m2liuwei;
import java.util.Scanner;

import java.text.ParseException;
//import java.text.SimpleDateFormat;

import stitis.m2liuwei.InputNumber;




/**
 * @author weiliu
 *
 */
public class Mainpage {
	
	
	
	public static void main(String[] args) throws ParseException {
		
		
		Scanner in = new Scanner(System.in);
        int  choose = 0;

        
        do {
            
            System.out.println("=====================================================\n" + 
                                "\tSysteme de Hospitalisation\n\n" + 
                                "\t1.afficher les séjours d'un patient\n" + 
                                "\t2.afficher un nombre d'acte pendant le séjour\n" + 
                                "\t3.ajouter des informations de patient\n" +
                                "\t4.modifier des informations de patient\n" +
                                "\t5.supprimer des informations de patient\n"+
                                "\t6.afficher la liste de patients chez femme\n"+
                                "\t7.afficher un patient par NumPatient\n"+
                                "\t0.quit\n" +
                                "======================================================\n");

            choose = InputNumber.SimpleInteger(0, 7);
            if (choose == 1) {
            	
            	PatientAction.SejourPatient();

            } else if (choose == 2) {
            	ActeAction.NombreActePatient();
            }  else if (choose == 3){ 
            	
            	PatientAction.AddPatient();
            	
            }else if(choose ==4) {

            	PatientAction.ModifierPatient();
            	
            }else if(choose==5) {
            	PatientAction.SupprimerPatient();
            	
            }else if(choose==6) {
            	PatientAction.ChercherTousPatient();
            }else if(choose==7) {

        		PatientAction.querybyNumPatient();
            	
            }
            	
            
        } while (choose != 0);
        
        System.out.println("Bye~");
        
        in.close();
		
		
    }
    
  

}
