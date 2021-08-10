package Practice;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {
@Test
public void GetReq() {
	Response respo = RestAssured.get("http://localhost:8084/projects");
	String respb = respo.asString();
	System.out.println(respb);
	String presp = respo.prettyPrint();
	System.out.println(presp);
	int acstcode = respo.getStatusCode();
	System.out.println(acstcode);
	Assert.assertEquals(acstcode, 200);
	String acct = respo.getContentType();
	System.out.println(acct);
	Assert.assertEquals(acct, "application/json");
	
	
}
}
