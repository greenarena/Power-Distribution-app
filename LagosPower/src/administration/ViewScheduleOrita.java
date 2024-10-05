package administration;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewScheduleOrita{
JFrame frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String[] columnNames = {"Date", "National Grid", "12AM to 03AM", "03AM to 06AM", "06AM to 09AM", "09AM to 12PM", "12PM to 03PM", "03PM to 06PM", "06PM to 09PM", "09PM to 12AM"};



public void showTableData()
{

frame1 = new JFrame("Electricity Distribution Schedule");
frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);

/*JPanel panel = new JPanel ();
panel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                    "Table Title",
                                                    TitledBorder.CENTER,
                                                    TitledBorder.TOP));
                                                    */

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

String dateString = "";
String grid = "";
String schedule1 = "";
String schedule2 = "";
String schedule3 = "";
String schedule4 = "";
String schedule5 = "";
String schedule6 = "";
String schedule7 = "";
String schedule8 = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity?autoReconnect=true&useSSL=false","root","Micheal@661983");
//System.out.println(grid + " ViewSchedule");
String sql = "select * from orita" + " order by txtDate DESC";

PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{
dateString = rs.getString("txtDate");
grid = rs.getString("grid");
schedule1 = rs.getString("schedule1");
schedule2 = rs.getString("schedule2");
schedule3 = rs.getString("schedule3");
schedule4 = rs.getString("schedule4"); 
schedule5 = rs.getString("schedule5");
schedule6 = rs.getString("schedule6");
schedule7 = rs.getString("schedule7");
schedule8 = rs.getString("schedule8"); 

model.addRow(new Object[]{dateString, grid, schedule1, schedule2, schedule3, schedule4, schedule5, schedule6, schedule7, schedule8});
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
frame1.setSize(1000,300);

//frame1.add(label);
}

public static void main(String args[])
{
	ViewScheduleOrita sr = new ViewScheduleOrita();
	sr.showTableData(); 

}
}


