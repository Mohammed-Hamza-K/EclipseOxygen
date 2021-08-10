package com.comcast.ParametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BasicAuthAuthentication {
	@Test
	public void RequestChain() {
		baseURI = "http://localhost";
		port = 8084;

		//get all the projects;
		Response respo = when().get("/projects");
		//capture any project ID or Name or any unique parameter.
		String firstprojID = respo.jsonPath().get("[0].projectId");
		System.out.println(firstprojID);
		//delete that project
		given().pathParam("ProjID", firstprojID).when().delete("/projects/{ProjID}").then().assertThat().statusCode(204).log().all();
	
	}
}

//we dont have less than method in rest assured, we go for matchers