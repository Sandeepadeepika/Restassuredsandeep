package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicOathTest {
	@Test
	public void  oathtest () {
		
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.log().all();
		
		
		
		
		
		
		
	}

}
