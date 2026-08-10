package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PostRequestTest extends PostmanEchoTest {

    @Test
    public void testPostRequest() {
        String requestBody = "{\"foo1\": \"bar1\"}";
        given()
                .log().all()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("data.foo1", equalTo("bar1"));
    }
}
