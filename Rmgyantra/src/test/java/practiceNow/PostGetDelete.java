package practiceNow;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostGetDelete {
@Test
public void postGetThenDelete(){
	baseURI = "http://localhost";
	port = 8084;
	
	/*HashMap<Object, Object> map= new HashMap<Object, Object>();
			map.put("createdBy", "HashMapCreater");
	map.put("status", "onGoing");
	map.put("teamSize", 999);
	map.put("projectName", "HashMapProject");  */
JSONObject jj= new JSONObject();
jj.put("createdBy", "Put-Creater");
jj.put("status", "completed");
jj.put("teamSize", 100);
jj.put("projectName", "PutChecker");
	String respo =given().contentType(ContentType.JSON).body(jj).when().post("/addProjects").jsonPath().get("projectId");

	given().pathParam("pname", respo).when().delete("/projects/{respo}").then().assertThat().statusCode(204).log().all();
	
	
}
}
