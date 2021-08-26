package ReqResTestcases;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostReqRes {

    @Test
    public void postTest()
    {
        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BA");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString())
                .when().body(request)
                .post("https://reqres.in/api/users")
        .then().statusCode(201 );

        Response response = given().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
    }
}
