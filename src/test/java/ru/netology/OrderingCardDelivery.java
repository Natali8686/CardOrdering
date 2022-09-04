package ru.netology;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

import java.lang.module.Configuration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Selenide.open;

public class OrderingCardDelivery {

    @BeforeEach
    void test1() {
        Configuration.holdBrowserOpen = true;

        Selenide.open("http://localhost:9999/");

    }
    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, +5);
        return dateFormat.format(calendar.getTime());
    }

}
