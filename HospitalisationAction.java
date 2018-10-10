/**
 * 
 */
package stitis.m2liuwei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import stitis.m2liuwei.Hospitalisation;
import java.util.*;
/**
 * @author weiliu
 *
 */
public class HospitalisationAction {
	
	 
	public long SejourPatient(Hospitalisation patientHosp) {
			long sejourpatient;
			Date datesortie=patientHosp.getDateSortie();
			Date dateinput=patientHosp.getDateEntree();
			sejourpatient=datesortie.getTime()-dateinput.getTime();
		
		return sejourpatient;
		
		
		
	}
	
    //chercher un hospitalisation par numpatient
    public Hospitalisation queryById(Integer NumPatient)
         {
    		 
             Hospitalisation Patient_hosp = null;
   
            Connection conn = null;
            PreparedStatement ptmt = null;
            ResultSet rs = null;
    
            try
            {
                conn = DBConnection.getConnection();
    
                String sql = "" + " select * from tab_hospitalisation " + " where NumPatient=? ";
    
                ptmt = conn.prepareStatement(sql);
    
                ptmt.setInt(1, NumPatient);
    
                rs = ptmt.executeQuery();
    
                while (rs.next())
                {
                	Patient_hosp =new Hospitalisation();
                	Patient_hosp.setNumPatient(rs.getInt("NumPatient"));
                	Patient_hosp.setNumHospitalisation(rs.getInt("NumHospitalisation"));
                	Patient_hosp.setDateEntree(rs.getDate("DateEntree"));
                	Patient_hosp.setDateSortie(rs.getDate("DateSortie"));
                	
                	

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
    
            return  Patient_hosp;
        }
	
}
