package testcases;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	@Test
	public void getallresourse() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}

}
