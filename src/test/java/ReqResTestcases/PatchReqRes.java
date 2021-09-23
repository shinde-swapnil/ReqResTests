package ReqResTestcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PatchReqRes {
	
	@Test
    public void putTest()
    {
        JSONObject request = new JSONObject();
        request.put("name", "Bill Gates");
        request.put("job", "President");

        System.out.println(request);
        System.out.println(request.toString());

        RequestSpecification https = RestAssured.given()
        		.header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when().body(request);
        
       Response responseObject = https.patch("https://reqres.in/api/users/2");
       
       Assert.assertEquals(200, responseObject.getStatusCode());
       
       responseObject.prettyPrint();
       
       String userName = responseObject.jsonPath().getString("name");
       String jobName  = responseObject.jsonPath().getString("job");
       
       System.out.println("New User : " + "Name: " + userName + "\t" + "Job: " + jobName);
//        Response response = given().get("https://reqres.in/api/users?page=2");
//        response.prettyPrint();
    }
	
	
	
	
}
