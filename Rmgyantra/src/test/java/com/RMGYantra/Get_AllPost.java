package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_AllPost {
@Test
public void testAllProject() {
	Response resp = RestAssured.get("http://localhost:8084/projects");
	String respbody = resp.prettyPrint();
	
	
	int actStatuscode = resp.getStatusCode();
	System.out.println(actStatuscode);
	Assert.assertEquals(actStatuscode, 200);
	
	String actContenttype = resp.getContentType();
	System.out.println(actContenttype);
	Assert.assertEquals(actContenttype, "application/jason");
}
}
