package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.path.json.JsonPath;


public class AssertTest {

	@Test
	public void assertTest() {
		
		String oldbody="{\r\n" + 
				"    \"name\" : \"abcd\",\r\n" + 
				"    \"isbn\" : \"%s\",\r\n" + 
				"    \"aisle\": \"%s\",\r\n" + 
				"    \"author\":\"demo\"\r\n" + 
				"}";
		
		String isbn = "tiger";
		
		String aisle = "khanna";
		
		String newbody= String.format(oldbody, isbn, aisle);
		
		Response postResponse = given().header("Cotent-Type", "application/json").body(newbody).
				  when().post("http://216.10.245.166/Library/Addbook.php");
		
		String getResponse = given().header("Cotent-Type", "application/json").body(newbody).log().all().
						  when().post("http://216.10.245.166/Library/Addbook.php").then().log().all().extract().asString();
		
		
		//String message1 = postResponse.path("Msg", arguments)
		//String id1 = jp.getString("ID");
		
		
		JsonPath jp = new JsonPath(getResponse);
		
		String message = jp.getString("Msg");
		String id = jp.getString("ID");
		
		Assert.assertEquals(id, (isbn+aisle));
				

		}

}
