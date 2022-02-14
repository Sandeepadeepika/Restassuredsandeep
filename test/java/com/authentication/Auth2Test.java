package com.authentication;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Auth2Test {
	@Test
	public void auths() {
	Response response = given()
		.formParams("Client ID","SDET-27SANDEEP")
		.formParams("Client Secret","4edf6b6383f1cf178441998f2daab90a")
		.formParams("grant_type","client_credentials")
		.formParams("redirect_uri","https://example.com")
	.when()
	     .post("http://coop.apps.symfonycasts.com/token");
		String token=response.jsonPath().get("access_token");
		
		given()
		     .auth().oauth2(token)
		     .pathParam("USER_ID","2782")
		.when()
		     .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		     .then()
	
				.log().all();
				
			}
	}

