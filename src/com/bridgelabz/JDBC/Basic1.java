package com.bridgelabz.JDBC;

import java.sql.*;

import com.bridgelabz.util.Utility;

/**
 * This class takes sql query as user input and displays the result accordingly
 * @author Sunidhi Haldar
 * @created 2019-12-27
 * @version 1.8
 */

public class Basic1 {

	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shell", "root", "mysql");
		Statement stmt = con.createStatement();
		System.out.println("Enter sql querys");
		String query = Utility.SCANNER.nextLine();
		boolean b = stmt.execute(query);
		if(b == true) {
			ResultSet rs = stmt.getResultSet();
		    while(rs.next())
		    	System.out.println(rs.getInt(1));
		}
		else {
			int rowCount = stmt.getUpdateCount();
			System.out.println(rowCount);
		}
		con.close();
		
	}
	
}
