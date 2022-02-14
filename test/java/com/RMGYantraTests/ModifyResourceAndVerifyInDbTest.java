package com.RMGYantraTests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Sdet27.GenericUtility.*;
import Sdet27.GenericUtility.*;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ModifyResourceAndVerifyInDbTest extends BaseAPIClass {

	@Test
	public void modifyResourceAndVerifyInDbTest() throws Throwable
	{
		//Step1: Create test data
		//String projectId= "TY_PROJ_206";
		Pojo pObj = new Pojo("Marbles", "Avengers", "Completed", 200);
		Response resp = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				//Step2: action-Update
				.when()
				.put(IEndPoint.updateProject);

		//Step3: get projectId From response body
		String expData = rLib.getJSONData(resp, "createdBy");
		Reporter.log(expData+" data found in response body", true);

		//Step4: varify in db
		String query= "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 2, expData);
		Reporter.log(actData +" data created by in db", true);
ss
		Assert.assertEquals(expData, actData);
		Reporter.log("Verification successful",true);

	}
}

