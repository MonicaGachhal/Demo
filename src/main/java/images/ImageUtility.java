package images;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtility 
{
	public static void responseForImages( String src) throws IOException
	{
		URL url;
		try {
			url = new URL(src);
			HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
			httpURLConnection.connect();
			int code = httpURLConnection.getResponseCode();
			String msg = httpURLConnection.getResponseMessage();
			
			URL url1= httpURLConnection.getURL();
			if(code==200)
			{
				System.out.println(url1+ " Image is working fine. Response Code is: "+code+ " Response Code is: "+msg);
			}
			else
			{
				System.out.println(url1+ "Image is broken. Response code is: "+code+ " Response msg is: "+msg);
			}
		}
		catch(Exception e)
		{
			System.out.println("Link is Broken");
		}
		
	}
}
