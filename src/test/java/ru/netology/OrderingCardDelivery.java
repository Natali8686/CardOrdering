package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class OrderingCardDelivery {

    @BeforeEach
    void test1() {

        open("http://localhost:9999/");

    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));// метод принимает количество дней сдвига относительно текущей даты, а возвращает отформатированную строку с датой. Будет возможность генерировать различные даты, как валидные, так и невалидные.

    }

    @Test

    void completedForm() {
        Configuration.holdBrowserOpen = true;

        String planningDate = generateDate(4); // тестовый метод для работы с датой


        $("[data-test-id=city] input").setValue("Красноярск");
        $("[data-test-id=date] .input__control").click();
        $("[data-test-id=date] .input__control").sendKeys(Keys.CONTROL + "A");
        $("[data-test-id=date] .input__control").sendKeys(BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue(planningDate);
        $("[data-test-id=name] .input__control").setValue("Иван Васильев");
        $("[data-test-id=phone] .input__control").setValue("+79135178898");
        $("[data-test-id=agreement]").click();
        $x("//button[contains(@class, 'button_view_extra')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] [class='notification__content']").shouldHave(exactText("Встреча успешно забронирована на " + planningDate));
    }

}
