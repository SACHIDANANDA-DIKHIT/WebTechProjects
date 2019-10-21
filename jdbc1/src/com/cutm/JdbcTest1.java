package com.cutm;
import java.sql.*;
	class InsertPrepared{
	public static void main(String[] args) 
	{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","system","Sachita123");
	
	System.out.println("Connection Established");
	
	PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?)");
	stmt.setInt(1,101); 
	stmt.setInt(2,802);

	int i=stmt.executeUpdate();
	System.out.println(i+" records inserted");

	con.close();

	} catch(ClassNotFoundException |SQLException e) {
		System.out.println("invalid driver class");
	 }
	}
	}

	


