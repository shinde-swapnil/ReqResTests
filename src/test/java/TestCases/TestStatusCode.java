package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class TestStatusCode
{	
		
	@Test
	public void testStatusCode2()
	{
		RestAssured.baseURI="https://postman-echo.com";
		Response res=RestAssured.given().when().get("/GET");
		assertEquals(200, res.getStatusCode());
	}
}