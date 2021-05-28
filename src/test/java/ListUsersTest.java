import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ListUsersTest {

    String URL = "https://reqres.in/";
    int statusCode = 200;

    @Test
    public void getUsers(){
        given()
                .header("contentType", "application/json")
                .when()
                .get(URL)
                .then()
                .log()
                .all();

        System.out.println(" time " + get(URL).timeIn(TimeUnit.MILLISECONDS));
        given().when().get(URL).then().assertThat().statusCode(statusCode);
    }

}
