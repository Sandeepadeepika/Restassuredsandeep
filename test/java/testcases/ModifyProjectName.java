 package testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class ModifyProjectName {
	
	@Test
	public void update() {
		//create of random number
				Random ran =new Random();
				int randomnumber = ran.nextInt(500);
				
				JSONObject jobj=new JSONObject();//json simple dependency
				jobj.put("createdBy","Madhusudhan");
				jobj.put("createdOn", "11/02/2022");
				//jobj.put("projectId", "string");
				jobj.put("projectName", "TY_PROJ_002-1008076070");
				jobj.put("status", "Created");
				jobj.put("teamSize", 10);
				
				given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
				.when()
				.put("http://localhost:8084/projects/TY_PROJ_604")
				.then()
				.assertThat()
				.statusCode(200)
				.log().all();		
			}

}