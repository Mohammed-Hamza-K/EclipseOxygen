package com.comcast.ParametersAndAuthentication;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class BearerAuth {
	@Test
	public void Beareruthentication() {
		baseURI = "https://api.github.com";
		
HashMap<Object, Object> map = new HashMap<Object, Object>();
map.put("name", "KMH");

		
		given().auth().oauth2("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").body(map).when().post("/user/repos").then().log().all();
	}
}

