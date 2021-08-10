package Practice;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
@Test
public void postcust() {
	
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy","MD Hamza");
	jobj.put("projectName", "SDET18New");
	jobj.put("status", );
	jobj.put("teamSize", 14);
	
	RequestSpecification rsp = RestAssured.given();
	rsp.contentType(ContentType.JSON);
	rsp.body(jobj);
	Response rspe = rsp.post("http://localhost:8084/addProject");
	rspe.prettyPrint();
	Assert.assertEquals(rspe.getStatusCode(), 201);
	
	
	
	
	
	
}
}
