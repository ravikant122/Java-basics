package all_java;

import java.sql.*;

public class SqlJava {

	public static void main(String[] args) {

		// establishing connection
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// 1. select query
		try {  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from customerdetails");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));  
		}catch(Exception e) {
			System.out.println(e);
		}  
		
		// 2. insert query
		try
        { 
			int userId = 6; 
			String username="sdfnksdf";
	        String password = "pwd1"; 
	        String mobile = "5753684"; 
	        String email = "geeksgeeks.org";
            Statement stmt = con.createStatement(); 
            String q1 = "insert into customerdetails values("+userId+","+"'"+username+"'"+","+"'"+email+"'"+","+"'"+mobile+"'"+","+"'"+password+"'"+");";
            int x = stmt.executeUpdate(q1); 
            if (x > 0)             
                System.out.println("Successfully Inserted");             
            else            
                System.out.println("Insert Failed"); 
        } catch(Exception e) { 
            System.out.println(e); 
        } 
		
		// 3. update query
		try {
			int userId=6;
			String password="sfkasnf1alfd5a";
			Statement stmt = con.createStatement(); 
		    String q1 = "UPDATE customerdetails SET password="+"'"+password+"'"+" WHERE userId="+userId; 
		    int x = stmt.executeUpdate(q1); 
		      
		    if (x > 0)             
		        System.out.println("Password Successfully Updated");             
		    else            
		        System.out.println("ERROR OCCURED :("); 
		} catch(Exception e) { 
		    System.out.println(e); 
		} 
		
		// 4. delete query
		try {	
			int userId=6;
			Statement stmt = con.createStatement(); 
	        String q1 = "DELETE from customerdetails WHERE userId="+userId; 
	                  
	        int x = stmt.executeUpdate(q1); 
	          
	        if (x > 0)             
	            System.out.println("One User Successfully Deleted");             
	        else
	            System.out.println("ERROR OCCURED :(");   
	    } 
	    catch(Exception e) 
	    { 
	        System.out.println(e); 
	    } 
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  
}
