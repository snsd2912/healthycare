package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Staff;
import model.Client;

public class UserDAO extends DAO{
	
	public UserDAO() {
            super();
	}
	
	public int checkLogin(Staff staff,Client client) {
                int classify = 0;
		String sql = "SELECT name, position FROM tbstaff WHERE username = ? AND password = ?";
                String sql2 = "SELECT name FROM tbclient WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, staff.getUsername());
			ps.setString(2, staff.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				staff.setName(rs.getString("name"));
				staff.setPosition(rs.getString("position"));
                                classify = 1;
			}
                        
                        if(classify == 0){
                            PreparedStatement ps2 = con.prepareStatement(sql2);
                            ps2.setString(1, client.getUsername());
                            ps2.setString(2, client.getPassword());
                            ResultSet rs2 = ps2.executeQuery();
                            if(rs2.next()) {
				client.setName(rs2.getString("name"));
                                classify = 2;
                            }
                        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return classify;
	}
}
