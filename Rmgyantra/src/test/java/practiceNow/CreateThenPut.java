package practiceNow;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateThenPut {
	public class GetThenPutFirst {
	    @Test
	    public void getThenPutFirst() {
			baseURI = "http://localhost";
					port = 8084;
			
			Response response = when().get("/projects");
			
			String firstprojectid = response.jsonPath().get("[0].projectId");
			System.out.println(firstprojectid);
			JSONObject jj = new JSONObject();
					jj.put("createdBy", "Put-Creater");
			jj.put("status", "completed");
			jj.put("teamSize", 100);
			jj.put("projectName", "PutChecker");
			
		given().pathParam("abca", firstprojectid).contentType(ContentType.JSON).body(jj).when().put("/projects/{abca}").then().assertThat().statusCode(200).log().all();
		}  
}
}