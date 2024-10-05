package administration;

//importations
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
//class will create a message and send to customers
public class CreateMessageAdmin{
 
	//get an instance of the database
	Database db=new Database();
	//select options
	String[] items = {"Adeoyo", "Challenge", "Felele", "Oluyole", "Orita"};
	//get the item selected
	JComboBox<String> combo = new JComboBox<>(items);
	//create a text area
	JTextArea txt = new JTextArea(10, 20);
	//create a scroll and add the textarea
	JScrollPane scrolltxt = new JScrollPane(txt);
	//add buttton to submit
	JButton submit = new JButton("Send Message");
	
	
	//constructor
	public CreateMessageAdmin() {
 
		//create a window
		JFrame window = new JFrame();
		//create a panel
		JPanel panel = new JPanel();
		//set the content pane to panel
		window.setContentPane(panel);
		//add location to the scroll
		scrolltxt.setBounds(3, 3, 300, 200);
		//add components to panel
		panel.add(combo);
		panel.add(scrolltxt);	
		panel.add(submit);
		
		//set the size, title show the window, and also set the location of the window	
		window.setSize(600,300);
		window.setTitle("Send message to Customers");
		window.setBounds(300,300,600,300);
		window.show();	
		
		//add action listener to the submit button
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//store the selected option into a variable						
				String grid = (String) combo.getSelectedItem();
				//store the texts in a variable
				String textsArea=txt.getText();
				
				    //check if text area is empty
					if (textsArea.isEmpty()) {
						JOptionPane.showMessageDialog(null, "We cannot sent a blank message!...Please enter your message","Submission Error!", JOptionPane.ERROR_MESSAGE);
					//if successful, display a message
					} else if (db.sendMessagetoAdmin(grid,textsArea)) {
					JOptionPane.showMessageDialog(null,"Message Sent Successfully!");
					//otherwise display an error message
					}else {
					  JOptionPane.showMessageDialog(null, "Unable to send message","Submission Error!", JOptionPane.ERROR_MESSAGE);
					}
			}
			
		});
		
	}
 
	//main method
	public static void main(String[] args) {
		//create an instance of this class
		CreateMessageAdmin sta = new CreateMessageAdmin();
		
			
	}
 
}

