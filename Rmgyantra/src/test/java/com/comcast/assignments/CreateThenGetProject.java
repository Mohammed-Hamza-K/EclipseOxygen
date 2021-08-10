package com.comcast.assignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateThenGetProject {
	@Test
	public void RequestChain() {
		baseURI = "http://localhost";
		port = 8084;
		//Create a new project
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Mohammed_Test");
		jobj.put("projectName", "Test_Assignment");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 11);

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType(ContentType.JSON);
		//get all the projects;
		String expecteddata = "Test_Assignment";
		String actualdata = null;
		Response respo = when().get("/projects");
		respo.then().statusCode(200).log().all();
		List<String> list= respo.jsonPath().get("projectName");
		boolean flag = false;
		for(String data:list) {
			if (data.equals(expecteddata)) {
				actualdata = data;
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(expecteddata, actualdata);
	}
}
