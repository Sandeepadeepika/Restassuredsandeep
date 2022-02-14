package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;

public class CreateResource {
	@Test
	public void create() {
		//creatn of random numbers
		Random ran=new Random();
		int randomNumber=ran.nextInt(500);
		 
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Sandeep123");
		jobj.put("projectName","APTYss"+randomNumber);
		jobj.put("status","Created");
		jobj.put("teamSize",1234);
		
		given()
		     .body(jobj)
		     .contentType(ContentType.JSON)
		.when()
		     .post("http://localhost:8084/addProject")
		.then()
		     .assertThat().statusCode(201)
		     .contentType(ContentType.JSON)
		     .log().all();
		
	}

}
