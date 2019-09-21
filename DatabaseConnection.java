package com.nsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	static String Driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://192.168.1.60:3306/mydb";
 static	String user="root";
 static	String pass="";
	public static Connection setConnection() throws SQLException, ClassNotFoundException{
		
		
		Class.forName(Driver);
	
		Connection con = DriverManager.getConnection(url,user,pass);
		
		if (con == null) {
			System.out.println("tere laude lag gye");
		}
		else{
			System.out.println("chal gya connection");
		}
		
		return con;
	}

}
