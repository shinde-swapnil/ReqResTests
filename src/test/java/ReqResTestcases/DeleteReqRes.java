package ReqResTestcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteReqRes {
	@Test
	public void deleteDataMethod4()
    {
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api/users/2";
    	RequestSpecification https = RestAssured.given();
        Response response = https.request(Method.DELETE);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        response.prettyPrint();	

    }
}
