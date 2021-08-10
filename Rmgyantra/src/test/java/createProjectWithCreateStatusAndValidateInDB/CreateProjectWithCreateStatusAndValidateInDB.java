package createProjectWithCreateStatusAndValidateInDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjLib;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectWithCreateStatusAndValidateInDB {
	@Test
public void CreateProjectCreateStatusAndValidateInDB() throws SQLException {
	Random random =new Random();
	int  ran= random.nextInt(1000);
	baseURI = "http://localhost";
	port = 8084;
	//create project with created status using pojo class(ProjLib)
	ProjLib projlib = new ProjLib("KMH", "Created", 122, "TYSSPRJ1"+ran);
	Response resp=given().contentType(ContentType.JSON).body(projlib).when().post("/addProject");
	String res = resp.jsonPath().get("projectId");
	System.out.println(res);
	
	//Verify the project in the DB
	//Step1" Register the Database
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	//Get Connection in Database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
	//issue create Statement
	Statement statement = con.createStatement();
	//Execute query
	ResultSet result = statement.executeQuery("select * from project");
	String expdata = null;
	while(result.next()) {
		
		if(result.getString(1).equals(res)) {
			
			expdata=result.getString(1);
			System.out.println("Project is Successfully verified in the database");
			break;
		}
		
	}
	con.close();
	Assert.assertEquals(res, expdata);
}
}
