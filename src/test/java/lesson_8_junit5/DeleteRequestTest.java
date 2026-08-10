package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class DeleteRequestTest extends PostmanEchoTest {

    @Test
    void deleteRequest() {
        String requestBody = "Delete payload";

        given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }
}
