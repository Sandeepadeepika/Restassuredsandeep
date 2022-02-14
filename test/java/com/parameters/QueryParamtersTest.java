package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParamtersTest {
	
	@Test
	public void parameter() {
		
		given()
			.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.log().all();
	}

}