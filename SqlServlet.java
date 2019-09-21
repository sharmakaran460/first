package com.nsys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import db class
import com.nsys.DatabaseConnection;

@WebServlet("/Registration")
public class SqlServlet  extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	String u= req.getParameter("user");
	String p=req.getParameter("pass");
	
	System.out.println("before try catch");
	try{
		System.out.print(" dekhte hai  ");
		Connection connection = DatabaseConnection.setConnection();
		if (connection ==null) {
			System.out.println("kuch nai ho sakta tera");
		}
		else
		{
			System.out.print(" chal gya ");
		}
		// writing sql query for inserting data base 
		PreparedStatement ps = connection.prepareStatement("Insert into registration values(?,?)");
		ps.setString(1, u);
		ps.setString(2, p);
		ps.executeUpdate();
		
	ps.close();
	connection.close();
		
	System.out.println("<html><body><b>DAta inserted"+"</b></body></html>");
	
	}catch(Exception e){
		System.out.print("bahu laude lag gye");
		e.printStackTrace();
	}
}

}
