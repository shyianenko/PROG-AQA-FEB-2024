package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TODO: go to rozetka
//TODO: search for any goods (iPhone 15)
//TODO: print that goods name ( Мобильный телефон Apple iPhone 15 Pro Max 256GB Black Titanium (MU773RX/A) )

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            //accept cookies if they are present
            //find all buttons in cookies form

            //TODO: sreach for razer
            //Step 1: set search form value to razer
            WebElement searchInput = driver.findElement(By.name("search"));
            WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
            searchInput.sendKeys("razer blackshark v2 pro");
//            Thread.sleep(4000);
            //Step 2: press enter while in search form
            searchInput.sendKeys(Keys.ENTER);
//            wait.until(ExpectedConditions.visibilityOf(searchButton));
//            searchButton.click();

            List<WebElement> searchGoods = driver.findElements(By.xpath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']"));
//            Thread.sleep(4000);
            wait.until(ExpectedConditions.visibilityOfAllElements(searchGoods));
            WebElement firstGood = searchGoods.get(0);
            String titleOfFirstGood = firstGood.getText();
            System.out.println(titleOfFirstGood);

        } finally {
            driver.quit();
        }
    }
}