package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.bridgelabz.util.Utility;

/**
 * This program is executes an insert into table query
 * @author Sunidhi Haldar
 * @created 2019-12-28
 * @version 1.8
 */

public class Sample {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shell";
		String uname = "root";
		String pwd = "mysql";
		Connection con = DriverManager.getConnection(url, uname, pwd);
		String query = "insert into emp values(?, ?)";
		PreparedStatement pst = con.prepareStatement(query);
		while(true) {
			System.out.println("Enter emp id");
			int id = Utility.intInput();
			System.out.println("Enter emp name");
			String name = Utility.SCANNER.next();
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.executeUpdate();
			System.out.println("Record updated successfully");
			System.out.println("Do you want to insert one more record?");
		    String choice = Utility.SCANNER.next();
		    if(choice.equalsIgnoreCase("No"))
		    	break;
		}
	}
	
}
