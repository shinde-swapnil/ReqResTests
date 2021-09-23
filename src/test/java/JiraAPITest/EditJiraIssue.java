package JiraAPITest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EditJiraIssue 
{

	@Test
	public void editIssue() 
	{
		String createPaylod = "{\r\n" + 
				"    \"fields\" : \r\n" + 
				"    {\r\n" + 
				"        \"summary\": \"Story created by Swapnil\",\r\n" + 
				"        \"description\": \"Changing Description from Eclipse\",\r\n" + 
				"        \"assignee\":{\"name\":\"Testing Shastra\"}\r\n" + 
				"    }\r\n" + 
				"}";
		
		
		
		Response response = null;
		  
		try
		{
		   response =RestAssured
				   .given()
				    .log().all()
	   				.header("Authorization","Basic dGVzdGluZ3NoYXN0cmFAeW9wbWFpbC5jb206NDlJeDNyRUdKSDhSbE5KdkpMQzIzMzc0")
	   				.header("Content-Type", "application/json")
	   				.body(createPaylod)
	   				.log().all()
	   				.put("https://testingraghvendra.atlassian.net/rest/api/2/issue/10013");
        
		   response.prettyPrint();
		  } catch (Exception e) {
		   System.err.println("Error: " + e.getMessage());
		  }
	}
}
