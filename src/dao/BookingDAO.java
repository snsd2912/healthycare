package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bank;
import model.Bill;
import model.Booking;
import model.Client;
import model.Doctor;
import model.Shift;

public class BookingDAO extends DAO{

	public BookingDAO() {
		super();
	}
        
        /** 
         * Get all the shift  
         * @return 
         */
        public ArrayList<Shift> getShift() throws SQLException{
            ArrayList<Shift> result = new ArrayList<>();
            String sql = "SELECT * FROM tbshift";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Shift shift = new Shift();
                shift.setId(rs.getInt("id"));
                shift.setHours(rs.getString("hour"));
                result.add(shift);
            }
            return result;
        }
	
        /**
         * Check if at the shift @shift whether doctor @doctor is booked 
         * @param shift
         * @param doctor
         */
        public boolean isBooked(Doctor doctor, Shift shift){
            try {
                String sql = "SELECT * FROM tbbooking WHERE iddoctor = ? AND idshift = ? ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, doctor.getId());
                ps.setInt(2, shift.getId());
                ResultSet rs = ps.executeQuery();
                if(rs.getRow()>0) return true;
            } catch (SQLException ex) {
                Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        
	/**
	 * Insert a new booking into the database, including its booked rooms. All are added in a single transaction.
	 * @param b
	 * @return
	 */
	public Booking addBooking(Booking b) {
            try {
                String sqlAddBooking = "INSERT INTO tbbooking(iddoctor, idclient, date, idshift) VALUES(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sqlAddBooking,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, b.getDoctor().getId());
                ps.setInt(2, b.getClient().getId());
                ps.setString(3, b.getBookedDate());
                ps.setInt(4, b.getShift().getId());
                
                ps.executeUpdate();
                //get id of the new inserted booking
		ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    b.setId(generatedKeys.getInt(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return b;
	}
	
	/** Delete booking @Booking
         * @param Booking
         * @return
         */
        public boolean deleteBooking(Booking b) {
            try {
                String sqlAddBooking = "DELETE FROM tbbooking WHERE id = ?";
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //boolean result = true;
                PreparedStatement ps = con.prepareStatement(sqlAddBooking);
                ps.setInt(1, b.getId());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
	}
        
        /** 
         * Get all the bank
         * @return
         */
        public ArrayList<Bank> getBank() throws SQLException{
            ArrayList<Bank> result = new ArrayList<>();
            String sql = "SELECT * FROM tbbank";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Bank bank = new Bank();
                bank.setId(rs.getInt("id"));
                bank.setName(rs.getString("name"));
                result.add(bank);
            }
            return result;
        }
        
        /**
         * Pay the bill
         * @param bill
         * @return
         */
        public boolean addBill(Bill bill){
            try {
                String sqlAddBill = "INSERT INTO tbbill(idbooking, payment, stk, tenchuthe, date) VALUES(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sqlAddBill);
                ps.setInt(1, bill.getBooking().getId());
                ps.setString(2, bill.getPaymentType());
                ps.setString(3, bill.getStk());
                ps.setString(4, bill.getTenchuthe());
                ps.setString(5, bill.getDate());
                ps.executeUpdate();
                
                String sqlPaid = "UPDATE tbbooking SET ispaid = 1 WHERE id = ?";
                PreparedStatement ps2 = con.prepareStatement(sqlPaid);
                ps2.setInt(1, bill.getBooking().getId());
                ps2.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
}
