package com.comcast.ComplexData;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateStaticRespTest {
	@Test
public void  staticresp(){
	String expdata = "PojoProject";
Response respo = when().get("http://localhost:8084/projects");
respo.then().statusCode(200).log().all();
String actdata = respo.jsonPath().get("[1].projectName");
Assert.assertEquals(actdata, expdata);
}
}
//JSON Path Index start from zero
