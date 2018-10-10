/**
 * 
 */
package stitis.m2liuwei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import stitis.m2liuwei.PatientDaoImp;

/**
 * @author weiliu
 *
 */
public class PatientAction {
	
	static Scanner in = new Scanner(System.in);
    int  choose = 0;
    static Date date=null;
    static int numpatient;
    static boolean error=false;
    static int choix;
    
	public static void SejourPatient() {
		

    	System.out.println("Entrez numpatient Par exemple(NumPatient=100130): ");
    	do {
    	
    		try {
    	 numpatient=in.nextInt();
    	 
    	HospitalisationAction hospAction= new HospitalisationAction();
    	Hospitalisation patientHosp=hospAction.queryById(numpatient);
    	
    	if(patientHosp==null) {
    		System.out.println("Ce patient n'exsite pas , entrez un chiffre correct: ");
    		System.out.println("vous voulez quitter? : (1/0)");
    		choix=in.nextInt();
    		if(choix==1) {
    			break;
    		}else {
    			System.out.println("Continuer: ");
    		}
    		
    		error=true;
    	 }else{
    		 PatientDaoImp patientdao=new PatientDaoImp();
    		
    		 patientdao.queryById(numpatient);
    		 long Sejour_Patient=hospAction.SejourPatient(patientHosp)/(24*60*60*1000);
    		 System.out.println(patientdao.queryById(numpatient) + ", Séjours: "+Sejour_Patient);
    		 break;
    	 		}
    		}catch(InputMismatchException e) {
    			System.out.println("Entrez un type de nombre: ");
    			error=true;
    			 
    		}finally {
    			in = new Scanner(System.in);
    		}
    	}while(error);
    	
    	
    	
    	
	}
	
	
	
	public static void AddPatient() {
		
     	do {
        	
    		try {
    	//add();
    		  	PatientDaoImp actionDao= new PatientDaoImp();
        		do {
        	System.out.println("Entrez numpatient de nouveau patient: ");
        	 numpatient=in.nextInt();
     		System.out.println("Vous voulez quitter? : (1/0)");
     		choix=in.nextInt();
     		
     		if(choix==1) {
     			break;
     		}else {
     			System.out.println("Continuer: ");
     		}
        
        	Patient patient=actionDao.queryById(numpatient);
        	if(patient!=null) {
        		System.out.println("Ce patient "+numpatient +"est déja existe!");
        		System.out.println(patient);
        		break;
        	}else {
        		System.out.println("Filicitation! nouveau numpatient est valable, vous pouvez continuer");
        		
        		error=false;
        	}
        		}while(error);
    	
    			
    		if(error==true) {
    			break;
    		}
    	System.out.print("Entrez SEX(1 HOMME 2 FEMME): ");
    	int sex=in.nextInt();
    	System.out.println("Entrez datenaissance comme le format yyyy-MM-dd: ");
    	do {
    	String inputTime=in.next();
    	
    	if(PatientDaoImp.isValidDate(inputTime)==true) {
    		
    	   try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(inputTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  break;
    	}else {
    		System.out.println("Faute format pour la date de naissance");
    		System.out.println("Entrez encore une fois date de naissance comme le format yyyy-MM-dd:");
       	    numpatient=in.nextInt();
    		System.out.println("Vous voulez quitter? : (1/0)");
    		choix=in.nextInt();
    		if(choix==1) {
    			break;
    		}else {
    			System.out.println("Continuer: ");
    		}
    		error=true;
    		}
    	}while(error);
    	if(error==true) {
    		break;
    	}
    	System.out.print("Entrez prenom: ");
    	String prenom=in.next();
    	System.out.print("Entrez nom: ");
    	String nom=in.next();
    	Patient newpatient =new Patient(numpatient,sex,date,prenom,nom);
    	//PatientDaoImp actionDao= new PatientDaoImp();
    	if(actionDao.addPatient(newpatient)) {
    		System.out.println("ajout réussi");
    	}
    	break;
    		}catch(InputMismatchException e) {
    			System.out.println("Entrez un type pertinent");
    			error=true;
    			 
    		}finally {
    			in = new Scanner(System.in);
    		}
    	}while(error);
	}
	
	
	
	public static void ModifierPatient() {
    	//modifier  
    do {
    	PatientDaoImp actionDao= new PatientDaoImp();
    	try {
    		do {
    	System.out.println("Entrez numpatient: ");
    	 numpatient=in.nextInt();
    
    	Patient patient=actionDao.queryById(numpatient);
    	if(patient!=null) {
    		System.out.println("Vous voulez modifier le patient suivant: ");
    		System.out.println(patient);
    		break;
    	}else {
    		System.out.println("Ce patient n'exsite pas , entrez un chiffre correct:");
    		error=true;
    	}
    		}while(error);

    	System.out.print("Entrez patient "+numpatient+" Sexe(1 HOMME 2 FEMME): ");
    	int sex=in.nextInt();
    	System.out.println("Entrez patient "+numpatient+"  datenaissance comme le format yyyy-MM-dd: ");
    	do {
    	String inputTime=in.next();
    	
    	if(PatientDaoImp.isValidDate(inputTime)==true) {
    	  try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(inputTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  error=false;
    	  break;
    	  
    	}else {
    		System.out.println("Faute format pour la date de naissance");
    		System.out.println("Entrez encore une fois date de naissance comme le format yyyy-MM-dd:");
       	    numpatient=in.nextInt();
    		System.out.println("Vous voulez quitter? : (1/0)");
    		choix=in.nextInt();
    		if(choix==1) {
    			break;
    		}else {
    			System.out.println("Continuer: ");
    		}
    		error=true;
    		}
    	}while(error);
  
    	System.out.print("Entrer patient "+numpatient+"  prenom: ");
    	String prenom=in.next();
    	System.out.print("Entrer patient "+numpatient+"  nom: ");
    	String nom=in.next();
    	Patient newpatient =new Patient(numpatient,sex,date,prenom,nom);
    	
    	if(actionDao.updatePatient(newpatient)) {
    		System.out.println("update fini");
    	}
    	
	}catch(InputMismatchException e) {
		System.out.println("Entrer un type pertinent");
		error=true;
		 
	}finally {
		in = new Scanner(System.in);
	}
    	}while(error);
    	
    	
    	
	}
	
	public static void SupprimerPatient() {
    	//supprimer
    	do {
        	PatientDaoImp actionDao= new PatientDaoImp();
        	try {
        		do {
        	System.out.println("Entrer numpatient: ");
        	 numpatient=in.nextInt();
        
        	Patient patient=actionDao.queryById(numpatient);
        	if(patient!=null) {
        		System.out.println("Vous voulez supprimer le patient suivant: ");
        		System.out.println(patient);
        		if(actionDao.deletePatient(numpatient)) {
        			System.out.println("delete réussi");
        		}
        		break;
        	}else {
        		System.out.println("Ce patient n'exsite pas , entrez un chiffre correct:");
           	 	numpatient=in.nextInt();
           	 	System.out.println("Vous voulez quitter? : (1/0)");
           	 	choix=in.nextInt();
      		if(choix==1) {
      			break;
      		}else {
      			System.out.println("Continuer: ");
      		}
        		error=true;
        	}
        		}while(error);
        		
    		}catch(InputMismatchException e) {
    			System.out.println("Entrer un type pertinent");
    			error=true;
    			 
    		}finally {
    			in = new Scanner(System.in);
    		}
       }while(error);
    	
    	
	}
	
	public static void ChercherTousPatient() {
      	PatientDaoImp actionDao= new PatientDaoImp();
        //chercher tous les patient
       List<Patient> ListePatients =actionDao.query();
     
       if (ListePatients.size()==0) {
           System.out.println("Pas de données dans la base de données");
       } else {
       	 
       	    for (Patient patient : ListePatients)
       	         {
       	    		 System.out.println("NumPatient Prenom Nom DateNaissance\n");
       	    		 
       	             System.out.println(patient.getNumPatient() + "," + patient.getNom() + "," + patient.getPrenom()+","+patient.getDateNaissance()+"\n");
                }
       }
    	
	}
	
	
	public static void querybyNumPatient() {

     	//querybyNumPatient()
    	PatientDaoImp actionDao= new PatientDaoImp();
    	try {
		do {
	System.out.println("Entrer numpatient Par exemple(NumPatient=100130): ");
	 numpatient=in.nextInt();

	Patient patient=actionDao.queryById(numpatient);
	if(patient!=null) {
		System.out.println("Vous voulez consulter le patient suivant: ");
		System.out.println(patient);
		break;
	}else {
		System.out.println("Ce patient n'exsite pas , entrez un chiffre correct:");
   	 	numpatient=in.nextInt();
		System.out.println("Vous voulez quitter? : (1/0)");
		choix=in.nextInt();
		if(choix==1) {
			break;
		}else {
			System.out.println("Continuer: ");
		}
		error=true;
	}
		}while(error);
		}catch(InputMismatchException e) {
			System.out.println("Entrer un type pertinent");
			error=true;
			 
		}finally {
			in = new Scanner(System.in);
		}
		
    
    }
    	
	

}
