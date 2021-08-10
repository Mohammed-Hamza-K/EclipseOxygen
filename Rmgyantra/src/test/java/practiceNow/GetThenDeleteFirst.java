package practiceNow;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetThenDeleteFirst {
 /*   @Test
    public void getThenDeleteFirst() {
		baseURI = "http://localhost";
				port = 8084;
		
		Response response = when().get("/projects");
		System.out.println(response);
		
		//String firstprojectid = response.jsonPath().get("[3].projectId");
		//System.out.println(firstprojectid);
//	given().pathParam("abca", firstprojectid).when().delete("/projects/{abca}").then().assertThat().statusCode(204).log().all();

	}
	*/
	@Test
public void GetAll() {
	ValidatableResponse resp = when()
			.get("http://localhost:8084/projects")
		.then()
			.log().all()
			.and()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType(ContentType.JSON);
	resp.
	
}
}
