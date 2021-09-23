package herocuApp;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBooking {
	
	@Test
	public void deleteTest()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification reqSpec = RestAssured.given();
		
		
		// create auth token
		JSONObject obj = new JSONObject();
		obj.put("username", "admin");
		obj.put("password" ,"password123");
		
		Response respToken = reqSpec
									.header("Content-Type", "application/json")
									.body(obj.toJSONString())
									.post("/auth");		
		String authToken = respToken.path("token");
		System.out.println(authToken);
		
		// get list of bookings 
		
		Response getResponse = reqSpec.get("");
		
		
		//delete booking
		 
		
		// check its presence
	}

}
