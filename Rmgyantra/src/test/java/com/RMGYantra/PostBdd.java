package Practice_BDD;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostBdd {
@Test
public void testCreateProject() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "gururaj");
	jobj.put("projectName", "RMG_SDET-18");
	jobj.put("status", "ONGOING");
	jobj.put("teamSize", 25);
	re
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.post("http://localhost:8084/addproject")
	.then()
	.log().all()
	.and()
															.assertThat().
}
