package com.RMGYantra;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByHashMap {
	@Test
	public void CreateCustomerUsingHashMap() {
 HashMap hh = new HashMap();	
 hh.put("createdBy", "MDH");
 hh.put("status", "created");
 hh.put("teamSize", 27);
 hh.put("projectName", "TestProject");
 
given().contentType(ContentType.JSON).body(hh).when().post("http://localhost:8084/addProject").then().log().all().assertThat().statusCode(201); 
 
		
	}

}
