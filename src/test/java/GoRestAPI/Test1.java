package GoRestAPI;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import TestUtils.payload;
import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test1 {
	
	@Test
	public void matchTest()
	{		
		// create user
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification reqspec = RestAssured.given();
		String postBody = "{ \"name\": \"DVM\",\r\n" + 
				"        \"email\": \"12345vaidehi_shah@raynor.com\",\r\n" + 
				"        \"gender\": \"male\",\r\n" + 
				"        \"status\": \"active\"\r\n" + 
				"    }";
	Response res = reqspec
			.contentType("application/json")
			.header("Authorization", "Bearer 7aa6e141ed07adfc6781b68debfd1b7ce5e3bfeb72481b1c4e4c0bacb9f052d8\r\n" + 
				"")
			.body(postBody).post("/public/v1/users");
		
		res.prettyPrint();
		
		Assert.assertEquals(res.path("data.name"), Matchers.equalTo("DVM"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		JSONObject obj = new JSONObject();
//		obj.put("name", "Tester");
//		obj.put("email", "vaidehi_shah@raynor.com");
//		obj.put("gender", "male");
//		obj.put("status", "active");
//				
//		Response res = reqspec.header("Authorization", "Bearer 7aa6e141ed07adfc6781b68debfd1b7ce5e3bfeb72481b1c4e4c0bacb9f052d8\r\n" + 
//				"")
//				.body(obj.toJSONString()).post("/public/v1/users");
//		
//		res.prettyPrint();
		
		
	}

}
