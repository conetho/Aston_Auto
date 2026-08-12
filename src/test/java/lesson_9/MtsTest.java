package lesson_9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;
    private final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @Test
    public void testPaymentLogosPresence() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены в блоке.");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов платёжных систем не отображается на странице.");
            assertFalse(logo.getAttribute("src").isEmpty(), "У логотипа отсутствует источник изображения (src).");
        }
    }


}
