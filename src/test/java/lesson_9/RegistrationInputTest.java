package lesson_9;

import lesson_9_Main.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationInputTest extends MainPage {

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
}
