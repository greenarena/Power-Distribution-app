package administration;

import java.io.File;
import java.io.FileNotFoundException;
//importations
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

//class database holds the database connections and a lot of other operations on the database 
public class Database 
{
	//variables
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;
    PreparedStatement pstmeter;
    PreparedStatement preparedStmt;
    PreparedStatement pstView;
    PreparedStatement pstDate;
  
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs6;
    Database()
    {
        try{
             
            //the path for the jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            //connections
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity?autoReconnect=true&useSSL=false","root","Micheal@661983");
                        pst=con.prepareStatement("select * from account where user=? and password=?");
                        pst2=con.prepareStatement("select * from account where user=?");
                        pstmeter=con.prepareStatement("select * from account where meterNumber=?");
                        pstView=con.prepareStatement("select * from account",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          }
        //catch exception and print it out
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }


    //check the login details and return a boolean
    public Boolean checkLogin(String uname,String pwd)
    {
        try {
                        
            pst.setString(1, uname); //this replaces the 1st  "?" in the query for user
            pst.setString(2, pwd);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            
            //if there's a match
            if(rs.next())
            {
            	//get all the info of this user from the database
            	String added_date = rs.getString("added_date");
            	String meterNumber = rs.getString("meterNumber");
            	String grid = rs.getString("grid");
            	String fName = rs.getString("fName");
            	String lName = rs.getString("lName");
            	String User = rs.getString("user");
            	String billing = rs.getString("billing");
            	String balance = rs.getString("balance");  
            	//write the info to a text file called info.txt
            	//so I can make use of it later
            	FileWriter fileWriter = new FileWriter("info.txt");
              
                fileWriter.write(added_date + "\n");
                fileWriter.write(meterNumber + "\n");
                fileWriter.write(grid + "\n");
                fileWriter.write(fName + "\n");
                fileWriter.write(lName + "\n");
                fileWriter.write(User + "\n");
                fileWriter.write(billing + "\n");
                fileWriter.write(balance + "\n");
                fileWriter.close();
                
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        //catch error    
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
    }
    
    
    //check username so we don't have duplicates while creating users
    public Boolean checkUser(String uname)
    {
        try {
                        
            pst2.setString(1, uname); //this replaces the 1st  "?" in the query for username
            //executes the prepared statement
            rs2=pst2.executeQuery();
            if(rs2.next())
            {
                //this is set to true if the query founds any corresponding data
                return true;
            }
            else
            {
                return false; //false if there's no match
            }
            
        //catch exceptions    
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
   }
    
    //this method checks to see if meter number exists
    public Boolean checkMeterNumber(String meterNumber)
    {
        try {
                        
        	pstmeter.setString(1, meterNumber); //this replaces the 1st  "?" in the query for username
            //executes the prepared statement
            rs6=pstmeter.executeQuery();
            if(rs6.next())
            {
                //true if the query founds any corresponding data
                return true;
            }
            else
            {
                return false;//false if there's no match
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating meter number"+e);
            return false;
        }
   }
    
    
    //this will insert user
    public Boolean insertUser(String meterNumber, String grid, String fName, String lName, String uname, String password, String access)
    {
    	try
	    {
	      // the mysql insert statement
	      String query = " insert into account (meterNumber, grid,fName, lName, user, password, access, billing, balance)"
	        + " values (?,?,?,?,?,?,?,?,?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      
	      preparedStmt.setString (1, meterNumber);
	      preparedStmt.setString (2, grid);
	      preparedStmt.setString (3, fName);
	      preparedStmt.setString (4, lName);
	      preparedStmt.setString (5, uname);
	      preparedStmt.setString(6, password);
	      preparedStmt.setInt (7, 1);
	      preparedStmt.setDouble (8, 0.00); //this will set the billing to 0
	      preparedStmt.setDouble (9, 0.00); //and the balance to 0

	      // execute the preparedstatement
	      int rs3 = preparedStmt.executeUpdate();
	      
			    if(rs3 == 1)
		          {
		              //if query is executed
		              return true;
		          }
		          else
		          {
		              return false; //query is not executed
		          }
	    //catch exception
	    } catch (Exception e) {
         
          System.out.println("error while inserting"+e);
          return false;
          
      }
     }
    
    //check the meterNumber for admin, so it is not deleted
    public Boolean checkAdmin(String meterField)
    {
    
    	if (meterField.equals("admin"))
            {
                //returns true if meter number is admin
                return true;
            }
            else
            {
                return false;
            }
        
   }
    
    
    //delete meter number
    public Boolean deleteUser(String meterNumber)
    {
    	try
	    {
	      // the mysql insert statement
	      String queryDelete = "DELETE FROM account WHERE meterNumber = ?";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmtDelete = con.prepareStatement(queryDelete);
	      
	      // set the corresponding param
	      preparedStmtDelete.setString(1, meterNumber);
         

	      // execute the preparedstatement
	      int rsDelete = preparedStmtDelete.executeUpdate();
	      
	    if(rsDelete == 1)
          {
              //TRUE iff the query founds any corresponding data
              return true;
          }
          else
          {
              return false;
          }
      } catch (Exception e) {
          
          System.out.println("error while deleting"+e);
          return false;
          
      }
    }
    
    //insert power schedule
    public Boolean insertSchedule(String txtDate, String grid, String schedule1, String schedule2, String schedule3, String schedule4, String schedule5, String schedule6, String schedule7, String schedule8)
    {
    	    	
    	try
	    {
    		//record the number of hours that is scheduled
    		int hours = 0;
    		if(schedule1 == "LightUp") {hours=hours+3;}
    		if(schedule2 == "LightUp") {hours=hours+3;}
    		if(schedule3 == "LightUp") {hours=hours+3;}
    		if(schedule4 == "LightUp") {hours=hours+3;}
    		if(schedule5 == "LightUp") {hours=hours+3;}
    		if(schedule6 == "LightUp") {hours=hours+3;}
    		if(schedule7 == "LightUp") {hours=hours+3;}
    		if(schedule8 == "LightUp") {hours=hours+3;}
	      // the mysql insert statement
	      String query = "insert into " + grid + " (txtDate,grid,schedule1, schedule2, schedule3, schedule4, schedule5, schedule6, schedule7, schedule8, hours)"
	        + " values (?,?,?,?,?,?,?,?,?,?,?)";
	      
	      

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (1, txtDate);
	      preparedStmt.setString (2, grid);
	      preparedStmt.setString (3, schedule1);
	      preparedStmt.setString (4, schedule2);
	      preparedStmt.setString (5, schedule3);
	      preparedStmt.setString (6, schedule4);
	      preparedStmt.setString (7, schedule5);
	      preparedStmt.setString (8, schedule6);
	      preparedStmt.setString (9, schedule7);
	      preparedStmt.setString (10, schedule8);
	      preparedStmt.setInt (11, hours);
	     
	      //print the number of hours in the console, for debug purpose
	      System.out.println(hours + " hours");
	      // execute the preparedstatement
	      int rs5 = preparedStmt.executeUpdate();
	    
	      //check if query is executed
	    if(rs5 == 1)
          {
              //TRUE iff the query founds any corresponding data
              return true;
          }
          else
          {
              return false;
          }
      } catch (Exception e) {
        
          System.out.println("error while inserting"+e);
          return false;
          
      }
     }
    
    
     	
    //method to check date
    public Boolean checkDate(String txtDate, String grid)
    {
    	
    	   
        try {
             
        	pstDate=con.prepareStatement("select * from " + grid +" where txtDate=?");
			
			
            pstDate.setString(1, txtDate); //this replaces the 1st  "?" in the query for username
            //executes the prepared statement
            rs2=pstDate.executeQuery();
            if(rs2.next())
            {
             
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
        
            System.out.println("error while validating"+e);
            return false;
        }
   }
    
    
    //this method will calculate the customer's bill according to the total number of 
    //hours of light from the respective grid and multiplied by the their meter's reading
    //and finaly removes the customer's payment.
    public void calculate(String meterNumberField, String unitConsumed)
    {
    	
    	try
	    {
	      //check for meter number
	      String queryCal = " select * from account where meterNumber='" + meterNumberField + "'";
	      
	      //execute
	      PreparedStatement preparedStmt = con.prepareStatement(queryCal);
	      
	      ResultSet rs = preparedStmt.executeQuery();
	      
	      int i =0;
	      	 //get some details from the owner of the meter number 
		      while(rs.next())
		      {
		    	  
		      //store the details in variables
		      String meterField = rs.getString("meterNumber");
		      String grid = rs.getString("grid");
		      String fName = rs.getString("fName");
		      String lName = rs.getString("lName");
		      String dateRegistered = rs.getString("added_date");
		      int balance = rs.getInt("balance"); 
		      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		   
		     
		      //calculate the total number of hours scheduled to that grid from the time that this customer has been assigned to it
		      String queryNumberOfHours = "SELECT SUM(hours) FROM " + grid + " WHERE dateScheduled > '" + dateRegistered + "'";
		      PreparedStatement preparedStmtHours = con.prepareStatement(queryNumberOfHours);
		      ResultSet preparedStmtHrs = preparedStmtHours.executeQuery();
		      
		      preparedStmtHrs.next();
		      String totalHours = preparedStmtHrs.getString(1);
		      
		      //if there's no power scheduled to that grid since the customer is added to the grid
		      if (totalHours == null) {
		    	  JOptionPane.showMessageDialog(null, "Unable to compute billing for this user","Submission Error!", JOptionPane.ERROR_MESSAGE); 
		      }
		    
		      // this will calculate the billing based on the unit consumed multiplied by the number of hours assigned and minus the total amount in the balance
		      int billing = (Integer.parseInt(unitConsumed) * Integer.parseInt(totalHours)) - balance;
		      
		      //print it out in the console for debug purpose
		      System.out.println(billing);
		      
		      //update the billing on the customer's account
		      String queryUpdateBilling = " update account set billing =? where meterNumber =?";
		      PreparedStatement preparedStmtBilling = con.prepareStatement(queryUpdateBilling);
		      preparedStmtBilling.setInt(1,billing);
		      preparedStmtBilling.setString(2,meterField);
		
		      int rsBilling = preparedStmtBilling.executeUpdate();
		      
				      if(rsBilling==1) {
				    	  JOptionPane.showMessageDialog(null,"A total amount of #" + billing + " has been billed to " + fName + " " + lName + "'s account");
				      }else {
				    	  JOptionPane.showMessageDialog(null, "Unable to compute billing for this user","Submission Error!", JOptionPane.ERROR_MESSAGE); 
				      }
		      	   
		      }
	      
      } catch (Exception e) {
        
          System.out.println("error while inserting billing "+e);
         // return false;
          
      }
	
     }
    
    
    	//method to send message. THIS IS NOT USED*
    	public Boolean sendMessage(String grid, String texts)
        {
        	try
    	    {
    	      // the mysql insert statement
    	      String query = " insert into messages (grid,texts)"
    	        + " values (?,?)";

    	      PreparedStatement preparedStmt = con.prepareStatement(query);
    	      preparedStmt.setString (1, grid);
    	      preparedStmt.setString (2, texts);
    	      
    	   // execute the preparedstatement
    	      int rs4 = preparedStmt.executeUpdate();
    	      
    	    if(rs4 == 1)
              {
                return true;
              }
              else
              {
                  return false;
              }
          } catch (Exception e) {
             System.out.println("error while sending message"+e);
              return false;
          }
    	
    	
   }
    	
       	//sending message to the admin
    	public Boolean sendMessagetoAdmin(String grid, String textArea)
        {
        	try
    	    {
    	      // the mysql insert statement
    	      String query = " insert into messages (grid,texts)"
    	        + " values (?,?)";

    	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmt = con.prepareStatement(query);
    	      preparedStmt.setString (1, grid);
    	      preparedStmt.setString (2, textArea);
    	      
    	   // execute the preparedstatement
    	      int rs4 = preparedStmt.executeUpdate();
    	      
    	    if(rs4 == 1)
              {
                 return true;
              }
              else
              {
                  return false;
              }
          } catch (Exception e) {
         
              System.out.println("error while sending message"+e);
              return false;
          }
    	
    	
   }
    	
    	
    	//sending message to the admin
    	public Boolean pay(String payNow)
        {
        	try
    	    {
        		
        		String fileName = "info.txt";
				Scanner scanner = null;
						try {
							scanner = new Scanner(new File(fileName));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
				int count = -1;
				String[] content = new String[8];
				
			while(scanner.hasNext()){
				
				    content[++count] = scanner.nextLine();
			}
				//get the user's meter number from the txt file
				 String meterNumber = content[1];
        		
    	      // the mysql update balance
    	      String queryPay = " update account set balance =? where meterNumber =?";
    	      
    	          	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmtPay = con.prepareStatement(queryPay);
    	      preparedStmtPay.setString (1, payNow);
    	      preparedStmtPay.setString (2, meterNumber);
    	    
    	      
    	   // execute the preparedstatement
    	      int rsPay = preparedStmtPay.executeUpdate();
    	      
    	    if(rsPay == 1)
              {
                 return true;
              }
              else
              {
                  return false;
              }
          } catch (Exception e) {
         
              System.out.println("error while making payments "+e);
              return false;
          }
    	
    	
   }
    
    
   
}
