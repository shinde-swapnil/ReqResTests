package TestCases;

import org.testng.annotations.Test;
import io.restassured.matcher.*;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class TestHamcrest {
	
	@Test
	public void testHamcrest()
	{
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.given().
										when().
										get("/api/users?page=2").
									then().
										statusCode(200).
										body("data[1].id", equalTo(8)).log().all();
	}

}
