package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DatabaseData 
{
	@Test
	
	public void testA() throws SQLException, ClassNotFoundException
	{
		
		String url= "jdbc:mysql://localhost:3306/selenium";
		String un= "root";
		String pw="root";
			
		//connect to DB
		Connection con = DriverManager.getConnection(url, un, pw);
		
		//to set path of db
		Statement stmt = con.createStatement();
		
		//send query to db and get the record
		ResultSet res = stmt.executeQuery("select * from EmpInfo where Name='Raghus'");
		
		while(res.next())//using next as first column is a header
		{
			String name= res.getString("Name");
			Reporter.log("Name is: "+ name, true);
			
			String id = res.getString("Id");
			Reporter.log("Id is: "+id, true);
			
			String dept = res.getString("Dept");
			Reporter.log("Dept is: "+dept, true);
			
			String gender = res.getString("Gender");
			Reporter.log("Gender is: "+gender, true);
			
			String name1 = res.getString(1);
			Reporter.log("Name is: "+name1, true);
		}
		//to close the connection
		con.close();
		
	}
}
