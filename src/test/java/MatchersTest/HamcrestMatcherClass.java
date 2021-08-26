package MatchersTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class HamcrestMatcherClass {

    @Test
    public void hamcrest1()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");

        String jsonResponse = response.asString();

        JsonPath jp = response.jsonPath();

        List<Object> countryNames = jp.getList("name");
        System.out.println(countryNames);
    }


   // Number related assertions


   // String related assertions


  //  Collection related assertion


  //  not assertion



}
