package administration;

//importations
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	static Login frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	 //a separate class for processing database connection and authentication
    Database db;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//extra classes
        db=new Database();
        
		//creates and adds some components		
		JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
		lblAdminLoginForm.setForeground(Color.GRAY);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		//action listener for button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			
		//	if(name.equals("admin")&&password.equals("lagosPower")){
		//		Success.main(new String[]{});
		//		frame.dispose();
			
			//if login is correct, and the user is an admin, redirect to success and close the current window
			if(db.checkLogin(name, password) && (name.equals("admin")&&password.equals("admin123"))){
				Success.main(new String[]{});
				frame.dispose();
			//if login is correct, and the user is a customer, redirect to success2 and close the current window	
			}else  if(db.checkLogin(name, password)) {
				Success2.main(new String[]{});
				frame.dispose();
			//if login is incorrect, show an error message
			}else {
				JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		//add logo and set the necessary panels
		ImageIcon logo = new ImageIcon("images/logo.png");
		JLabel label = new JLabel("", logo, JLabel.CENTER);
		JPanel logoPanel = new JPanel(new BorderLayout());
		logoPanel.add(label, BorderLayout.CENTER);
		
		JPanel backgroundPanel = new JPanel(new BorderLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());
		JPanel leftPanel = new JPanel(new BorderLayout());
		JPanel groupPanel = new JPanel();
		JPanel subGroupPanel1 = new JPanel();
		JPanel topPanel = new JPanel(new BorderLayout());
		
		// set topPanel as the content pane of this window
		setContentPane(backgroundPanel);
		
		//set background color of the topPanel
		backgroundPanel.setBackground(Color.white);
		
		backgroundPanel.add(rightPanel, BorderLayout.WEST);
		backgroundPanel.add(groupPanel, BorderLayout.CENTER);
		backgroundPanel.add(topPanel, BorderLayout.NORTH);
		
		topPanel.setBackground(Color.orange);
		leftPanel.setBackground(Color.white);
		topPanel.setPreferredSize(new Dimension(150, 150));
	
		groupPanel.setBackground(Color.white);
		subGroupPanel1.setBackground(Color.white);
		
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.X_AXIS));
		groupPanel.setBounds(300, 100, 450, 300);
		topPanel.add(logoPanel, BorderLayout.CENTER);
		groupPanel.add(subGroupPanel1);
		
		
		subGroupPanel1.add(lblEnterName);
		subGroupPanel1.add(textField);
		subGroupPanel1.add(lblEnterPassword);
		subGroupPanel1.add(passwordField);
		subGroupPanel1.add(btnLogin);
	

	}
}
