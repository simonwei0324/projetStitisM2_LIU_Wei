/**
 * 
 */
package stitis.m2liuwei;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
 import java.util.List;
 import stitis.m2liuwei.Patient;
 import stitis.m2liuwei.DBConnection;

 

/**
 * @author weiliu
 *
 */
public class PatientDaoImp implements PatientDao{
	// chercher tous les patient
		
	
	      public List<Patient> query()
	      {
	          List<Patient> ListePatients = new ArrayList<Patient>();
	  
	          // connecter la base de données
	          Connection conn = null;
	          ResultSet rs = null;
	          PreparedStatement ptmt = null;
	  
	          try
	          {
	              conn = DBConnection.getConnection();
	  
	              StringBuilder sb = new StringBuilder();
	              sb.append("select * from tab_patient where Sexe=2 and DateNaissance between'2004-01-01'and'2004-06-06'");
	  
	              // manipulation de la base de données
	              ptmt = conn.prepareStatement(sb.toString());
	  
	              rs = ptmt.executeQuery();
	  
	              Patient patient = null;
	  
	              while (rs.next())
	              {
	                  patient = new Patient();
	                  patient.setNumPatient(rs.getInt("NumPatient"));
	                  patient.setSexe(rs.getInt("Sexe"));
	                  patient.setDateNaissance(rs.getDate("DateNaissance"));
	                  patient.setPrenom(rs.getString("Prenom"));
	                  patient.setNom(rs.getString("Nom"));
	  
	                  ListePatients.add( patient);
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
	  
	         return ListePatients;
	      }
	      
	      
	      
	      //chercher un patient par id
	      
	      public boolean queryByNumPatient( Patient patient) 
	      {
	    	  return true;
	      }
	      
	      public  Patient queryById(Integer NumPatient)
	           {
	               Patient patientObtenu = null;
	     
	              Connection conn = null;
	              PreparedStatement ptmt = null;
	              ResultSet rs = null;
	      
	              try
	              {
	                  conn = DBConnection.getConnection();
	      
	                  String sql = "" + " select * from tab_patient " + " where NumPatient=? ";
	      
	                  ptmt = conn.prepareStatement(sql);
	      
	                  ptmt.setInt(1, NumPatient);
	      
	                  rs = ptmt.executeQuery();
	      
	                  while (rs.next())
	                  {
	                	  patientObtenu = new Patient();
	                	  patientObtenu.setNumPatient(rs.getInt("NumPatient"));
	                	  patientObtenu.setSexe(rs.getInt("Sexe"));
	                	  patientObtenu.setDateNaissance(rs.getDate("DateNaissance"));
	                	  patientObtenu.setPrenom(rs.getString("Prenom"));
	                	  patientObtenu.setNom(rs.getString("Nom"));
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
	      
	              return patientObtenu;
	          }
	      
	      // ajouter un patient
	  	public boolean addPatient(Patient patient)
	  	{
	  		
	  		         // connecter la base de données
	  		         Connection conn = null;
	  		         PreparedStatement ptmt = null;
	  		 
	  		         try
	  		         {
	  		             conn = DBConnection.getConnection();
	  		 
	  		             String sql = "insert into tab_patient(NumPatient,Sexe,DateNaissance,Prenom,Nom) values(?,?,?,?,?)";
	  		 
	  		             ptmt = conn.prepareStatement(sql);
	  		 
	  		             ptmt.setInt(1, patient.getNumPatient());
	  		             ptmt.setInt(2,patient.getSexe());
	  		             
	  		             ptmt.setDate(3,new java.sql.Date(patient.getDateNaissance().getTime()));
	  		             ptmt.setString(4, patient.getPrenom());
	  		             ptmt.setString(5, patient.getNom());
	  		 
	  		             ptmt.execute();
	  		         }
	  		         catch (SQLException e)
	  		         {
	  		             e.printStackTrace();
	  		         }
	  		         finally
	  		         {
	  		             try
	  		             {
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
	  		         return true;
	  		
	  	};
	  	
	  	//modifier
		public boolean updatePatient(Patient patient) {
			  Connection conn = null;
			           PreparedStatement ptmt = null;
			   
			           try
			           {
			               conn = DBConnection.getConnection();
			   
			               String sql = "update tab_patient set NumPatient=?,Sexe=?,DateNaissance=?,Prenom=?,Nom=? where NumPatient=?";
			   
			               ptmt = conn.prepareStatement(sql);
			   
		  		             ptmt.setInt(1, patient.getNumPatient());
		  		             ptmt.setInt(2,patient.getSexe());
		  		           
		  		             ptmt.setDate(3,new java.sql.Date(patient.getDateNaissance().getTime()));
		  		             ptmt.setString(4, patient.getPrenom());
		  		             ptmt.setString(5, patient.getNom());
		  		             ptmt.setInt(6, patient.getNumPatient());
			               ptmt.execute();
			           }
			           catch (SQLException e)
			           {
			               e.printStackTrace();
			           }
			           finally
			           {
			              try
			               {
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
			           return true;
		};
		
		//supprimer
		public boolean deletePatient(Integer NumPatient) {
			         Connection conn = null;
			         PreparedStatement ptmt = null;
			 
			         try
			         {
			             conn = DBConnection.getConnection();
			 
			             String sql = "delete  from tab_patient where NumPatient= ?";
			 
			             ptmt = conn.prepareStatement(sql);
			 
			             ptmt.setInt(1, NumPatient);
			 
			             ptmt.execute();
			         }
			         catch (SQLException e)
			         {
			             e.printStackTrace();
			         }
			         finally
			         {
			             try
			             {
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
			         return true;
			     }
			
		public static boolean isValidDate(String str) {
	        boolean convertSuccess = true;
	        // date de naissance au format yyyy-mm-dd；
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            // met lenient false.
	            // sinon SimpleDateFormat est pas strict.
	            format.setLenient(false);
	            format.parse(str);
	        } catch (ParseException e) {
	            // e.printStackTrace();
	            // si throw java.text.ParseException ou NullPointerException，ca veut dire un problème
	            convertSuccess = false;
	        }
	        return convertSuccess;
	    }

	
		}
