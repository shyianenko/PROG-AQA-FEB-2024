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

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            //accept cookies if they are present
            //find all buttons in cookies form
//            List<WebElement> cookieButtons =
//                    driver.findElements(By.xpath(
//                            "//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button"));
//            if (!cookieButtons.isEmpty()) {
//                //click button with index 3 (this button accepts all cookies)
//                cookieButtons.get(3).click();
//            }
            //TODO: sreach for razer
            //Step 1: set search form value to razer
            WebElement searchInput = driver.findElement(By.name("search"));
            WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
            searchInput.sendKeys("razer blackshark v2 pro");
            //Step 2: press enter while in search form
            //searchInput.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOf(searchButton));
            searchButton.click();

            List<WebElement> searchGoods = driver.findElements(By.xpath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']"));

            wait.until(ExpectedConditions.visibilityOfAllElements(searchGoods));
            WebElement firstGood = searchGoods.get(0);
            String titleOfFirstGood = firstGood.getText();
            System.out.println(titleOfFirstGood);

//            System.out.println(">>>>> " + searchItems.size());
//
//            int razerFound = 0;
//            for (WebElement element : searchItems) {
//                if (element.getText().contains("razer blackshark v2 pro")) {
//                    razerFound++;
//                }
//            }
//            if (razerFound >= 3) {
//                System.out.println("Ben found!");
//            } else {
//                System.out.println("Ben not found :(");
//            }
        } finally {
            driver.quit();
        }
    }
}