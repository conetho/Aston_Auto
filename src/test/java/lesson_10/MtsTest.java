package lesson_10;

import lesson_10_Base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тесты блока «Онлайн пополнение без комиссии» на mts.by.
 * Браузер открывает и закрывает BaseTest, действия на странице делает MainPage,
 * здесь остаются только проверки (assert).
 *
 * Как запустить тесты:
 *   mvn clean test
 * Как открыть Allure-отчёт (соберёт и откроет в браузере):
 *   mvn allure:serve
 * Требуется JDK 21 (JAVA_HOME должен указывать на него) и установленный Firefox.
 */
public class MtsTest extends BaseTest {

    @Test
    @DisplayName("Заголовок блока «Онлайн пополнение без комиссии» отображается")
    public void testBlockTitle() {
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        assertTrue(mainPage.getBlockTitle().contains(expectedTitle), "Название блока не отображается");
    }

    @Test
    @DisplayName("В блоке оплаты присутствуют все логотипы платёжных систем")
    public void testPaymentLogo() {
        assertEquals(5, mainPage.getLogos(), "Присутствуют не все логотипы");
    }

    @Test
    @DisplayName("Ссылка «Подробнее о сервисе» ведёт на страницу с информацией")
    public void testMoreInfoLink() {
        mainPage.clickMoreInfoLink();
        assertEquals("Информация о безопасности Интернет-платежей", mainPage.getMoreInfoTitle(),
                "Неверный заголовок страницы");
    }

    @Test
    @DisplayName("Плэйсхолдеры всех опций отображаются")
    public void testOptionFields() {
        mainPage.selectOption("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getPlaceholder("internet-phone"),
                "Неверный плэйсхолдер поля номера абонента");
        assertEquals("Сумма", mainPage.getPlaceholder("internet-sum"),
                "Неверный плэйсхолдер поля суммы");
        assertEquals("E-mail для отправки чека", mainPage.getPlaceholder("internet-email"),
                "Неверный плэйсхолдер поля email");
        mainPage.selectOption("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getPlaceholder("score-instalment"),
                "Неверный плэйсхолдер поля номера счета");
        assertEquals("Сумма", mainPage.getPlaceholder("instalment-sum"),
                "Неверный плэйсхолдер поля суммы");
        assertEquals("E-mail для отправки чека", mainPage.getPlaceholder("instalment-email"),
                "Неверный плэйсхолдер поля email");
        mainPage.selectOption("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getPlaceholder("score-arrears"),
                "Неверный плэйсхолдер поля номера счета");
        assertEquals("Сумма", mainPage.getPlaceholder("arrears-sum"),
                "Неверный плэйсхолдер поля суммы");
        assertEquals("E-mail для отправки чека", mainPage.getPlaceholder("arrears-email"),
                "Неверный плэйсхолдер поля email");
        mainPage.selectOption("Услуги связи");
        assertEquals("Номер телефона", mainPage.getPlaceholder("phone"),
                "Неверный плэйсхолдер поля номера телефона");
        assertEquals("Сумма", mainPage.getPlaceholder("sum"),
                "Неверный плэйсхолдер поля суммы");
        assertEquals("E-mail для отправки чека", mainPage.getPlaceholder("email"),
                "Неверный плэйсхолдер поля email");
    }

    @Test
    @DisplayName("После заполнения формы и нажатия «Продолжить» открывается окно оплаты")
    public void testConnectionForm() {
        String phoneNumber = "297777777";
        String sum = "10.00 BYN";
        mainPage.fillConnectionForm(phoneNumber, sum, "test@test.by");
        mainPage.clickContinue();
        assertTrue(mainPage.isTransitionToPayment(), "Окно оплаты не появилось");

        String cardNumberField = "Номер карты";
        String cardExpirationField = "Срок действия";
        String cardCvcField = "CVC";
        String cardNameField = "Имя и фамилия на карте";
        assertTrue(mainPage.getModalPhoneText().contains(phoneNumber), "Лэйбл номера телефона не отображается");
        assertTrue(mainPage.getModalSumText().contains(sum), "Название блока не отображается");
        assertTrue(mainPage.getModalPayButtonText().contains(sum), "Название блока не отображается");
        assertTrue(mainPage.getModalSmallSumText().contains(sum), "Название блока не отображается");
        assertTrue(mainPage.getCardNumberInputLabel().contains(cardNumberField), "Название блока не отображается");
        assertTrue(mainPage.getCardExpirationInputLabel().contains(cardExpirationField), "Название блока не отображается");
        assertTrue(mainPage.getCardCvcInputLabel().contains(cardCvcField), "Название блока не отображается");
        assertTrue(mainPage.getCardNameInputLabel().contains(cardNameField), "Название блока не отображается");
        assertEquals(5, mainPage.getModalLogos(), "Присутствуют не все логотипы");
    }
}
