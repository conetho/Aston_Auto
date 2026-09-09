package lesson_9;

import lesson_9_Base.BaseTestLessonNine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTestLessonNine extends BaseTestLessonNine {

    @Test
    @DisplayName("Заголовок блока «Онлайн пополнение без комиссии» отображается")
    public void testBlockTitle() {
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        assertTrue(mainPageNineLesson.getBlockTitle().contains(expectedTitle), "Название блока не отображается");
    }

    @Test
    @DisplayName("В блоке оплаты присутствуют все логотипы платёжных систем")
    public void testPaymentLogo() {
        assertEquals(5, mainPageNineLesson.getLogos(), "Присутствуют не все логотипы");
    }

    @Test
    @DisplayName("Ссылка «Подробнее о сервисе» ведёт на страницу с информацией")
    public void testMoreInfoLink() {
        mainPageNineLesson.clickMoreInfoLink();
        assertEquals("Информация о безопасности Интернет-платежей", mainPageNineLesson.getMoreInfoTitle(),
                "Неверный заголовок страницы");
    }

    @Test
    @DisplayName("После заполнения формы и нажатия «Продолжить» открывается окно оплаты. Введенные данные и " +
            "плэйсхолдеры отображаются")
    public void testConnectionForm() {
        String phoneNumber = "297777777";
        String sum = "10.00 BYN";
        mainPageNineLesson.fillConnectionForm(phoneNumber, sum, "test@test.by");
        mainPageNineLesson.clickContinue();
        assertTrue(mainPageNineLesson.isTransitionToPayment(), "Окно оплаты не появилось");
    }
}
