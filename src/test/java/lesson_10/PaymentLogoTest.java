package lesson_10;

import lesson_10_Main.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//public class PaymentLogoTest  {
//
//    @Test
//    void testPaymentLogo() {
//        List<WebElement> logos = driver.findElements(paymentLogos);
//        assertFalse(logos.isEmpty(), "Логотипы платежных систем не найдены");
//        for (WebElement logo : logos) {
//            assertTrue(logo.isDisplayed(), "Один из логотипов платежных систем не отображается");
//            assertFalse(logo.getAttribute("src").isEmpty(), "У логотипа отсутствует источник изображения (src)");
//        }
//    }
//}
