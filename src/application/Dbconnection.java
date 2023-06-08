package application;

import java.sql.*;
public class Dbconnection {

	public Connection databaselink;
	
	public Connection getConnection() {
		
		
		try 
		{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  databaselink=DriverManager.getConnection("jdbc:mysql://localhost:3306/water_bill","root","Shreya@123");
			  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return databaselink;
	}

}