package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PostRawRequestTest extends PostmanEchoTest {

    @Test
    public void testPostRawRequest() {
        String requestBody = "{\"name\": \"John Doe\", \"age\": 30}";
        given()
                .log().all()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("John Doe"))
                .body("json.age", equalTo(30))
                .body("data.name", equalTo("John Doe"));
    }
}