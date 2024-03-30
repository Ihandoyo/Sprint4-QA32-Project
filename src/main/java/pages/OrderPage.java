package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage
    {
        private final WebDriver driver;
        //          поле "Имя"
        private final By nameInput = By.xpath (".//input[@placeholder= '* Имя']");
        //          поле "Фамилия"
        private final By surnameInput = By.xpath (".//input[@placeholder= '* Фамилия']");
        //          поле "Адрес"
        private final By addressInput = By.xpath (".//input[@placeholder= '* Адрес: куда привезти заказ']");
        //          поле "Метро"
        private final By metroInput = By.xpath (".//input[@placeholder= '* Станция метро']");
        //          поле "Телефон"
        private final By phoneInput = By.xpath (".//input[@placeholder= '* Телефон: на него позвонит курьер']");
        //          кнопка "Далее"
        private final By nextButton = By.xpath (".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
        //          поле "Календарь"
        private final By calendarInput = By.xpath ("//input[@placeholder= '* Когда привезти самокат']");
        //          поле "Срок аренды"
        private final By timeRent = By.className ("Dropdown-control");
        //          поле "Комментарий"
        private final By commentsInput = By.xpath (".//input[@placeholder= 'Комментарий для курьера']");
        //          кнопка "Заказать"
        private final By orderButton = By.xpath (".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
        //          кнопка "Да"
        private final By yesButton = By.xpath (".//button[text()='Да']");
        //          Заказ оформлен
        private final By placedOrderCheck = By.xpath (".//div[@class='Order_ModalHeader__3FDaJ']");


        public OrderPage(WebDriver driver) {
            this.driver = driver;
        }

        //          Заполнение поля Имя
        public void inputName(String firstName) {
            driver.findElement (nameInput).sendKeys (firstName);
        }

        //          Заполнение поля Фамилия
        public void inputLastname(String lastName) {
            driver.findElement (surnameInput).sendKeys (lastName);
        }

        //          Заполнения поля Адрес
        public void inputAddress(String address) {
            driver.findElement (addressInput).sendKeys (address);
        }

        //          Заполнение поля Метро
        public void inputMetro(String station) {
            driver.findElement (metroInput).sendKeys (station);
            driver.findElement (metroInput).sendKeys (Keys.DOWN);
            driver.findElement (metroInput).sendKeys (Keys.ENTER);
        }

        //          Заполнение поля Телефон
        public void inputPhone(String phone) {
            driver.findElement (phoneInput).sendKeys (phone);
        }

        //          Нажатие кнопки Далее
        public void clickNextButton( ) {
            driver.findElement (nextButton).click ();
        }

        //          Заполнение поля Календарь
        public void inputCalendar(String date) {
            driver.findElement (calendarInput).sendKeys (date);
            driver.findElement (calendarInput).sendKeys (Keys.ENTER);
        }

        //          Заполнение Срок аренды
        public void inputTimeRent(String rent) {
            driver.findElement (timeRent).click ();
            driver.findElement (By.xpath (".//div[text()='" + rent + "']")).click ();
        }

        //          Выбор Цвет самоката
        public void colorInput(String color) {
            if (color.equals ("чёрный жемчуг")) {
                driver.findElement (By.id ("black")).click ();
            } else {
                driver.findElement (By.id ("grey")).click ();
            }
        }

        //          Заполнение комментария
        public void inputComments(String comment) {
            driver.findElement (commentsInput).sendKeys (comment);
        }

        //          Нажатие кнопки Заказать
        public void clickOrderButton( ) {
            driver.findElement (orderButton).click ();
        }

        //          Нажатие кнопки Да
        public void clickYesButton( ) {
            driver.findElement (yesButton).click ();
        }

        //          Проверка оформления заказа
        public String checkPlacedOrder( ) {
            return driver.findElement (placedOrderCheck).getText ();
        }

        //          Заполнение форм заказа
        public void flowOrder(String firsName,
                              String lastName,
                              String address,
                              String station,
                              String phone,
                              String date,
                              String rent,
                              String color,
                              String comment) {
            inputName (firsName);
            inputLastname (lastName);
            inputAddress (address);
            inputMetro (station);
            inputPhone (phone);
            clickNextButton ();
            inputCalendar (date);
            inputTimeRent (rent);
            colorInput (color);
            inputComments (comment);
            clickOrderButton ();
            clickYesButton ();
        }
    }
