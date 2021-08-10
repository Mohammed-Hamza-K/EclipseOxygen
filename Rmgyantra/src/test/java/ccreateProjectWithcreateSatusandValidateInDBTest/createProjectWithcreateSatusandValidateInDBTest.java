

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.comcast.PoojoClass.ProjectLibrary;
	import com.mysql.cj.jdbc.Driver;

	import io.restassured.http.ContentType;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.*;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Random;

	public class createProjectWithcreateSatusandValidateInDBTest {
		@Test
		public void createProjectWithcreateSatusandValidateInDBTest() throws Throwable
		{
			Random random = new Random();
			int ran = random.nextInt(1000);
			baseURI="http://localhost";
			port=8084;
			
			//create project with created status using POJO class
			ProjectLibrary projectLibrary = new ProjectLibrary("anand", "TestYantraP"+ran,"completed", 56);
			Response response = given().contentType(ContentType.JSON).body(projectLibrary).when()
			.post("/addProject");
			//.then().log().all();
			
			String res = response.jsonPath().get("projectId");
			System.out.println(res);
		
			//verify the project id in the database
			//step1: register db
			Driver driver  = new Driver();
			DriverManager.registerDriver(driver);
			
			//get connection with DB
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
			//issue create statement
			Statement statement =conn.createStatement();
			
			//execute Query
			ResultSet result = statement.executeQuery("select * from project");
			String expData=null;
			while(result.next())
			{
				if(result.getString(1).equals(res))
				{
					expData=result.getString(1);
					System.out.println("project id is successfully verified in database");
					break;
				}
			}
				//close connection
				conn.close();
				Assert.assertEquals(res, expData);
			}
		}

