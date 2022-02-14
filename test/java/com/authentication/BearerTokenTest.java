package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerTokenTest {
	@Test
	public void bearertoken () {
		
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
	
	.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}