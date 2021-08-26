package TestCases;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class SyntaxTest {

	@Test
	public void test1() {
		given().header("Cotent-Type", "application/json")
				.header("Authentication", "Bearer 951b46c8d5dfe88a03b26a5590b37d879f5346a4bd3d0b22e704abc228a1f2f1")
				.body("{\r\n" + "        \"name\": \"mytest\",\r\n" + "        \"salary\": \"234123\",\r\n"
						+ "        \"age\": \"45\",\r\n" + "        \"id\": 7490\r\n" + "    }")
		.when().
					post("http://dummy.restapiexample.com/api/v1/create").
		then().
					statusCode(200).
					log().all();

	}
	
	@Test
	public void test2()
	{
		//url=http://dummy.restapiexample.com/api/v1/employee/1
		given().header("Cotent-Type", "application/json").
		when().get("http://dummy.restapiexample.com/api/v1/employee/7489").
		then().statusCode(200).log().all();
		
	}

}
