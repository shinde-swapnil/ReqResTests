package ReqResTestcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;


public class GetReqRes {
    @Test(description = "Validate GET request")
    public void getDataMethod1()
    {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        response.contentType();
        response.prettyPrint();
    }

    @Test(description = "Validate GET request")
    public void getDataMethod2()
    {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));

    }
    
    @Test(description = "Using ReqSpec - GET request")
    public void getDataMethod3()
    {
        RestAssured.baseURI="https://reqres.in/api/users?page=2";
    	RequestSpecification https = RestAssured.given();
        Response response = https.request(Method.GET);
        response.prettyPrint();	

    }
    
    @Test(description = "Using Query Param  - GET request")
    public void getDataMethod4()
    {
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api/users";
    	RequestSpecification https = RestAssured.given().queryParam("page","2");
        Response response = https.request(Method.GET);
        response.prettyPrint();	

    }
    
    
    

}






