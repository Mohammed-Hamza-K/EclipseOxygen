package practiceNow;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatenDeleteUser {

	@Test
	public void testCreateAndDelete() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("designation", "SDET");
		jobj.put("dob", "25/05/1999");
		jobj.put("email", "paven@gmail.com");
		jobj.put("empName", "nithesh");
		jobj.put("experience", 15);
		jobj.put("mobileNo", "9888777657");
		jobj.put("project", "pavan");
		jobj.put("role", "ROLE_ADMIN");
		jobj.put("username", "pavan");
		
		
		String response = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/employees").getBody().jsonPath().get("userId");
		
		System.err.println(response);
		given()
		.pathParam("resp", "response")
		.when()
	.get("http://localhost:8084/employees/{resp}")
	.then().log().all();	
		
		
	}
}
