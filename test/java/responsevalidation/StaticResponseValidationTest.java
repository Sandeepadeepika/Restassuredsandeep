package responsevalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	@Test
	public void validation() {
		
		String expectedprojectName = "synchronoss319";
		Response response = when()
		   .get("http://localhost:8084/projects");
		String actualprojectname = response.jsonPath().get("[0].projectName");
		response.then()
		    .assertThat()
		    .contentType(ContentType.JSON).and().statusCode(200)
		    .log().all();
		Assert.assertEquals(expectedprojectName, actualprojectname);
		
	}

}