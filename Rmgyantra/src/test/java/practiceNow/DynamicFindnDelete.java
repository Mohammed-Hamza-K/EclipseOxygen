package practiceNow;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicFindnDelete {
	@Test
	public void dynamicResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		File f2=new File(".\\file2.json");
		String respp = given().contentType(ContentType.JSON).body(f2).when().post("/addProject").jsonPath().get("projectId");
		System.out.println(respp);
		 //expected data initilization
		String expectedData = "SpiderMan";
		//initilizing the actual data variable with null
		String actualData = null;
		//getting the response from the server
		Response response = when().get("/projects");
		
		//verification of status code
		response.then().statusCode(200).log().all();
		//capturing all the data from the response body for a specific field
		List<String> list = response.jsonPath().get("createdBy");
		System.out.println(list);
		//verifying all the captured values with the expected data
		boolean flag = false;
		for(String data : list) {
			if(data.equals(expectedData)) {
				actualData = data;
				flag = true;
				break;
			}
		}
		System.out.println("Actual data is: "+actualData);
		System.out.println("Expected Data is: "+expectedData);
		//testNG assertion for actual and expected data using flag variable
		Assert.assertEquals(flag, true);
		//testNG assertion for actual and expected data
		Assert.assertEquals(expectedData, actualData);
		
	}

}
