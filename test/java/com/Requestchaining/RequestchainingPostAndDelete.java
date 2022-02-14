package com.Requestchaining;
import static  io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestchainingPostAndDelete {
	@Test
	public void chaining() {
		Random ran = new Random();
		int randomNum = ran.nextInt();
	      JSONObject jobj = new JSONObject();
				jobj.put("createdBy", "Madhusudhan");
				jobj.put("projectName","TY_PROJ_002"+randomNum);
				jobj.put("status","created");
				jobj.put("teamSize",201);
				
				given()
						.body(jobj)
						.contentType(ContentType.JSON)
						
				.when()
				 		.post("http://localhost:8084/addProject")
				 		.then()
				 		.assertThat().statusCode(201)
				 		.contentType(ContentType.JSON)
				 		.log().all();
				Response response = when()
						.get("http://localhost:8084/projects");
						String proId = response.jsonPath().get("[0].projectId");
						System.out.println(proId);
						given()
						.pathParam("projectId", proId)
						.when()
						.delete("http://localhost:8084/projects/{projectId}")
						.then()
						.assertThat().statusCode(204)
						.log().all();
				
				
		
	}

}

