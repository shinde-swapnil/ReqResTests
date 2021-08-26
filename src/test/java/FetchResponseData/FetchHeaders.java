package FetchResponseData;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FetchHeaders {


    @Test(description = "check header present or not")
    public void testHeaderAvailable() {
        Response response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .extract()
                .response();
        //How to assert if a header is present in the response

        boolean isPresent = response.getHeaders().hasHeaderWithName("Content-Type");
        System.out.println(isPresent);
        Assert.assertEquals(true, isPresent);

    }

    @Test(description = "get single header value")
    public void printSingleHeader() {
        Response response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .extract()
                .response();

        System.out.println("********************************* ");
        System.out.println("Single header demo : ");
        System.out.println("Value of Header Content-Type : " + response.getHeader("Content-Type"));


        // System.out.println("Value of Header Server : " + response.getHeader("Server"));
    }

    @Test
    public void testSingleHeader() {
        Response response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .extract()
                .response();

        // Suppose Content-Type is a multivalue header
        List<Header> allValue = response.getHeaders().getList("Content-Type");
        for(Header header : allValue)
        {
            System.out.print(header.getName() +" : ");
            System.out.println(header.getValue());
        }

        List<String> allValue1 = response.getHeaders().getValues("Content-Type");
        for(String value : allValue1)
        {
            System.out.println(value);
        }



    }

    @Test
    public void testMultiHeader() {
        Response response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .extract()
                .response();

        String v1 = response.getHeaders().get("Content-Type").getValue();
        Assert.assertEquals(v1, "application/json; charset=utf-8");

        String v2 = response.getHeaders().getValue("Content-Type");
        Assert.assertEquals(v2, "application/json; charset=utf-8");

    }


    @Test
    public void getALlHeadersFromResponse() {
        Response response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .extract()
                .response();

        System.out.println("All Headers of response are :- ");
        Headers allHeaders = response.getHeaders();
        for (Header header : allHeaders) {
            System.out.print(header.getName() + " : ");
            System.out.println(header.getValue());
        }


    }

}
