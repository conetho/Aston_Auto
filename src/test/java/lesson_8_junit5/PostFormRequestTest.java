package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PostFormRequestTest extends PostmanEchoTest {

    @Test
    public void testPostFormRequest() {
        given()
                .log().all()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"));
    }
}