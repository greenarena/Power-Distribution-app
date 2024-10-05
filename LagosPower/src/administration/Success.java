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
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
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

//class Success is the admin dashboard
public class Success extends JFrame {
	//get all of these declarations
	static Success frame;
	private JPanel contentPane;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JTextField meterNumber;
	private JTextField meterNumberField;
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
					frame = new Success();
					 // set window size
				    frame.setSize(1200, 700);	
				   
				    // set window title	
				    frame.setTitle("Administrator");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//constructor
	public Success() {
		//get the file name where some details has been stored
		String fileName = "info.txt";
        Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
        // create a variable to count the lines
		int count = -1;
		//and an array to store details that have been stored
		//there are 8 of them
		String[] content = new String[8];
		//loop through
		while(scanner.hasNext()){

		    content[++count] = scanner.nextLine();
		}
		//get the info from the array elements
		 String added_date = content[0];
		 String meterNumber = content[1];
		 String grid = content[2];
		 String fName = content[3];
		 String lName = content[4];
		 String user = content[5];
		 String billing = content[6];
		 String balance = content[7];
		 
		 //print the fullname on the console for debugging
		 System.out.println(fName + " " + lName);
		//this is the logo and the panel
		ImageIcon logo = new ImageIcon("images/logo.png");
		JLabel label = new JLabel("", logo, JLabel.LEFT);
		JPanel logoPanel = new JPanel(new BorderLayout());
		logoPanel.add(label, BorderLayout.WEST);
		
		//the sidebar image and the panel
		ImageIcon sideBar = new ImageIcon("images/sidebar.png");
		JLabel labelsb = new JLabel("", sideBar, JLabel.RIGHT);
		JPanel sideBarPanel = new JPanel(new BorderLayout());
		sideBarPanel.setPreferredSize(new Dimension(250, 250));
		sideBarPanel.add(labelsb);
		
		
		//some configurations for the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//the following are the layout settings
		//of the window
		
		JPanel backgroundPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel bodyPanel = new JPanel(new BorderLayout());
		setContentPane(backgroundPanel);
		setJMenuBar(createMenuBar());
	    backgroundPanel.add(topPanel);
		topPanel.setBackground(Color.white);
	    titleLabel = new JLabel("Welcome " + fName + " " + lName);
	    titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
	    titleLabel.setForeground(Color.white);
	    JPanel titlePanel = new JPanel();
		topPanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setBackground(Color.gray);
		titlePanel.add(titleLabel);
	    JPanel CreatAccountPanel = new JPanel(new GridLayout(0, 1));
	    
	    JPanel profilePanel = new JPanel();
	    profilePanel.setPreferredSize(new Dimension(250, 250));
	    profilePanel.setBackground(Color.gray);
	    JPanel billingPanel = new JPanel();
	   	    
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
	 
	    gridlabel.setForeground(Color.white);
	    gridlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    JPanel actionPanel = new JPanel(new GridLayout(7,2));
	    
	    JButton checkOutstanding = new JButton("Check Customers With Outstanding Payments");
	    checkOutstanding.setToolTipText("Check those who are oweing");
	    checkOutstanding.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton checkComplaints = new JButton("Check Customers Feedbacks");
	    //set tool tip for this button
	    checkComplaints.setToolTipText("Check Customer's Feedback");
	    checkComplaints.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton createMessage = new JButton("Send Notifications to Customers");
	    //set tool tip for this button
	    createMessage.setToolTipText("Send Notifications to Customers");
	    createMessage.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton logoutAccount = new JButton("Exit");
	    logoutAccount.setToolTipText("Logout of your account");
	    logoutAccount.setFont(new Font("Arial", Font.PLAIN, 30));
	    
	    //actionpanel is the panel for the buttons at the center of the admin dashboard
	    actionPanel.add(checkOutstanding);
	    actionPanel.add(checkComplaints);
	    actionPanel.add(createMessage);
	    actionPanel.add(logoutAccount);
	    
	    //creating events handlers for the 5 buttons at the center of the admin panel
	    checkOutstanding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				ViewOutstandingCustomers.main(new String[]{});
					
				  }
				
		});
	    
	    checkComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				ViewMessagesAdmin.main(new String[]{});
					
				  }
				
		});
	    
	    
	    createMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				 CreateMessageAdmin.main(new String[]{});    
					
				  }
				
		});
	    
	    
	    logoutAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(new String[]{});
				frame.dispose();
			}
		});
	   
	   
	    
	    //the profile section
        profilePanel.add(profileLabel);
	    profilePanel.add(adlabel);
	    profilePanel.add(fnlabel);
	    profilePanel.add(lnlabel);
	    profilePanel.add(userlabel);
	    profilePanel.add(gridlabel);
	    
	    //the logo section 
	    logoPanel.setBackground(Color.white);
	    logoPanel.add(titlePanel);

	    //the overall layout
	    topPanel.add(profilePanel, BorderLayout.WEST);
	    topPanel.add(actionPanel, BorderLayout.CENTER);
	    topPanel.add(logoPanel, BorderLayout.NORTH);
	    topPanel.add(sideBarPanel, BorderLayout.EAST);
	  
		
	}
	
	
	
	//create menu bar
		public JMenuBar createMenuBar() {
			//create a menu bar
			JMenuBar menuBar = new JMenuBar();
			//add menu called File to menubar
			JMenu menuFile = new JMenu("File");
			//add menu called Account to menubar
			JMenu menuAccount = new JMenu("Account");
			//add menu called Distribution to menubar
			JMenu menuDistribution = new JMenu("Distribution");
			//add menu called Billing to menubar
			JMenu menuBilling = new JMenu("Billing");
			//add menu called Messages to menubar
			JMenu menuMessages = new JMenu("Messages");
						
			//add menu file
			menuBar.add(menuFile);
			//add menu Account
			menuBar.add(menuAccount);
			//add menu distribution
			menuBar.add(menuDistribution);
			//add menu billing
			menuBar.add(menuBilling);
			//add menu message
			menuBar.add(menuMessages);
			
			//create a menu item called Logout
			JMenuItem menuItemLogout = new JMenuItem("Logout");
			//create a menu item called Create Customer
			JMenuItem menuItemCreate = new JMenuItem("Create Customer");
			//create a menu item called View Customer
			JMenuItem menuItemView = new JMenuItem("View Customer");
			//create a menu item called Delete Customer
			JMenuItem menuItemDelete = new JMenuItem("Delete Customer");
			//create a menu item called Schedule
			JMenuItem menuItemSchedule = new JMenuItem("Schedule");
			//create a menu item called Check Schedule
			JMenuItem menuItemViewSchedule = new JMenuItem("Check Schedule");
			//create a menu item called Billing
			JMenuItem menuItemCalculate = new JMenuItem("Calculate Billing");
			//create a menu item called Send Message
			JMenuItem menuItemSend = new JMenuItem("Send Message");
			//create a menu item called Read Message
			JMenuItem menuItemRead = new JMenuItem("Read Message");
			
			//add menuItemLogout to Menu File
			menuFile.add(menuItemLogout);
			//add menuItemCreate to Menu Account
			menuAccount.add(menuItemCreate);
			//add menuItemView to Menu Account
			menuAccount.add(menuItemView);
			//add menuItemDelete to Menu Account
			menuAccount.add(menuItemDelete);
			//add menuItemSchedule to Menu Distribution
			menuDistribution.add(menuItemSchedule);
			//add menuItemCalculate to Menu Billing
			menuBilling.add(menuItemCalculate);
			//add menuItemSend to Menu Message
			menuMessages.add(menuItemSend);
			//add menuItemRead to Menu Message
			menuMessages.add(menuItemRead);
			
			//add a separator
			menuDistribution.addSeparator();
			JMenu submenuDistribution = new JMenu("View Schedule"); 
			//add the following submenus to View Schedule
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
		
			
			//add action listener to menuItemCreate
			menuItemCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//a separate class for processing database connection and authentication
				     Database db;
				    
				    //extra classes
			        db=new Database();
			        //opions select and get the inputs
			        String[] items = {"Adeoyo", "Challenge", "Felele", "Oluyole", "Orita"};
			        JComboBox<String> combo = new JComboBox<>(items);
			        meterNumber = new JTextField();
			        fNameField = new JTextField();
			        lNameField = new JTextField();
					userField = new JTextField();
					passwordField = new JPasswordField();
					accessField = new JTextField();
				
					//set the panel and the components
					JPanel CreatAccountPanel = new JPanel(new GridLayout(0, 1));
					CreatAccountPanel.add(new JLabel("Assign to National Grid:"));
					CreatAccountPanel.add(combo);
					CreatAccountPanel.add(new JLabel("Enter Customer's Meter Number:"));
					CreatAccountPanel.add(meterNumber);
					CreatAccountPanel.add(new JLabel("Enter First Name:"));
					CreatAccountPanel.add(fNameField);
					CreatAccountPanel.add(new JLabel("Enter Last Name:"));
					CreatAccountPanel.add(lNameField);
					CreatAccountPanel.add(new JLabel("Enter Username:"));
					CreatAccountPanel.add(userField);
					CreatAccountPanel.add(new JLabel("Enter Password:"));
					CreatAccountPanel.add(passwordField);
					
					
					int result = JOptionPane.showConfirmDialog(null, CreatAccountPanel, "Create Customer",
				    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					//if the ok button is clicked, get the inputs and store in strings
					 if (result == JOptionPane.OK_OPTION) {
						String grid = (String) combo.getSelectedItem();
						String meterField = meterNumber.getText();
						String fname=fNameField.getText();
						String lname=lNameField.getText();
						String username=userField.getText();
						String pass=String.valueOf(passwordField.getPassword());
						String accessField="1";
					
						//do some validations and create user						
						if(db.checkUser(username)){
							JOptionPane.showMessageDialog(Success.this, "Sorry, Username already in the database","Submission Error!", JOptionPane.ERROR_MESSAGE);
											
							} else if(db.checkMeterNumber(meterField)){
								JOptionPane.showMessageDialog(Success.this, "Meter number is already attached to " + fname + " " + lname,"Meter Number already Exists!", JOptionPane.ERROR_MESSAGE);
							
							} else if (db.insertUser(meterField,grid,fname,lname,username,pass,accessField)) {
							    	JOptionPane.showMessageDialog(Success.this,"Customer Created Successfully!");
							} else {
								JOptionPane.showMessageDialog(Success.this, "Could not insert user! Please contact the developer","Submission Error!", JOptionPane.ERROR_MESSAGE);
							}
						
						}
						
			   }
			});
			
			//add action listener to menuItemDelete	
			menuItemDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					//a separate class for processing database connection and authentication
				     Database db;
				    
				    //extra classes
			        db=new Database();
			        
			       //get meter number here
			        meterNumber = new JTextField();
			       				
					//set panel and add components			
					JPanel DeleteAccountPanel = new JPanel(new GridLayout(0, 1));
					
					DeleteAccountPanel.add(new JLabel("Enter Customer's Meter Number:"));
					DeleteAccountPanel.add(meterNumber);
										
					int result = JOptionPane.showConfirmDialog(null, DeleteAccountPanel, "Delete Customer",
				    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					//if ok button is clicked, do some validations and execute query
					 if (result == JOptionPane.OK_OPTION) {
						
						String meterField = meterNumber.getText();
											
						if(db.checkAdmin(meterField)){
							JOptionPane.showMessageDialog(Success.this, "That's the Admin. You can not delete the admin","Submission Error!", JOptionPane.ERROR_MESSAGE);
											
							} else if(db.checkUser(meterField)){
								JOptionPane.showMessageDialog(Success.this, "Meter Number cannot be found","Unidentified Meter Number!", JOptionPane.ERROR_MESSAGE);
							
							} else if (db.deleteUser(meterField)) {
							    	JOptionPane.showMessageDialog(Success.this,"Customer Deleted Successfully!");
							} else {
								JOptionPane.showMessageDialog(Success.this, "Could not delete user! Please contact the developer","Submission Error!", JOptionPane.ERROR_MESSAGE);
							}
						
						}
					
					
				}
			});
			
			
			menuItemView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					ViewUsers.main(new String[]{});
					
					
				}
			});
		
			//add action listener to menuItemSchedule	
			menuItemSchedule.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					ScheduleElectricity.main(new String[]{});
					
					
				}
			});
			
			//add action listener to menuItemAdeoyo	
			menuItemAdeoyo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleAdeoyo.main(new String[]{});
						
					  }
					
			});
			
			//add action listener to menuItemChallenge	
			menuItemChallenge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleChallenge.main(new String[]{});
						
					  }
					
			});
			
			//add action listener to menuItemFelele
			menuItemFelele.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleFelele.main(new String[]{});
						
					  }
					
			});
			
			//add action listener to menuItemOluyole			
			menuItemOluyole.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleOluyole.main(new String[]{});
						
					  }
					
			});
			
			//add action listener to menuItemOrita
			menuItemOrita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewScheduleOluyole.main(new String[]{});
						
					  }
					
			});
			
			
			
			
			//add action listener to menuItemCalculate
			menuItemCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//a separate class for processing database connection and authentication
				     Database db;
				    
				    //extra classes
			        db=new Database();
			        
			        
			       // String[] items = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			       // JComboBox<String> combo = new JComboBox<>(items);
			        //get meter number
			        meterNumberField = new JTextField();
			        JTextField unitConsumed = new DoubleUnitConsumed();
			        //create panel and add components
					JPanel CreatBillingPanel = new JPanel(new GridLayout(0, 1));
				//	CreatBillingPanel.add(new JLabel("Select Month:"));
				//	CreatBillingPanel.add(combo);
					CreatBillingPanel.add(new JLabel("Enter the Customer's Meter Number:"));
					CreatBillingPanel.add(meterNumberField);
					CreatBillingPanel.add(new JLabel("Enter Unit Consumed:"));
					CreatBillingPanel.add(unitConsumed);
									
					//create a JOptionPane and store in int result
					int result = JOptionPane.showConfirmDialog(null, CreatBillingPanel, "Electricity Billing",
				    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					//if submit, store some inputs in string
					 if (result == JOptionPane.OK_OPTION) {
				//		String month = (String) combo.getSelectedItem();
						String meterField = meterNumberField.getText();
						String kilowatt = unitConsumed.getText();
						
						//do some validations here					
						if(meterField.isEmpty() || kilowatt.isEmpty()){
							//check to see that the meter number is enterred
							JOptionPane.showMessageDialog(Success.this, "Meter Number and Unit Consumed is Mandatory, please enter the 2 to proceed.","Submission Error!", JOptionPane.ERROR_MESSAGE);
						//validate meter number																
						} else if (!db.checkMeterNumber(meterField)) {
							//display message meter number is not recognized
							JOptionPane.showMessageDialog(Success.this, "Meter number can not be recognized.","Submission Error!", JOptionPane.ERROR_MESSAGE);
						//success
						} else
							db.calculate(meterField, kilowatt);
													
						
						
						}
						
					//	});
				}
			});
			
			//add action listener to menuItemOpen
			menuItemSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CreateMessageAdmin.main(new String[]{});
				}
			});
			
			
			menuItemRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
						ViewMessagesAdmin.main(new String[]{});
						
					  }
					
			});
			
			
			menuItemLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Login.main(new String[]{});
					frame.dispose();
				}
			});
			
			//set background color to menuBar
			menuBar.setBackground(Color.orange);
			
			//return menuBar
			return menuBar;
		}
		
		
				
		
	
	
	
}
