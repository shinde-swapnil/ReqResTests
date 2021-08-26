package TestCases;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class ParamTest {

    @BeforeTest
    public static RequestSpecification getRequestSpec()
    {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Content-Type", "application/json");
        builder.setBaseUri("https://reqres.in");
        builder.setBasePath("/api/users");
        RequestSpecification requestSpec = builder.build();
        return requestSpec;
    }
    @BeforeTest
    public static ResponseSpecification getResponseSpec()
    {
       ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectContentType("application/json");
        ResponseSpecification responseSpec = builder.build();
        return responseSpec;
    }


    @Test
    public void testPathParameterWay1()
    {
        RestAssured
                .given().pathParam("id", "4")
                                .when().spec(getRequestSpec()).get("/{id}")
                                .then().spec(getResponseSpec()).statusCode(200).log().all();
    }

    @Test
    public void testPathParameterWay2()
    {
        int userid=4;
        RestAssured
                .given().pathParam("id", "4")
                .when().spec(getRequestSpec()).get("/{id}",userid)
                .then().spec(getResponseSpec()).statusCode(200).log().all();
    }

    @Test
    public void testQueryParameterWay1()
    {
        RestAssured
                .given().queryParam("page","2")
                .when().spec(getRequestSpec()).get()
                .then().spec(getResponseSpec()).statusCode(200).log().all();
    }

    @Test
    public void testQueryParameterWay2()
    {
        RestAssured
                .given()
                .when().spec(getRequestSpec()).get("?page=2")
                .then()
                .spec(getResponseSpec())
                .statusCode(200)
                .log()
                .all();
    }



}

