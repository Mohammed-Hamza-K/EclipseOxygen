package practiceNow;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostGetThenDelete {
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
		when().delete("http://localhost:8084/projects/"+response).then().log().all();
		
	}
}
