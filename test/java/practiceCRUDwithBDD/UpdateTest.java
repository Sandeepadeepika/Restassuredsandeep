package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateTest {
	@Test

	public void update() {
		Random ran=new Random();
		int randomNumber=ran.nextInt(500);
		 
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Madhusudhan");
		jobj.put("projectName","synchronoss"+randomNumber);
		jobj.put("status","Created");
		jobj.put("teamSize",3500);
		
		given()
		     .body(jobj)
		     .contentType(ContentType.JSON)
		.when()
		     .put("http://localhost:8084/projects/TY_PROJ_002")
		 .then()    
		      .assertThat().contentType(ContentType.JSON)
		      .statusCode(200)
		      .log().all();
	}

}
