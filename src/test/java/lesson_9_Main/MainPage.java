package lesson_9_Main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");
    public final By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    public final By moreInfoLink = By.xpath("//div[contains(@class, 'pay__wrapper')]//a[contains(text(), 'Подробнее о сервисе')]");
    public final By moreInfoText = By.xpath("//div[@class='container-fluid']//h3[2]");
    public final By phoneInput = By.id("connection-phone");
    public final By sumInput = By.id("connection-sum");
    public final By submitButton = By.xpath("//button[@class='button button__default ']");

    @BeforeEach
    void setup() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");
        try {
            WebElement cookieClose = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieClose.click();
        } catch (Exception ignored) {}
    }

    @AfterEach
     void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
