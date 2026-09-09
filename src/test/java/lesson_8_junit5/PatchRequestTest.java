package lesson_8_junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PatchRequestTest extends PostmanEchoTest {

    @Test
    public void testPatchRequest() {
        String requestBody = "Patch";

        given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }
}