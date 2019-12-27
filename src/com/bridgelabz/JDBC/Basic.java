package com.bridgelabz.JDBC;

import java.sql.*;

public class Basic {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://loclhost:3306/shell", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				con.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
}
