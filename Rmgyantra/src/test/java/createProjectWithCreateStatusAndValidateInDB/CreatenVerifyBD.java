package createProjectWithCreateStatusAndValidateInDB;

import com.comcast.POJOClass.ProjLib;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreatenVerifyBD {

	public void createnVerifyDB() {
		
		ProjLib prjl = new ProjLib("MadMan", "Completed", 25, "ProjName");
Response response = given().contentType(ContentType.JSON).body(prjl).when().post("http://localhost:8084/addProject");
		String res = response.jsonPath().get("projectId");
		System.out.println(res);
		//create project with created status using pojo class(ProjLib)
		ProjLib projlib = new ProjLib("KMH", "Created", 122, "TYSSPRJ1"+ran);
		Response resp=given().contentType(ContentType.JSON).body(projlib).when().post("/addProject");
		String res = resp.jsonPath().get("projectId");
		System.out.println(res);
	}
}
