package JiraAPITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateJiraIssue {
	@Test
	public void createIssue() {
		
		RestAssured.baseURI = "https://testingraghvendra.atlassian.net/";
		RestAssured.basePath = "rest/api/2/issue";
		
		String createPaylod = "{\r\n" + 
				"  \"fields\": {\r\n" + 
				"    \"project\": {\r\n" + 
				"      \"key\": \"HOM\"\r\n" + 
				"    },\r\n" + 
				"    \"summary\": \"Issue REST Summary\",\r\n" + 
				"    \"description\": \"Creating an issue\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"      \"name\": \"Story\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		
		Response response = null;
		  try{
		   response = RestAssured.given()
				   				.log().all()
				   				.header("Authorization","Basic dGVzdGluZ3NoYXN0cmFAeW9wbWFpbC5jb206NDlJeDNyRUdKSDhSbE5KdkpMQzIzMzc0")
				   				.header("Content-Type", "application/json")
				   				.body(createPaylod)
				   				.log().all()
				   				.post("https://testingraghvendra.atlassian.net/rest/api/2/issue");
		   
		   response.prettyPrint();
		  } catch (Exception e) {
		   System.err.println("Error: " + e.getMessage());
		  }

	}

}
	