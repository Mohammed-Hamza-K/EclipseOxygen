package com.StudentAppp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class LoginPage extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String browserUN = req.getParameter("regno");

Connection conn=null;

try {
	//step 1 load / register to db
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//connect db
 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
 
 
 
 
} catch (SQLException e) {
	
}
}
}
