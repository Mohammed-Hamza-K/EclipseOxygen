package com.comcast.ParametersAndAuthentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class QueryParam {
	@Test
	public void QueryParameter() {
		baseURI = "https://reqres.in/";
		
     given().queryParam("page", 2).get("/api/users").then().assertThat().time(Matchers.lessThan(2800l),TimeUnit.MILLISECONDS).log().all();		
		
		
	}
}
//we dont have less than method in rest assured, we go for matchers