package lesson_10;

import lesson_10_Main.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TitleBlockTest extends MainPage {

    @Test
    void testTitleBlock() {
        WebElement titleBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        assertTrue(titleBlock.isDisplayed(), "Название блока не отображается");
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ", titleBlock.getText().trim(), "Неверный заголовок блока");
    }
}