package practiceNow;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PostGetDeleteTest {
	@Test
	public void testPostGetDeleteProject() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "guru");
		jobj.put("projectName", "Rmg_Sdet18_12");
		jobj.put("status", "completed");
		jobj.put("teamSize", 30);
		
		String response = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject").getBody().jsonPath().get("projectId");
		
		System.out.println(response);
		
		 
		ValidatableResponse repo = when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().log().all();
		
		System.out.println(repo);
		
		if(repo.equals(response)) {
			given()
			.pathParam("got", response)
			.when()
			.delete("http://localhost:8084/projects/{got}")
			.then().assertThat().statusCode(204).log().all();
		}
}
}
