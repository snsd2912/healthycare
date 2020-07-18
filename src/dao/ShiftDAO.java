/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Client;
import model.Shift;

/**
 *
 * @author thinh
 */
public class ShiftDAO extends DAO {

    public Shift getShiftById(int id) {
        Shift shift = new Shift();
        String sql = "SELECT * FROM tbshift WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                shift.setId(rs.getInt("id"));
                shift.setHours(rs.getString("hour"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shift;
    }
}
