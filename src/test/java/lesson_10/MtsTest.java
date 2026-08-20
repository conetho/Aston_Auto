package lesson_10;

import lesson_10_Main.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {
    private WebDriver driver;
    private MainPage mainPage;
    private final String BASE_URL = "https://mts.by";

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        assertTrue(mainPage.getBlockTitle().contains(expectedTitle), "Название блока не отображается");
    }

    @Test
    public void testPaymentLogo() {
        assertEquals(5, mainPage.getLogos(), "Присутствуют не все логотипы");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
