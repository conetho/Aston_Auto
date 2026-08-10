package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PutRequestTest extends PostmanEchoTest{

    @Test
    public void putRequestTest(){
        String requestBody = "lol";

        given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }
}