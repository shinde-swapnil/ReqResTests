package JiraAPITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AddComment {
	@Test(description = "Adding comment with body")
	public void commentIssue() 
	{
		String createPaylod = "{\r\n" + 
				"    \"body\": \"This comment is sent using POST request and direct body.\"\r\n" + 
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
	   				.post("https://testingraghvendra.atlassian.net/rest/api/2/issue/10013/comment");
        
		   response.prettyPrint();
		  } catch (Exception e) {
		   System.err.println("Error: " + e.getMessage());
		  }
	}
		
		@Test(description = "Adding comment with edit issue methods")
		public void commentIssueUsingEditMethod() 
		{
			String createPaylod = "{\r\n" + 
					"   \"update\": {\r\n" + 
					"      \"comment\": [\r\n" + 
					"         {\r\n" + 
					"            \"add\": {\r\n" + 
					"               \"body\": \"This comment is using edit issue method. This is PUT request\"\r\n" + 
					"            }\r\n" + 
					"         }\r\n" + 
					"      ]\r\n" + 
					"   }\r\n" + 
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
