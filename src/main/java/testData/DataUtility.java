package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {

	public static String getPropertyData(String key) {
		File f = new File("./Data/input.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			String data = p.getProperty(key);
			return data;
		}

		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return " ";
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return " ";
		}
	}
}
