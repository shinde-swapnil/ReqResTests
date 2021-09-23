package JiraAPITest;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class AddAttachmentJira {
	
	@Test
	public void addAttachmentToIssue() 
	{
		Response response = null;
		  try{
		   response =RestAssured
						.given()
						.header("Authorization","Basic dGVzdGluZ3NoYXN0cmFAeW9wbWFpbC5jb206NDlJeDNyRUdKSDhSbE5KdkpMQzIzMzc0")
				        .header("X-Atlassian-Token", "no-check")
				        .when()
				        .multiPart("file", new File("./src/test/java/JiraAPITest/HTTP Status Codes.png"))
				        .log().all()
				        .post("https://testingraghvendra.atlassian.net/rest/api/3/issue/10013/attachments");
        
		   response.prettyPrint();
		  } catch (Exception e) {
		   System.err.println("Error: " + e.getMessage());
		  }
		
	}

}
