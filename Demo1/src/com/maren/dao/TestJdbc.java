package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestJdbc {

public static void main(String[] args) {
	Connection con = null;
	Statement st = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM test.profile");
		while(rs.next()) {
			String id = rs.getString("userid");
			String name = rs.getString("name");
			String email = rs.getString("email");
			long mobile = rs.getLong("mobile");
			System.out.println("Id :" +id + "\tName : "+name + "\tEmail : "+email + "\tmobile :" +mobile);
		}
		
		}catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		}
	}
}
}
