package administration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
 
//create class to schedule electricity
public class ScheduleElectricity extends JFrame
{	
		//some private fields
		private JPanel contentPane;
		private JPanel button;
		private JTextField txtDate;
	
		//main method
		public static void main(String[] args)
		{	// it will call the run method on that object
			EventQueue.invokeLater(new Runnable()
			{	
				public void run()
				{
					try // try block 
					{
					     //create frame object
						ScheduleElectricity frame = new ScheduleElectricity();
					     frame.setVisible(true);//set visible true
				        }
				        catch (Exception e) //catch the exception
				        {
				         	e.printStackTrace();
				        }
			        }          
		        });
	        }
 
	
	//create constructor of class
	public ScheduleElectricity() 
	{
		//set title
		setTitle("Schedule Electricity Distribution ");
		//set close operation on frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//set bounds of frame
		setBounds(450, 100, 300, 400);
		//create new JPanel in contentPane
		contentPane = new JPanel();
		 JLabel title = new JLabel("Add Electricity Distribution on a daily basis");
		 title.setForeground(Color.red);
	     JLabel selectDate = new JLabel("Select Date:");
	     JLabel select = new JLabel("Select National Grid:");
	     
		//set border of frame
		contentPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//set contentPane 
		setContentPane(contentPane);
		
		//add components
		contentPane.add(title);
       	contentPane.add(selectDate);
		//create text field
		txtDate = new JTextField();
		//set bounds of text field
		txtDate.setBounds(101, 107, 86, 20);
		
		//add text field to contentPane
		contentPane.add(txtDate);
		
		//set columns
		txtDate.setColumns(10);
		
		//create button
		JButton btnNewButton = new JButton("Select");
		//create button and there object
		JButton submit = new JButton("Add Electricity Distribution");
		
		//perform action listener
		btnNewButton.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDate.setText(new DatePicker(f).setPickedDate());
				
				String dateString = txtDate.toString();
			}
		});
		//set button bound
		btnNewButton.setBounds(223, 106, 27, 23);
		//add button in contentPane
		contentPane.add(btnNewButton);
		
			
		//a separate class for processing database connection and authentication
	     Database db;
	    
	    //extra classes
        db=new Database();
       
        //options
       String[] items = {"Adeoyo", "Challenge", "Felele", "Oluyole", "Orita"};
       JComboBox<String> combo = new JComboBox<>(items);
      		
       String[] items1 = {"LightUp", "Blackout"};
       JComboBox<String> combo1 = new JComboBox<>(items1);
       String[] items2 = {"LightUp", "Blackout"};
       JComboBox<String> combo2 = new JComboBox<>(items2);
       String[] items3 = {"LightUp", "Blackout"};
       JComboBox<String> combo3 = new JComboBox<>(items3);
       String[] items4 = {"LightUp", "Blackout"};
       JComboBox<String> combo4 = new JComboBox<>(items4);
       String[] items5 = {"LightUp", "Blackout"};
       JComboBox<String> combo5 = new JComboBox<>(items5);
       String[] items6 = {"LightUp", "Blackout"};
       JComboBox<String> combo6 = new JComboBox<>(items6);
       String[] items7 = {"LightUp", "Blackout"};
       JComboBox<String> combo7 = new JComboBox<>(items7);
       String[] items8 = {"LightUp", "Blackout"};
       JComboBox<String> combo8 = new JComboBox<>(items8);
    
              	
       	//add more components to contentpane
		contentPane.add(select);
		contentPane.add(combo);
		contentPane.add(new JLabel("12:00AM to 03:00AM:"));
		contentPane.add(combo1);
		contentPane.add(new JLabel("03:00AM to 06:00AM:"));
		contentPane.add(combo2);
		contentPane.add(new JLabel("06:00AM to 09:00AM:"));
		contentPane.add(combo3);
		contentPane.add(new JLabel("09:00AM to 12:00PM:"));
		contentPane.add(combo4);
		contentPane.add(new JLabel("12:00PM to 03:00PM:"));
		contentPane.add(combo5);
		contentPane.add(new JLabel("03:00PM to 06:00PM:"));
		contentPane.add(combo6);
		contentPane.add(new JLabel("06:00PM to 09:00PM:"));
		contentPane.add(combo7);
		contentPane.add(new JLabel("09:00PM to 12:00AM:"));
		contentPane.add(combo8);
		contentPane.add(submit);
		
			
			//perform action listener
			submit.addActionListener(new ActionListener() 
			{	
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//set text which is collected by date picker i.e. set date 
					String dateString = txtDate.getText();
					//set other items
					String grid = (String) combo.getSelectedItem();
					String schedule1 = (String) combo1.getSelectedItem();
					String schedule2 = (String) combo2.getSelectedItem();
					String schedule3 = (String) combo3.getSelectedItem();
					String schedule4 = (String) combo4.getSelectedItem();
					String schedule5 = (String) combo5.getSelectedItem();
					String schedule6 = (String) combo6.getSelectedItem();
					String schedule7 = (String) combo7.getSelectedItem();
					String schedule8 = (String) combo8.getSelectedItem();
					//set today's date to a variable
					LocalDate today = LocalDate.now();
					String today1 = today.toString();
			
					//check if date is enterred
					if(dateString.isEmpty()){
						JOptionPane.showMessageDialog(ScheduleElectricity.this, "You have to select a date","Submission Error!", JOptionPane.ERROR_MESSAGE);
					
						//check if electricity has already been scheduled to this grid for this date
						} else if (db.checkDate(dateString, grid)){
							//pull out an error message to that effect
							JOptionPane.showMessageDialog(ScheduleElectricity.this, "Electricity already distributed to " + grid + " national grid for " + dateString + ". Please select another grid or date","Submission Error!", JOptionPane.ERROR_MESSAGE);
						//if successful	
						}else if (db.insertSchedule(dateString, grid, schedule1, schedule2, schedule3, schedule4, schedule5, schedule6, schedule7, schedule8)){
						//notify the user						
						JOptionPane.showMessageDialog(ScheduleElectricity.this,"Elctricity Schedule Created Successfully!");
						//if thers's problem					
						}  else {
							//tell user to contact the developer 
							JOptionPane.showMessageDialog(ScheduleElectricity.this, "Could not insert S! Please contact the developer","Submission Error!", JOptionPane.ERROR_MESSAGE);
						}
				}
			});
			
		
			
			
			
			
			}
			
		//	});
	}
	

