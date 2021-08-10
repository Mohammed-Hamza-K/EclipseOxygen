package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_OneProject {
	@Test
	public void testAllProject() {
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1404");
		String respbody = resp.asString();
		System.out.println(respbody);
		
		int actStatuscode = resp.getStatusCode();
		System.out.println(actStatuscode);
		Assert.assertEquals(actStatuscode, 204);
		
		String actContenttype = resp.getContentType();
		System.out.println(actContenttype);
		Assert.assertEquals(actContenttype, "application/json");
	}
}
