package lesson_9;

import lesson_9.Main.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;
    private final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");

        @BeforeEach
        void setup() {
            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--height=1080");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            driver.get("https://www.mts.by/");
            try {
                WebElement cookieClose = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
                cookieClose.click();
            } catch (Exception ignored) {}
            }

        @Test
        void smokeTest () {
            System.out.println("Заголовок страницы: " + driver.getTitle());

        }
    }