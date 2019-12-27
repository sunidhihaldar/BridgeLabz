package com.bridgelabz.JDBC;

import java.sql.*;

/**
 * This class fetches the data from the database and displays it on the console
 * @author Sunidhi Haldar
 * @created 2019-12-27
 * @version 1.8
 */

public class Basic {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shell", "root", "mysql");
//		String query = "insert into emp (id,name) values(?,?)";
////		PreparedStatement pst = conn.prepareStatement(query);
////		pst.setInt(1, 10);
////		pst.setString(2, "ramesh");
//		
//		int affectedRows = pst.executeUpdate();
//		
//		System.out.println("affected row/s : " + affectedRows);
		//String query = "select * from emp";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " , " + rs.getString(2));
		}

		rs.close();
		st.close();
		con.close();

	}

}