package createProjectWithCreateStatusAndValidateInDB;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;

public class GetVerifyDeleteVerifyTest {
	@Test
  public void getthenVerifyDeleteVerifyTest() throws SQLException {
	  
	  baseURI = "http://localhost";
			  port = 8084;
	//1.Get All projects;
			  Response respo =when().get("/projects");
			  respo.then().log().all();
      //2. Capture all the projectIds
			 String expData = respo.jsonPath().get("[0].projectId");
		
			//  String expData = when().get("/project").jsonPath().get("[0].projectId");
			 //3.Register Driver using drivermanager
			 Driver driver = new Driver();
			 DriverManager.registerDriver(driver);
			 //4 Get Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			 //5. Create Statement using Driver Manager
			Statement statement = conn.createStatement();
			//6. Execute Query
		ResultSet result = statement.executeQuery("select * from project");
		String expProjId= null;
		while(result.next()) {
			if (result.getString(1).equals(expData)) {
				expProjId=result.getString(1);
				System.out.println("Project is found");
				break;
			}
			Assert.assertEquals(expData, expProjId);
		}
		
			 //7. Delete the project using ProjectID
		given().pathParam("ProjId", expData).when().delete("/projects/{ProjId}").then().log().all();
		//8. verify that it is deleted in the database or not
		boolean flag=false;
		while(result.next()) {
			expProjId=result.getString(1);
			if (!(expData.equals(expProjId))) {
flag=true;
System.out.println("Project is not there in the Database ");
break;				
			}
		Assert.assertEquals(flag, true);	
		conn.close();
		}
		
		
		
	  
  }
}
