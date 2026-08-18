package lesson_9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    WebDriver driver;
    WebDriverWait wait;
    private final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");
    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private final By moreInfoLink = By.xpath("//div[contains(@class, 'pay__wrapper')]//a[contains(text(), 'Подробнее о сервисе')]");
    private final By moreInfoText = By.xpath("//div[@class='container-fluid']//h3[2]");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By submitButton = By.xpath("//button[@class='button button__default ']");

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

    @Test
    void testTitleBlock() {
        WebElement titleBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        assertTrue(titleBlock.isDisplayed(), "Название блока не отображается");
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ", titleBlock.getText().trim(), "Неверный заголовок блока");
    }

    @Test
    void testPaymentLogo() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        assertFalse(logos.isEmpty(), "Логотипы платежных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов платежных систем не отображается");
            assertFalse(logo.getAttribute("src").isEmpty(), "У логотипа отсутствует источник изображения (src)");
        }
    }

    @Test
    void testMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        link.click();
        WebElement moreInfoTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoText));
        assertTrue(moreInfoTextElement.isDisplayed(), "Такого текста нет");
        assertEquals("Информация о безопасности Интернет-платежей", moreInfoTextElement.getText().trim(), "Неверный заголовок блока");
    }

    @Test
    public void testRegistrationInput() {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        phoneField.clear();
        phoneField.sendKeys("297777777");

        WebElement sumField = driver.findElement(sumInput);
        sumField.clear();
        sumField.sendKeys("10");

        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        assertTrue(submitButtonElement.isEnabled(), "Кнопка 'Продолжить' не активна");
        submitButtonElement.click();

        WebElement appPaymentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='payment-widget-iframe']")));
        assertTrue(appPaymentContainer.isDisplayed(), "Фрейм оплаты не появился после нажатия кнопки 'Продолжить'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}