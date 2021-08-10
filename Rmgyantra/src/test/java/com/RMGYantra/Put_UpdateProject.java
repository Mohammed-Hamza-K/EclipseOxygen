package RestAssured;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_UpdateProject {
@Test
public void testUpdateProject() {
	JSONObject jobject=new JSONObject();
	jobject.put("createdBy", "guru");
	jobject.put("projectName", "Rmg_Sdet18_1");
	jobject.put("status", "completed");
	jobject.put("teamSize", 30);
	
	RequestSpecification resp = RestAssured.given();
	resp.contentType(ContentType.JSON);
	resp.body(jobject);
	Response respbody = resp.put("http://localhost:8084/projects/TY_PROJ_1403");
	respbody.prettyPrint();
	Assert.assertEquals(respbody.getStatusCode(), 200);
}}
