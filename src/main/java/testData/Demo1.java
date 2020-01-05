package testData;

public class Demo1 
{
  public static void main(String[] args) {
	String un = DataUtility.getPropertyData("un");
	String pw = DataUtility.getPropertyData("pw");
	System.out.println("Username: "+un);
	System.out.println("Password: "+pw);
}
}
