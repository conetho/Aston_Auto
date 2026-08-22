package lesson_10_Main;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object главной страницы mts.by:
 * здесь живут локаторы элементов и действия над ними.
 * Тесты сами не ищут элементы — только зовут методы этого класса.
 */
public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы элементов блока «Онлайн пополнение»
    private final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");
    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private final By moreInfoLink = By.xpath("//div[contains(@class, 'pay__wrapper')]//a[contains(text(), 'Подробнее о сервисе')]");
    private final By moreInfoTitle = By.xpath("//div[@class='container-fluid']//h3[2]");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By emailInput = By.id("connection-email");
    private final By submitButton = By.xpath("//button[@class='button button__default ']");
    private final By optionConnection = By.xpath("//ul[@class='select__list']//p[contains(text(), 'Услуги связи')]");
    private final By optionInternet = By.xpath("//ul[@class='select__list']//p[contains(text(), 'Домашний интернет')]");
    private final By optionInstallment = By.xpath("//ul[@class='select__list']//p[contains(text(), 'Рассрочка')]");
    private final By optionArrears = By.xpath("//ul[@class='select__list']//p[contains(text(), 'Задолженность')]");
    private final By selectOptionsHeaderButton = By.xpath("//button[@class='select__header']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открыть главную страницу mts.by и закрыть баннер cookies")
    public void open() {
        driver.get("https://mts.by");
        try {
            WebElement cookieClose = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieClose.click();
        } catch (Exception ignored) {}
    }

    @Step("Получить заголовок блока оплаты")
    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText().trim();
    }

    @Step("Посчитать логотипы платёжных систем")
    public int getLogos() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        return logos.size();
    }

    @Step("Кликнуть по ссылке «Подробнее о сервисе»")
    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
    }

    @Step("Получить заголовок страницы «Подробнее о сервисе»")
    public String getMoreInfoTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoTitle)).getText().trim();
    }

    @Step("Выбрать тип услуги")
    public void selectOption(String optionName) {
        By locator = switch (optionName) {
            case "Услуги связи" -> optionConnection;
            case "Домашний интернет" -> optionInternet;
            case "Рассрочка" -> optionInstallment;
            case "Задолженность" -> optionArrears;
            default -> throw new IllegalArgumentException("Неизвестная опция");
        };
        wait.until(ExpectedConditions.elementToBeClickable(selectOptionsHeaderButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Получить плэйсхолдер по локатору")
    public String getPlaceholder(String fieldType) {
        By locator = switch (fieldType) {
            case "phone" -> By.id("connection-phone");
            case "sum" -> By.id("connection-sum");
            case "email" -> By.id("connection-email");
            case "internet-phone" -> By.id("internet-phone");
            case "internet-sum" -> By.id("internet-sum");
            case "internet-email" -> By.id("internet-email");
            case "score-instalment" -> By.id("score-instalment");
            case "instalment-sum" -> By.id("instalment-sum");
            case "instalment-email" -> By.id("instalment-email");
            case "score-arrears" -> By.id("score-arrears");
            case "arrears-sum" -> By.id("arrears-sum");
            case "arrears-email" -> By.id("arrears-email");
            default -> throw new IllegalArgumentException("Неизвестное поле");
        };
        return driver.findElement(locator).getAttribute("placeholder");
    }

    @Step("Заполнить форму «Услуги связи»: телефон={phone}, сумма={sum}, email={email}")
    public void fillConnectionForm(String phone, String sum, String email) {
        selectOption("Услуги связи");

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).clear();
        driver.findElement(phoneInput).sendKeys(phone);

        driver.findElement(sumInput).clear();
        driver.findElement(sumInput).sendKeys(sum);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Нажать кнопку «Продолжить»")
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    @Step("Проверить переход к платёжному виджету")
    public boolean isTransitionToPayment() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("payment-widget-iframe")),
                ExpectedConditions.urlContains("checkout.bepaid.by")
        ));
        return true;
    }
}
