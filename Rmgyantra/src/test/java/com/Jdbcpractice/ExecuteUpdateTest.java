package com.Jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {
public static void main(String[] args) throws SQLException {
	Connection connection=null;
	try {
		//load or register
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//connect database
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	
	//create a statment
	Statement statement = connection.createStatement();
	
	//execute queery
	int result = statement.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('3', 'jam','gowda', 'hassan')");
	
	if(result==1) {
		System.out.println("row is added");
	}
	else {
		System.out.println("row is added");
	}
	}catch(Exception e) {}
	finally {
		//close connection
		connection.close();	
	}
}
}
