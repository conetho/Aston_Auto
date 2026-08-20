package lesson_10_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage {
    private final By paymentLogos = By.xpath("//div[contains(@class,'pay__partners')]//img");
    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private final By moreInfoLink = By.xpath("//div[contains(@class, 'pay__wrapper')]//a[contains(text(), 'Подробнее о сервисе')]");
    private final By moreInfoText = By.xpath("//div[@class='container-fluid']//h3[2]");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By emailInput = By.id("connection-email");
    private final By submitButton = By.xpath("//button[@class='button button__default ']");



    public void open() {
        driver.get("https://mts.by");
        try {
            WebElement cookieClose = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieClose.click();
        } catch (Exception ignored) {}
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText().trim();
    }

    public int getLogos() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        return logos.size();
    }

    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
    }

    public String getMoreInfoLink() {
        return driver.findElement(moreInfoLink).getAttribute("href");
    }

//    public void selectOption(String optionName) {
//        By locator = switch (optionName) {
//            case "Услуги связи" -> optionConnection;
//            case "Домашний интернет" -> optionInternet;
//            case "Рассрочка" -> optionInstallment;
//            case "Задолженность" -> optionDebt;
//            default -> throw new IllegalArgumentException("Неизвестная опция");
//        };
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//    }

    public String getPlaceholder(String fieldType) {
        By locator = switch (fieldType) {
            case "phone" -> By.id("connection-phone");
            case "sum" -> By.id("connection-sum");
            case "email" -> By.id("connection-email");
            case "internet-phone" -> By.id("internet-phone");
            case "internet-sum" -> By.id("internet-sum");
            case "internet-email" -> By.id("internet-email");
            case "installment-phone" -> By.id("installment-phone");
            case "installment-sum" -> By.id("installment-sum");
            case "installment-email" -> By.id("installment-email");
            case "debt-phone" -> By.id("arrears-phone");
            case "debt-sum" -> By.id("arrears-sum");
            case "debt-email" -> By.id("arrears-email");
            default -> throw new IllegalArgumentException("Неизвестное поле");
        };
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public void fillConnectionForm(String phone, String sum, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).clear();
        driver.findElement(phoneInput).sendKeys(phone);

        driver.findElement(sumInput).clear();
        driver.findElement(sumInput).sendKeys(sum);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isTransitionToPayment() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("payment-widget-iframe")),
                ExpectedConditions.urlContains("checkout.bepaid.by")
        ));
        return true;
    }
}
