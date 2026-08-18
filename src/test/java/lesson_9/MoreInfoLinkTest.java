package lesson_9;

import lesson_9_Main.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoreInfoLinkTest extends MainPage {

    @Test
    void testMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        link.click();
        WebElement moreInfoTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoText));
        assertTrue(moreInfoTextElement.isDisplayed(), "Такого текста нет");
        assertEquals("Информация о безопасности Интернет-платежей", moreInfoTextElement.getText().trim(), "Неверный заголовок блока");
    }
}
