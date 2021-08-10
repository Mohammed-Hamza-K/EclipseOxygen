package Practice_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetBdd {
@Test
public void testGetProject() {
	when()
	.get("http://localhost:8084/projects")
	.then()
	.log().all()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON);
}
}
