package com.comcast.ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2 {
	@Test
	public void OauthParameter() {
Response resp=given().formParam("client_id", "SDET181").formParam("client_secret", "6f45aaa9df19357068dc8138cc09bdf0").
formParam("grant_type", "client_credentials").formParam("redirect_uri", "http://spidermansday.com").when().post("http://coop.apps.symfonycasts.com/token");
System.out.println(resp.asPrettyString());
		String mytoken = resp.jsonPath().get("access_token");
		System.out.println(mytoken);
		given().auth().oauth2(mytoken).pathParam("USER_ID", "2123").when().
		post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect").then().log().all();
	}
}
//we dont have less than method in rest assured, we go for matchers