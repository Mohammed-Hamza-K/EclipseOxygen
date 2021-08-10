package com.Jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJdbcTest {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
	try {
	//load or register to database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		
		//connect to database
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		//get sql statement
		Statement stat = conn.createStatement();
		
		//execute query
		ResultSet result = stat.executeQuery("select * from students_info");
		
		//display
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
	}
	catch(Exception e) {
		
	}
	finally {
		//close database
		System.out.println("connection closed");
		conn.close();
	}
}
}