package lesson_10_Base;

import lesson_10_Main.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Общая подготовка для всех тестов:
 * перед каждым тестом — открыть браузер и страницу, после — закрыть браузер.
 */
public abstract class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
