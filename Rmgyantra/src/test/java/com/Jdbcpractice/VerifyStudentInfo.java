package com.Jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class VerifyStudentInfo {
	@Test
	public void testVerifyStudent() throws Throwable {
		Connection conn=null;
		String expectedstu="sam";
		try {
		//load or register
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//connect to database
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	 
	 // get Sql query
	Statement stat = conn.createStatement();
	
	
	//execute query
	ResultSet result = stat.executeQuery("select * from students_info;");
	boolean flag = true;
	while(result.next()) {
		if(result.equals(expectedstu)) {
			System.out.println(expectedstu+"==>is available");
			 flag = true;
			break;
			
		}
	}
	Assert.assertEquals(flag, true);
		}
		catch(Exception e) {
		}
		finally {
			
		
	//close connection
	System.out.println("connection closed");
	conn.close();
		}
	}

}
