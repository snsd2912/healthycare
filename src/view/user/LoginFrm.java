package view.user;

import view.client.ClientHomeFrm;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UserDAO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Staff;
import model.Client;
import view.doctor.DoctorHomeFrm;
import view.schemanager.ScheManagerHomeFrm;
import view.sysmanager.SysManagerHomeFrm;
import view.client.ClientHomeFrm;

public class LoginFrm extends JFrame implements ActionListener{
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lbSignUp;
        
	public LoginFrm(){
		super("Login");		
		txtUsername = new JTextField(15);
		txtPassword = new JPasswordField(15);
		txtPassword.setEchoChar('*');
		btnLogin = new JButton("Login");
		
		JPanel pnMain = new JPanel();
                //pnMain.setBackground(Color.PINK);
		pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
		pnMain.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel lblHome = new JLabel("Login");
		lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);	
		lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
		pnMain.add(lblHome);
		pnMain.add(Box.createRigidArea(new Dimension(0,20)));
		
		JPanel pnUsername = new JPanel();
		pnUsername.setLayout(new FlowLayout());
		pnUsername.add(new JLabel("Username:"));
		pnUsername.add(txtUsername);
		pnMain.add(pnUsername);
		
		JPanel pnPass = new JPanel();
		pnPass.setLayout(new FlowLayout());
		pnPass.add(new JLabel("Password:"));
		pnPass.add(txtPassword);
		pnMain.add(pnPass);
		
		pnMain.add(btnLogin);
                btnLogin.addActionListener(this);
		
                pnMain.add(Box.createRigidArea(new Dimension(0,10)));
			
		
                lbSignUp = new JLabel("Sign Up");
                lbSignUp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        (new SignUpFrm()).setVisible(true);
                        setVisible(false);
                    }
                });
                
                pnMain.add(lbSignUp);
                pnMain.add(Box.createRigidArea(new Dimension(0,10)));
                //pnMain.add(Box.createRigidArea(new Dimension(0,20)));
                
		this.setSize(400,300);				
		this.setLocation(0,0);
		this.setContentPane(pnMain);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

        @Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnLogin))) {
                        String username = txtUsername.getText();
                        String password = String.valueOf(txtPassword.getPassword());
			Staff staff = new Staff();
			staff.setUsername(username);
			staff.setPassword(password);
			
                        Client client = new Client();
                        client.setUsername(username);
			client.setPassword(password);
                        
			UserDAO ud = new UserDAO();
                        int x = ud.checkLogin(staff,client);
                    switch (x) {
                        case 1:
                            if(staff.getPosition().equalsIgnoreCase("sysmanager")) {
                                (new SysManagerHomeFrm()).setVisible(true);
                                this.dispose();
                            }else if(staff.getPosition().equalsIgnoreCase("doctor")) {
                                (new DoctorHomeFrm()).setVisible(true);
                                this.dispose();
                            }else if(staff.getPosition().equalsIgnoreCase("schemanager")) {
                                (new ScheManagerHomeFrm()).setVisible(true);
                                this.dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(this, "The function is under construction!");
                            break;
                        case 2:
                            (new ClientHomeFrm()).setVisible(true);
                            this.dispose();
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
                            break;
                    }
		}
	}
	
	public static void main(String[] args) {
		LoginFrm myFrame = new LoginFrm();	
		myFrame.setVisible(true);	
	}
}
