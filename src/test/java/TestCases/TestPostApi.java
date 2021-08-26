package TestCases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType; 
public class TestPostApi {
	
	@Test
	public void postApiTest()
	{
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").accept(ContentType.JSON).
		
		when().get("/booking").
		
		then();
		
		
		
		
		
	}

}
