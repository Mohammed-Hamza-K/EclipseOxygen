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

public class CreateThenUpdateProject {
	@Test
	public void RequestChain() {
		baseURI = "http://localhost";
		port = 8084;
		//Create a new project
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Mohammed_Test_POT");
		jobj.put("projectName", "Test_Assignment_PST");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 11);

		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("/addProject");
		
		//find and select the newly created project
	System.out.println(resp);	
	
	
	}

	}
		



