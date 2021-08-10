package Practice_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutBdd {
@Test
public void testUpdateProject() {
	
	JSONObject jobject=new JSONObject();
	jobject.put("createdBy", "guru");
	jobject.put("projectName", "Rmg_Sdet18_1");
	jobject.put("status", "completed");
	jobject.put("teamSize", 30);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobject)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_1217")
	.then()
	.log().all().and()
	.assertThat().statusCode(200);
}
}
