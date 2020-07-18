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
import model.Client;
import model.Medicine;
import model.Prescription;
import model.Shift;

/**
 *
 * @author thinh
 */
public class prescriptionDAO extends DAO {
    
    public prescriptionDAO() {
        super();
    }

    /**
     * Get all the shift
     *
     * @return
     */
    public Prescription getPrescriptionById(int id) {
        Prescription pres = new Prescription();
        String sql = "SELECT * FROM tbprescription WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                pres.setId(rs.getInt("id"));
                pres.setIdMedicine(rs.getInt("idmedicine"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return pres;
    }
    
    
    public Medicine getMedicineById(int idMedicine) throws SQLException {
        Medicine medicine = new Medicine();
        String sql = "SELECT * FROM tbmedicine WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMedicine);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            medicine.setId(rs.getInt("id"));
            medicine.setName(rs.getString("name"));
            medicine.setPrice(rs.getFloat("price"));
        }
        return medicine;
    }
    
}
