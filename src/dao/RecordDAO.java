/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Booking;
import model.Client;
import model.Doctor;
import model.Prescription;
import model.Record;
import model.Shift;

/**
 *
 * @author thinh
 */
public class RecordDAO extends DAO{
    public RecordDAO(){
        super();
    }
    
    public Record getRecord() throws SQLException{
            Record result = new Record();
            Doctor doctor;
            Prescription prescription;
            DoctorDAO doctorDAO = new DoctorDAO();
            prescriptionDAO presDAO = new prescriptionDAO();
            String sql = "SELECT * FROM tbrecord";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 doctor = doctorDAO.getDoctorById(String.valueOf(rs.getInt("iddoctor")));
                 prescription = presDAO.getPrescriptionById(rs.getInt("idprescription"));
//                shift.setId(rs.getInt("id"));
//                shift.setHours(rs.getString("hour"));
                result.setDoctor(doctor);
//                record.setBookedDate(rs.getDate("date").toString());
                result.setPrescription(prescription);
              
//                result.add(record);
            }
            return result;
        }
}
