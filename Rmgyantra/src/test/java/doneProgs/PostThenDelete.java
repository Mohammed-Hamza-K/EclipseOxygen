package doneProgs;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;

public class PostThenDelete {
	@Test
	public void testPostGetDeleteProject() {
		/*JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "guru");
		jobj.put("projectName", "Rmg_Sdet18_12");
		jobj.put("status", "completed");
		jobj.put("teamSize", 30);
		*/
	//	File f = new File("./file.json");
	HashMap<Object, Object> mapp= new HashMap<Object, Object>();
	mapp.put("createdBy", "HasherMap");
	mapp.put("projectName", "HasherProject");
	mapp.put("teamSize", 999);
	mapp.put("status", "onGoing");
		String response = given()
		.contentType(ContentType.JSON)
		.body(mapp)
		.when()
		.post("http://localhost:8084/addProject").getBody().jsonPath().get("projectId");
		
		System.out.println(response);
		when().delete("http://localhost:8084/projects/"+response).then().log().all();
		
	}
}
