package testData;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class abc
{
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Driver Loaded");
		
		DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "root");
		System.out.println("Connected to Mysql DB");
			
		
	}
}
