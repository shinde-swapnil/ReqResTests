package ReqResTestcases;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostReqRes {

    @Test
    public void postTest()
    {
        JSONObject request = new JSONObject();
        request.put("name", "narayan murthy");
        request.put("job", "CEO infosys");

        System.out.println(request);
        System.out.println(request.toString());

        RequestSpecification https = RestAssured.given()
        		.header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when().body(request);
        
       Response responseObject = https.post("https://reqres.in/api/users");
       
       Assert.assertEquals(201, responseObject.getStatusCode());
       
       responseObject.prettyPrint();
       
       String userID = responseObject.jsonPath().getString("id");
       
       System.out.println("New User ID is created as: " + userID);
//        Response response = given().get("https://reqres.in/api/users?page=2");
//        response.prettyPrint();
    }
}
