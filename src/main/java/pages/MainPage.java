package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage
    {
        public final static String SAMOKAT_URL = "https://qa-scooter.praktikum-services.ru/";

        private final WebDriver driver;
        //        кнопка "Заказать"
        private final By orderButtonUp = By.xpath (".//button[@class = 'Button_Button__ra12g']");
        //        кнопка "Заказать"
        private final By orderButtonMiddle = By.xpath (
                ".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");
        //        кнопка Да все привыкли
        private final By acceptCookie = By.xpath (".//button[@class= 'App_CookieButton__3cvqF']");


        public MainPage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickOrderButtonUp( ) {
            driver.findElement (orderButtonUp).click ();
        }

        public void clickOrderButtonMiddle( ) {
            driver.findElement (orderButtonMiddle).click ();
        }

        public void clickAcceptCookie( ) {
            driver.findElement (acceptCookie).click ();
        }

        public void questionClick(int questionNumber) {
            WebElement element = driver.findElement (By.xpath (
                    ".//div[@id='accordion__heading-" + questionNumber + "']"));
            ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", element);
            new WebDriverWait (driver, Duration.ofSeconds (2)).until (ExpectedConditions.visibilityOf (element));
            element.click ();
        }

        public String getAnswer(int answerNumber) {
            By answer = By.xpath (".//div[@id='accordion__panel-" + answerNumber + "']");
            new WebDriverWait (driver, Duration.ofSeconds (2)).
                    until (ExpectedConditions.visibilityOf (driver.findElement (answer)));
            return driver.findElement (answer).getText ();
        }
    }