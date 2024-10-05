package administration;

//importations
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

//class Success2 for the customers
public class Success2 extends JFrame {
	//some declarations here
	static Success2 frame;
	private JPanel contentPane;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField accessField;
	private JFileChooser chooser;
	static JTable table;
	private JTextField textsField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Success2();
					 // set window size
				    frame.setSize(1200, 700);	
				   
				    // set window title	
				    frame.setTitle("My Account");
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
	public Success2() {
		//get some info from info.txt
		//and store in an array
		//later get these info by accessing array elements
		String fileName = "info.txt";
        Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Calculating number of username and password pairs
		int count = -1;
		String[] content = new String[8];
		while(scanner.hasNext()){

		    content[++count] = scanner.nextLine();
		}
		 String added_date = content[0];
		 String meterNumber = content[1];
		 String grid = content[2];
		 String fName = content[3];
		 String lName = content[4];
		 String user = content[5];
		 String billing = content[6];
		 String balance = content[7];
		 //debugging
		 System.out.println(fName + " " + lName);
		
		 //the logo and the panel
		ImageIcon logo = new ImageIcon("images/logo.png");
		JLabel label = new JLabel("", logo, JLabel.LEFT);
		JPanel logoPanel = new JPanel(new BorderLayout());
		logoPanel.add(label, BorderLayout.WEST);
		//the sidebar
		ImageIcon sideBar = new ImageIcon("images/sidebar.png");
		JLabel labelsb = new JLabel("", sideBar, JLabel.RIGHT);
		JPanel sideBarPanel = new JPanel(new BorderLayout());
		sideBarPanel.setPreferredSize(new Dimension(250, 250));
		sideBarPanel.add(labelsb);
		//more configurations for the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 70, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//the layout
		JPanel backgroundPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel bodyPanel = new JPanel(new BorderLayout());
		setContentPane(backgroundPanel);
		setJMenuBar(createMenuBar());
	    backgroundPanel.add(topPanel);
		topPanel.setBackground(Color.white);
	    titleLabel = new JLabel("Welcome " + fName + " " + lName);
	    titleLabel.setForeground(Color.white);
	    titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
	    JPanel titlePanel = new JPanel();
		topPanel.add(titlePanel, BorderLayout.NORTH);
		//titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		titlePanel.setBackground(Color.gray);
		//add titleLabel to the titlePanel
	    titlePanel.add(titleLabel);
	    JPanel CreatAccountPanel = new JPanel(new GridLayout(0, 1));
	    JPanel profilePanel = new JPanel();
	    //profilePanel.setBounds(100, 800, 50, 20);
	    profilePanel.setPreferredSize(new Dimension(250, 250));
	    profilePanel.setBackground(Color.gray);
	    JPanel billingPanel = new JPanel();
	   // billingPanel.setBackground(Color.gray);
	    
	    JLabel profileLabel = new JLabel("MY PROFILE");
	    profileLabel.setForeground(Color.orange);
	    profileLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
	    JLabel fnlabel = new JLabel("Firstname: " + fName);
	    fnlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    fnlabel.setForeground(Color.white);
	    JLabel lnlabel = new JLabel("Lastname: " + lName);
	    lnlabel.setForeground(Color.white);
	    lnlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    JLabel userlabel = new JLabel("Username: " + user);
	    userlabel.setForeground(Color.white);
	    userlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    JLabel adlabel = new JLabel("Added Date: " + added_date);
	    adlabel.setForeground(Color.yellow);
	    adlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    JLabel gridlabel = new JLabel("National Grid: " + grid);
	    gridlabel.setForeground(Color.white);
	    gridlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    JLabel billinglabel = new JLabel("Your Electricity Bill: " + "#" + billing + ":00");
	    billinglabel.setForeground(Color.red);
	    billinglabel.setFont(new Font("Tahoma", Font.BOLD, 38));
	    JLabel balancelabel = new JLabel("Your total payment: " + "#" + balance + ":00");
	    balancelabel.setForeground(Color.black);
	    balancelabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	   
       //the message panel		
		JPanel CreatSendMessagePanel = new JPanel(new GridLayout(0, 1));
		
	    
	    //other layout configuratios
	    profilePanel.add(profileLabel);
	    profilePanel.add(adlabel);
	    profilePanel.add(fnlabel);
	    profilePanel.add(lnlabel);
	    profilePanel.add(userlabel);
	    profilePanel.add(gridlabel);
	    
	    billingPanel.add(billinglabel);
	    billingPanel.add(balancelabel);
	    
	    
	    logoPanel.setBackground(Color.white);
	    logoPanel.add(titlePanel);
	
	    topPanel.add(profilePanel, BorderLayout.WEST);
	    topPanel.add(billingPanel, BorderLayout.CENTER);
	    topPanel.add(logoPanel, BorderLayout.NORTH);
	    topPanel.add(sideBarPanel, BorderLayout.EAST);
	    
      
	
	}
	
	
	
	//create menu bar
		public JMenuBar createMenuBar() {
			//create a menu bar
			JMenuBar menuBar = new JMenuBar();
			//add menu called File to menuFile
			JMenu menuFile = new JMenu("File");
			//add menu called Distribution to menuDistribution
			JMenu menuDistribution = new JMenu("Distribution");
			//add menu called Messages to menuMessages
			JMenu menuMessages = new JMenu("Messages");
			//add menu called Messages to menuPayment
			JMenu menuPayment = new JMenu("Payment");
						
			//add menu file
			menuBar.add(menuFile);
			//add menu Distribution
			menuBar.add(menuDistribution);
			//add menu Messages
			menuBar.add(menuMessages);
			//add menu Messages
			menuBar.add(menuPayment);
			
			//create a menu item called menuItemLogout
			JMenuItem menuItemLogout = new JMenuItem("Logout");
			//create a menu item called menuItemView
			JMenuItem menuItemView = new JMenuItem("View My Profile");
			//create a menu item called menuItemViewSchedule
			JMenuItem menuItemViewSchedule = new JMenuItem("Check Power Schedule");
			//create a menu item called menuItemSend
			JMenuItem menuItemSend = new JMenuItem("Send Message to Admin");
			//create a menu item called menuItemRead
			JMenuItem menuItemRead = new JMenuItem("Read Message");
			//create a menu item called menuItemRead
			JMenuItem menuItemPay = new JMenuItem("Pay My Bill");
			
			//add menuItemLogout to Menu File
			menuFile.add(menuItemLogout);
			//add menuItemSend to Menu Messages
			menuMessages.add(menuItemSend);
			//add menuItemRead to Menu Messages
			menuMessages.add(menuItemRead);
			//add menuItemRead to Menu Messages
			menuPayment.add(menuItemPay);
			
			//add separator
			menuDistribution.addSeparator();
			JMenu submenuDistribution = new JMenu("View Schedule"); 
			//add the following submenus
			JMenuItem menuItemAdeoyo = new JMenuItem("Adeoyo");
			submenuDistribution.add(menuItemAdeoyo);

			JMenuItem menuItemChallenge = new JMenuItem("Challenge");
			submenuDistribution.add(menuItemChallenge);
			menuDistribution.add(submenuDistribution);
			
			JMenuItem menuItemFelele = new JMenuItem("Felele");
			submenuDistribution.add(menuItemFelele);
			menuDistribution.add(submenuDistribution);
			
			JMenuItem menuItemOluyole = new JMenuItem("Oluyole");
			submenuDistribution.add(menuItemOluyole);
			menuDistribution.add(submenuDistribution);
			
			JMenuItem menuItemOrita = new JMenuItem("Orita");
			submenuDistribution.add(menuItemOrita);
			menuDistribution.add(submenuDistribution);
		
			
			//action listener for menuItemView			
			menuItemView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					ViewUsers.main(new String[]{});
					
					
				}
			});
			
					
			//action listener for menuItemAdeoyo		
			menuItemAdeoyo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleAdeoyo.main(new String[]{});
						
					  }
					
			});
			
			//action listener for menuItemChallenge
			menuItemChallenge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleChallenge.main(new String[]{});
						
					  }
					
			});
			
			//action listener for menuItemFelele
			menuItemFelele.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleFelele.main(new String[]{});
						
					  }
					
			});
			
			//action listener for menuItemOluyole
			menuItemOluyole.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleOluyole.main(new String[]{});
						
					  }
					
			});
			
			//action listener for menuItemOrita
			menuItemOrita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleOluyole.main(new String[]{});
						
					  }
					
			});
			
			
			
			//action listener for menuItemSend
			menuItemSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CreateMessage.main(new String[]{});
				}
			});
			
			//action listener for menuItemRead
			menuItemRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewMessages.main(new String[]{});
						
					  }
					
			});
			
			//action listener for menuItemLogout
			menuItemLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Login.main(new String[]{});
					frame.dispose();
				}
			});
			
			
			//add action listener to menuItemPay
			menuItemPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//a separate class for processing database connection and authentication
				     Database db;
				    
				    //extra classes
			        db=new Database();
			        
			        
			        //get amount to pay
			        JTextField payBill = new DoubleUnitConsumed();
			        //create panel and add components
					JPanel CreatPaymentPanel = new JPanel(new GridLayout(0, 1));
					CreatPaymentPanel.add(new JLabel("Enter an amount to pay:"));
					CreatPaymentPanel.add(payBill);
									
					//create a JOptionPane and store in int result
					int result = JOptionPane.showConfirmDialog(null, CreatPaymentPanel, "Electricity Payment",
				    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					//if submit, store some inputs in string
					 if (result == JOptionPane.OK_OPTION) {
						
						String payNow = payBill.getText();
						
						//do some validations here					
						if(payNow.isEmpty()){
							//check to see that the amount is entered
							JOptionPane.showMessageDialog(Success2.this, "Enter the amount you are paying to proceed. Logout and Login again to update your dashboard with your payment","Submission Error!", JOptionPane.ERROR_MESSAGE);
																			
							//proceed if successful
							} else if (db.pay(payNow)) {
							JOptionPane.showMessageDialog(null,"Payment Made Successfully!");
							//otherwise display an error message
							}else {
							  JOptionPane.showMessageDialog(null, "Unable to make payment...","Submission Error!", JOptionPane.ERROR_MESSAGE);
							}
													
						
						
						}
						
					//	});
				}
			});
			
			//set background color to menuBar
			menuBar.setBackground(Color.orange);
			
		
			//return menuBar
			return menuBar;
		}
		
		
		
	
	
}
