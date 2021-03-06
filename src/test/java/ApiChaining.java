import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiChaining {
    int userId;

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    public void getUsers(){
        Response response = given().header("Content-Type", "application/json").
                when().
                get("api/users").
                then().
                extract().
                response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        userId = jsonPathEvaluator.get("data[0].id");
        System.out.println(userId);

    }


    @Test
    public void getUserInfo(){

        given().
                when().
                get("api/users/"+userId).then().log().all();
    }

}
