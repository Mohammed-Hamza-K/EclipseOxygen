package com.TY.RmgYantra.ProjectTests;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TY.RmgYantra.GenericUtils.DataBaseUtility;
import com.TY.RmgYantra.GenericUtils.EndPoints;
import com.TY.RmgYantra.GenericUtils.JavaUtility;
import com.TY.RmgYantra.GenericUtils.RestAssuredUtility;
import com.TY.RmgYantra.PojoClass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectWithCreatedStatusAndValidate {
	
	@Test
	public void createProjectWithCreateStatusAndValidateTest() throws SQLException
	{
		JavaUtility jLib = new JavaUtility();
		RestAssuredUtility rLib = new RestAssuredUtility();
		DataBaseUtility dLib = new DataBaseUtility();
		
		
		//Create project with created status using POJO class
		ProjectLibrary projectLibrary = new ProjectLibrary("Jackson", "Casonoa"+jLib.randomNumber(), "Created", 25);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post(EndPoints.addProject);
		
		//Capture the project id
		String firstProjectId=rLib.jsonPathConsant(response, "projectId");
		
		String actProjName = rLib.jsonPathConsant(response, "projectName");
		System.out.println(firstProjectId);
		System.out.println(actProjName);
		
		//verify the project id in the data base
		
		String Query = "select * from project";
		String expData = dLib.executeQueryAndGetData(Query, 1, firstProjectId);
		
		String expPName = dLib.executeQueryAndGetData(Query, 4, actProjName);
        
        //validation
        Assert.assertEquals(firstProjectId, expData);
        
        Assert.assertEquals(actProjName, expPName);
        
		

	}
}
