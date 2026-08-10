package lesson_8_junit5;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class PostmanEchoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }
}
