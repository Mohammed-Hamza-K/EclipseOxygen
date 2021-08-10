package Practice_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteBdd {
@Test
public void testDeleteProject() {
	when()
	.delete("http://localhost:8084/projects/TY_PROJ_1216")
	.then()
	.log().all()
	.assertThat().statusCode(204);
}
}
