package Sdet27.GenericUtility;
import io.restassured.response.Response;

/**
 *  This class contains generic methods specific to RestAssured
 * @author sandeep
 */
public class RestAssuredUtility {
	/**
	 * This method will return json data for specified json path
	 * @param response
	 * @param jsonPath
	 * @return String
	 */
	public String getJSONData(Response response, String jsonPath)
	{
		return response.jsonPath().get(jsonPath);

	}
}
