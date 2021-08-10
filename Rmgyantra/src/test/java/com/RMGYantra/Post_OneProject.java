package RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_OneProject {
@Test
public void testCreateProject() {
	
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "gururaj");
	jobj.put("projectName", "RMG_SDET-18");
	jobj.put("status", "ONGOING");
	jobj.put("teamSize", 25);
	
	
	
	RequestSpecification resp = RestAssured.given();
	resp.contentType(ContentType.JSON);
	resp.body(jobj);
	Response respbody = resp.post("http://localhost:8084/addProject");
	Assert.assertEquals(respbody.getStatusCode(), 201);
}
}
