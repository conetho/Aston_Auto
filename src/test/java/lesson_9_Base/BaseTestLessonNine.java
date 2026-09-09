package lesson_9_Base;

import lesson_9_Main.MainPageNineLesson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTestLessonNine {
    protected WebDriver driver;
    protected MainPageNineLesson mainPageNineLesson;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        mainPageNineLesson = new MainPageNineLesson(driver);
        mainPageNineLesson.open();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
