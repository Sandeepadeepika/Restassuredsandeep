package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class updateProject {
	@Test
	public void updateProject(){
		//step 1:create test data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Sandeep");
		jobj.put("projectName","APTY");
		jobj.put("status","Completed");
		jobj.put("teamSize",12);
		
		//step 2
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//step:3
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_001");
		
		//step 4: verify
		ValidatableResponse validate=resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
	}

}
