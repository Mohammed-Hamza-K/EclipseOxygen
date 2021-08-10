package com.comcast.ParametersAndAuthentication;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class PathParam {
@Test
public void PathParameter() {
	baseURI = "http://localhost";
	port = 8084;
			
	given().pathParam("ProjID", "TY_PROJ_001").when().delete("/projects/{ProjID}").then().assertThat().statusCode(204).log().all();
}
}
