package com.comcast.ComplexData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjLib;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleDataUsingDataProvider {
	@Test(dataProvider="getData")

public void CreateMultipleDataDataProvider(String createdBy , int teamSize, String projectName) {  

ProjLib prj = new ProjLib(createdBy, "Completed", teamSize, projectName);
baseURI ="http://localhost:";
port = 8084;
given()
.contentType(ContentType.JSON)
.body(prj)
.when()
.post("/addProject")
.then()
.log().all()
.and()
.assertThat().contentType(ContentType.JSON);

}
@DataProvider
public Object[][] getData(){
Object[][] objj= new Object[3][3];
objj[0][0] = "MD1H";
objj[0][1] = 20;
objj[0][2] = "DellProject1";

objj[0][0] = "MD23H11";
objj[0][1] = 21;
objj[0][2] = "DellProject2";

objj[0][0] = "MD3H2";
objj[0][1] = 22;
objj[0][2] = "DellProject3";
return objj;
}
}
