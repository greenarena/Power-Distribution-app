package administration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ViewMessagesAdmin{
JFrame frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String[] columnNames = {"Date Added", "Message"};



public void showTableData()
{

frame1 = new JFrame("Customers Database");
frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
//String textvalue = textbox.getText();

String added_date= "";
String texts= "";

try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity?autoReconnect=true&useSSL=false","root","Micheal@661983");

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

 String grid = content[2];


 String sql = "select * from messages where grid = 'admin'" + " order by added_date DESC";  

PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{

added_date = rs.getString("added_date");
texts = rs.getString("texts");


model.addRow(new Object[]{added_date, texts});
i++; 
 

}
//JOptionPane.showMessageDialog(null, i + " Records Found");

if(i < 1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(600,300);
}

public static void main(String args[])
{
ViewMessagesAdmin sr = new ViewMessagesAdmin();
sr.showTableData(); 

}
}

