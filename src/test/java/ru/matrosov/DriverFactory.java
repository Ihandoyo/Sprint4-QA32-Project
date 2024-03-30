package ru.matrosov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.MainPage;

public class DriverFactory
    {
        private WebDriver driver;

        public void initDriver( ) {
            if ("firefox".equals (System.getProperty ("browser"))) {
                initFirefox ();
            } else {
                initChrome ();
            }
        }

        private void initFirefox( ) {
            FirefoxOptions options = new FirefoxOptions ();
            options.addArguments ("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new FirefoxDriver (options);
            driver.get (MainPage.SAMOKAT_URL);
        }

        private void initChrome( ) {
            ChromeOptions options = new ChromeOptions ();
            options.addArguments ("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver (options);
            driver.get (MainPage.SAMOKAT_URL);
        }

        public WebDriver getDriver( ) {
            return driver;
        }

    }
