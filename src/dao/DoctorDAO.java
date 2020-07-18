/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Client;
import model.Department;
import model.Doctor;
import model.Level;

/**
 *
 * @author ssangg_ss
 */
public class DoctorDAO extends DAO{
    public DoctorDAO() {
	super();
    }
    
    /**
	* get list of doctors whose name is like @key
	* @param key
	* @return
    */
    public ArrayList<Doctor> getDoctorsById(String key){
        ArrayList<Doctor> result = new ArrayList<Doctor>();
	String sql = "select * from tbstaff, tbdoctor, tblevel, tbdepartment\n" +
                                "where tbstaff.name like ? and tbstaff.id = tbdoctor.id and "
                                    + "tbdoctor.iddepartment = tbdepartment.id and tbdoctor.idlevel = tblevel.id";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%" );
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
                                Doctor doctor = new Doctor();
                                Level level = new Level();
                                Department department = new Department();
                                
				doctor.setId(rs.getInt("id"));
				doctor.setName(rs.getString("name"));
				doctor.setDob(rs.getString("dob"));
				doctor.setGender(rs.getString("gender"));
				doctor.setPhonenumber(rs.getString("phonenumber"));
                                
                                level.setId(rs.getInt("idlevel"));
                                level.setName(rs.getString("levelname"));
                                level.setPrice(rs.getFloat("levelprice"));
                                
                                department.setId(rs.getInt("iddepartment"));
                                department.setName(rs.getString("depname"));
                                department.setDescription("depdiscription");
                                
                                doctor.setLevel(level);
                                doctor.setDepartment(department);
                                
                                result.add(doctor);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	return result;
    }
    
}
