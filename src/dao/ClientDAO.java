 package dao;
import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Client;

public class ClientDAO extends DAO{
    /*	
    public boolean checkLogin(Client client) {
		boolean result = false;
		String sql = "SELECT name FROM tbclient WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, client.getUsername());
			ps.setString(2, client.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				client.setName(rs.getString("name"));
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
        */
	/**
	 * search all clients in the tblClient whose name contains the @key
	 * @param key
	 * @return list of client whose name contains the @key
	 */
	public ArrayList<Client> searchClient(String key){
		ArrayList<Client> result = new ArrayList<Client>();
		String sql = "SELECT * FROM tbclient WHERE name LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setName(rs.getString("name"));
				client.setDob(rs.getString("dob"));
				client.setGender(rs.getString("gender"));
				client.setPhonenumber(rs.getString("phonenumber"));
                                client.setDescription(rs.getString("description"));
				result.add(client);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * get a client whose id is @key
	 * @param key
	 * @return
	 */
	public Client getClientById(int key){
		Client client = null;
		String sql = "SELECT * FROM tbclient WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setName(rs.getString("name"));
				client.setDob(rs.getString("dob"));
				client.setGender(rs.getString("gender"));
				client.setPhonenumber(rs.getString("phonenumber"));
                                client.setDescription(rs.getString("description"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return client;
	}
	
	/**
	 * get all client from tblClient
	 * @return
	 */
	public ArrayList<Client> getAllClient(){
		ArrayList<Client> result = new ArrayList<Client>();
		String sql = "SELECT * FROM tbclient";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setName(rs.getString("name"));
				client.setDob(rs.getString("dob"));
				client.setGender(rs.getString("gender"));
				client.setPhonenumber(rs.getString("phonenumber"));
                                client.setDescription(rs.getString("description"));
				result.add(client);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * add a new @client into the DB
	 * @param client
	 */
	public boolean addClient(Client client) throws SQLException{
                String sql2 = "select name from tbclient where username = ?\n" +
                                    "union\n" +
                                    "select name from tbstaff where username = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                ps2.setString(1, client.getUsername());
                ps2.setString(2, client.getUsername());
		ResultSet rs2 = ps2.executeQuery();
                if(rs2.getRow()>0) return false;
                
		String sql = "INSERT INTO tbclient(username,password,name,dob,gender,phonenumber,description) VALUES(?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, client.getUsername());
			ps.setString(2, client.getPassword());
			ps.setString(3, client.getName());
			ps.setString(4, client.getDob());
			ps.setString(5, client.getGender());
			ps.setString(6, client.getPhonenumber());
                        ps.setString(7, client.getDescription());
			ps.executeUpdate();
			
			//get id of the new inserted client
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				client.setId(generatedKeys.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
                return true;
	}
	
	/**
	 * update the @client
	 * @param client
	 */
	public void editClient(Client client){
		String sql = "UPDATE tbclient SET username=?,  password=?, name=?, dob=?,gender=?, phonenumber=?, description=? WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, client.getUsername());
			ps.setString(2, client.getPassword());
			ps.setString(3, client.getName());
			ps.setString(4, client.getDob());
			ps.setString(5, client.getGender());
			ps.setString(6, client.getPhonenumber());
                        ps.setString(7, client.getDescription());
			ps.setInt(8, client.getId());

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * delete the client whose id is @id
	 * @param id
	 */
	public void deleteClient(int id){
		String sql = "DELETE FROM tbclient WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
        
        /**
	 * get the client whose username is @username
	 * @param username
	*/
        public Client getClientByUsername(Client client){
		String sql = "SELECT * FROM tbclient WHERE username=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, client.getUsername());
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				client.setId(rs.getInt("id"));
				client.setDob(rs.getString("dob"));
				client.setGender(rs.getString("gender"));
				client.setPhonenumber(rs.getString("phonenumber"));
                                client.setDescription(rs.getString("description"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return client;
	}
        
}
