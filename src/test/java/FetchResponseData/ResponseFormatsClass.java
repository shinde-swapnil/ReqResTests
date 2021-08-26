package FetchResponseData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class ResponseFormatsClass {
    
    @Test(description = "unformatted response")
    public void getResponseData()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
        System.out.println(response.asString());
    }

    @Test(description = "As Pretty String formatted response")
    public void getResponseDataPrettyString()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
        String bodyResponse = response.asPrettyString();
        System.out.println(bodyResponse);
    }

    @Test(description = "Pretty print formatted response")
    public void getResponseDataPrettyPrint()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
        response.prettyPrint();
    }

    @Test(description = "Response body Pretty print formatted response")
    public void getResponseDataPrettyPrint1()
    {
       Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
       String respBody = response.getBody().prettyPrint();
       System.out.println(respBody);
    }

    @Test(description = "As Pretty String formatted response")
    public void getResponseDataPrettyString1()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void getResponseDataInList()
    {
        Response response = RestAssured.get("https://restcountries.eu/rest/v2/all");
        String jsonResponse = response.asString();
        JsonPath jp = response.jsonPath();
        List<Object> countryNames = jp.getList("name");
        System.out.println(countryNames);
    }

}
