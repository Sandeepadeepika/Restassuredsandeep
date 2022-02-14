package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteResourceTest {
	@Test
	public void delete() {
		when()
             .delete("http://localhost:8084/projects/TY_PROJ_001")
        .then()
             .assertThat().statusCode(204)
             .log().all();
            
		
	}

}
