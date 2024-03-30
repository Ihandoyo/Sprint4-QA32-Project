package ru.matrosov;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;

import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.MatcherAssert;

@RunWith(Parameterized.class)
public class TestOrder
    {
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String station;
        private final String phone;
        private final String date;
        private final String rent;
        private final String color;
        private final String comment;
        private final String choiceButton;

        private final DriverFactory driverFactory = new DriverFactory ();

        public TestOrder(String choiceButton, String firstName, String lastName, String address, String station, String phone, String date, String rent, String color, String comment) {
            this.choiceButton = choiceButton;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.station = station;
            this.phone = phone;
            this.date = date;
            this.rent = rent;
            this.color = color;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] placeOrder( ) {
            return new Object[][]{
                    {"Up", "Дмитрий", "Матросов", "Большая Андроньевская, 8", "Римская", "+79161242222", "01.02.2024", "двое суток", "чёрный жемчуг", "Без комментариев"},
                    {"Middle", "Дмит рий", "Матросов", "Большая Андроньевская, 8", "Сокольники", "89161242222", "03.02.2024", "сутки", "серая безысходность", " "}};
        }

        @Before
        public void initDriver( ) {
            driverFactory.initDriver ();
        }

        @Test
        public void testFlowOrder( ) {
            MainPage mainPage = new MainPage (driverFactory.getDriver ());
            mainPage.clickAcceptCookie ();

            OrderPage orderPage = new OrderPage (driverFactory.getDriver ());

            if (choiceButton.equals ("Up")) {
                mainPage.clickOrderButtonUp ();
            } else mainPage.clickOrderButtonMiddle ();

            orderPage.flowOrder (firstName, lastName, address, station, phone, date, rent, color, comment);
            MatcherAssert.assertThat (orderPage.checkPlacedOrder (), containsString ("Заказ оформлен"));
        }

        @After
        public void closeDriver( ) {
            driverFactory.getDriver ().quit ();
        }
    }
