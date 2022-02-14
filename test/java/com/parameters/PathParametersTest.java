package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParametersTest {
	@Test
	public void param(){
		
		String pobj="TY_PROJ_004";
		given()
			.pathParam("ProjectId", pobj)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
		
	}

}