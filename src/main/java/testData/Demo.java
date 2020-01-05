package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		File f = new File("./Data/input.properties");

		try {
			FileInputStream fis = new FileInputStream(f);

			Properties p = new Properties();
			p.load(fis);
			String un = p.getProperty("un");
			String pw = p.getProperty("pw");
			System.out.println("Username is "+un);
			System.out.println("Password is "+pw);
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}

}
