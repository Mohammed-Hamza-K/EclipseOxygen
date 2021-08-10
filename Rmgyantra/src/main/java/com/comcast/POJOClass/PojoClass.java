package com.comcast.POJOClass;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PojoClass {

	@Test
	public void createProject() {
		ProjLib prj = new ProjLib("Mohammed_Hamza_K", "onGoing", 100, "PojoProject");
		given()
		.contentType(ContentType.JSON)
		.body(prj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType(ContentType.JSON);
	}
}
