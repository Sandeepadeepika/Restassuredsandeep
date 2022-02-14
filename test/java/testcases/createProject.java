package testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createProject {
	@Test
	public void createProject()
	{

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","sandeepa");
		jobj.put("projectName", "Airtel");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 12);
		
		//Step 2: provide Request Specification
		Response resp = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject");
		
		resp.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		String proName=resp.jsonPath().get("projectName");
		
		JSONObject jobj1 = new JSONObject();
		jobj1.put("designation","SDET");
		jobj1.put("dob","25/05/1999");
		jobj1.put("email","nithesh@gmail.com");
		jobj1.put("empName","nithesh");
		jobj1.put("experience","15");
		jobj1.put("mobileNo","9888777657");
		jobj1.put("project",proName);
		jobj1.put("role","ROLE_ADMIN");
		jobj1.put("username","pavan");

		given()
		.body(jobj1)
		.contentType(ContentType.JSON)
		.when().post("http://localhost:8084/employees")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
