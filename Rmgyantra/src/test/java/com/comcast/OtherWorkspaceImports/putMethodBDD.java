package com.SDET18;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class putMethodBDD {
	@Test
public void putMethodPractice() {
	JSONObject jobjj=new JSONObject();
	jobjj.put("createdBy", "Mohammed");
	
}
}
