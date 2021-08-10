package com.comcast.assignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Assignments {
	@Test
	public void testCreateProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "gururaj");
		jobj.put("projectName", "RMG_SDET-18");
		jobj.put("status", "ONGOING");
		jobj.put("teamSize", 25);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType(ContentType.JSON);	
	}
}
