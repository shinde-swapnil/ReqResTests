package FetchResponseData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FetchResponseClass {

    @Test(description = "get cookies")
    public void getResponseData()
    {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        //response.prettyPrint();


        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int statusCode = response.getStatusCode();
        System.out.println("status code="+statusCode);

        // Get the status line from the Response and store it in a variable called statusLine
        String statusLine = response.getStatusLine();
        System.out.println("Status line="+statusLine);

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");



        //cookie

        Map<String,String> cookieName = response.getCookies();
        for (Map.Entry<String,String> entry : cookieName.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

    }



}
