package doneProgs;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostnDelete {

	@Test
	public void postthendelete() {
		
		File f = new File(".\\file.json");
String response = given().contentType(ContentType.JSON).body(f).when().post("http://localhost:8084/addProject").getBody().jsonPath().get("projectId");
		System.out.println(response);
	//	when().delete("http://localhost:8084/"+response).then().log().all();
		
	}
}
