 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Prepare {
public static void main(String arg[])
{
	try {
		Connection con=null;
		Scanner sc=null;
		PreparedStatement ps=null;
		sc=new Scanner(System.in);
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:11521:orcle","system","Sachita123");
	ps=con.prepareStatement("Insert into student values(?,?,?)");
	System.out.print("Record no. of Student?");
	int n=sc.nextInt();
	for(int i=1;i<=n;i++)
	{
		System.out.println(i+ "Student record");
		System.out.println("Enter Student Number:");
		int no=sc.nextInt();
		System.out.println("Student name:");
		String name=sc.next();
		System.out.println("Student Address:");
		String adr=sc.next();
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setString(3, adr);
		int res=ps.executeUpdate();
		if(res==0)
		{
			System.out.println(i +"record is not Inserted"); 
		}
		else
		{
			System.out.println(i +"Record is inserted");
			
		}
		sc.close();
		ps.close();
		con.close();
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}

