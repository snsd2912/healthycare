/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Department;
import model.Doctor;
import model.Level;

/**
 *
 * @author ssangg_ss
 */
public class StaffDAO extends DAO{

    public StaffDAO() {
    }
    
    /**
     * Get all departments
     * @return
     */
    public ArrayList<Department> getDepartments() throws SQLException{
        ArrayList<Department> result = new ArrayList<Department>();
        String sql = "SELECT * FROM tbdepartment";
        PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
            Department dep = new Department();
            dep.setId(rs.getInt("id"));
            dep.setName(rs.getString("depname"));
            dep.setDescription(rs.getString("depdescription"));
            result.add(dep);
	}
        return result;
    }
    
    /**
     * Get all staffs whose department is @department
     * @param department
     * @return 
     */
    public ArrayList<Doctor> getDoctors(Department dep) throws SQLException{
        ArrayList<Doctor> result = new ArrayList<>();
        String sql = "select * from tbstaff, tbdoctor, tblevel, tbdepartment\n" +
                        "where tbdepartment.id = ? and tbstaff.id = tbdoctor.id and tbdoctor.iddepartment = tbdepartment.id and tbdoctor.idlevel = tblevel.id;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dep.getId());
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
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
        return result;
    }
}
