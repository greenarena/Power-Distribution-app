package administration;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewOutstandingCustomers{
JFrame frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String[] columnNames = {"Meter Identification", "National Grid", "FirstName", "LastName", "Billing"};



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

String meterNumber= "";
String grid= "";
String fName= "";
String lName= "";
String billing = "";

try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity?autoReconnect=true&useSSL=false","root","Micheal@661983");
String sql = "select * from account where billing > 0" + " order by billing DESC";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{


meterNumber = rs.getString("meterNumber");
grid = rs.getString("grid");
fName = rs.getString("fName");
lName = rs.getString("lName");
billing = rs.getString("billing");

model.addRow(new Object[]{meterNumber, grid, fName, lName, billing});
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
frame1.setSize(1200,300);
}

public static void main(String args[])
{
	ViewOutstandingCustomers sr = new ViewOutstandingCustomers();
	sr.showTableData(); 

}
}
