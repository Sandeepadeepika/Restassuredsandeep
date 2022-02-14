package com.RMGYantraTests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import Sdet27.GenericUtility.BaseApiClass;
import Sdet27.GenericUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateResourcesandVerifyIndataBase extends BaseApiClass{
	@Test
	public void createresourceAndVerifyDb() throws SQLException {
		//step :1 create test data
		PojoClass pLib=new PojoClass("sandeep", "nykee"+jlib.getRandomNum(), "completed", 42);
		//step :2 execute post request
		
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post(EndPoints.CreateProject);
		
		//step :3 capture the project id from response
		String expData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//step 4:verify in DB
		String query="select * from project;";
		String actData=dLib.executequeryAndgetData(query, 1, expData);
	    Reporter.log(actData,true);
	    
	    //step 5:validate
	    Assert.assertEquals(actData, expData);
	    Reporter.log("data verification succefully",true);
	    
		
	}
}

