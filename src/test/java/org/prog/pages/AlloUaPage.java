package org.prog.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AlloUaPage {

    private final WebDriver driver;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void searchForGoods(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchValue);
        searchInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L)).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.product-card"), 1));
    }

    public void waitUntilPageLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(30L)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-block-gif")));
    }

    public boolean searchResultsContain(String value) {
        List<WebElement> searchResults = getSearchResults();
        Assert.assertFalse(searchResults.isEmpty(), "Search results must not be empty!");
        boolean valueIsPresent = false;
        for (WebElement e : searchResults) {
            if (e.findElement(By.xpath("div/a")).getText().contains(value)) {
                valueIsPresent = true;
                break;
            }
        }
        return valueIsPresent;
    }

    public WebElement pagination() {
        return driver.findElement(By.className("pagination"));
    }

    public void scrollToElement(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }

    public void paginateNext() throws InterruptedException{
        scrollToElement(pagination());
        WebElement currentPage = driver.findElement(By.xpath("//li[@class='pagination__item current']"));
        int initialPageNumber = Integer.parseInt(currentPage.getText().trim());

        WebElement nextPage = currentPage.findElement(By.xpath("//li[@class='pagination__item current']/following-sibling::li[1]"));
        nextPage.click();
        waitUntilPageLoaded();
        //Thread.sleep(6000);
        scrollToElement(pagination());

        int currentPageNumber = Integer.parseInt(driver.findElement(By.xpath("//li[@class='pagination__item current']")).getText().trim());
        Assert.assertEquals(currentPageNumber, initialPageNumber + 1, "Expected page is not correct");
    }

    public void paginatePrevious() throws InterruptedException{
        scrollToElement(pagination());
        WebElement currentPage = driver.findElement(By.xpath("//li[@class='pagination__item current']"));
        int initialPageNumber = Integer.parseInt(currentPage.getText().trim());

        WebElement nextPage = currentPage.findElement(By.xpath("//li[@class='pagination__item current']/preceding-sibling::li[1]"));
        nextPage.click();
        waitUntilPageLoaded();
        //Thread.sleep(6000);
        scrollToElement(pagination());

        int currentPageNumber = Integer.parseInt(driver.findElement(By.xpath("//li[@class='pagination__item current']")).getText().trim());
        Assert.assertEquals(currentPageNumber, initialPageNumber - 1, "Expected page is not correct");
    }

    public void paginateRight() throws InterruptedException {
        WebElement nextArrow = driver.findElement(By.xpath("//div[contains(@class, 'pagination__next')]"));
        WebElement currentPage = driver.findElement(By.xpath("//li[@class='pagination__item current']"));
        int initialPageNumber = Integer.parseInt(currentPage.getText().trim());

        if (nextArrow.isDisplayed()) {
            scrollToElement(nextArrow);
            nextArrow.click();
            waitUntilPageLoaded();
            //Thread.sleep(6000);
            scrollToElement(pagination());

            int currentPageNumber = Integer.parseInt(driver.findElement(By.xpath("//li[@class='pagination__item current']")).getText().trim());
            Assert.assertEquals(currentPageNumber, initialPageNumber + 1, "Expected page is not correct");
        }
    }

    public void paginateLeft() throws InterruptedException {
        WebElement backArrow = driver.findElement(By.xpath("//div[contains(@class, 'pagination__prev')]"));
        WebElement currentPage = driver.findElement(By.xpath("//li[@class='pagination__item current']"));
        int initialPageNumber = Integer.parseInt(currentPage.getText().trim());

        if (backArrow.isDisplayed()) {
            scrollToElement(backArrow);
            backArrow.click();
            waitUntilPageLoaded();
            //Thread.sleep(6000);
            scrollToElement(pagination());

            int currentPageNumber = Integer.parseInt(driver.findElement(By.xpath("//li[@class='pagination__item current']")).getText().trim());
            Assert.assertEquals(currentPageNumber, initialPageNumber - 1, "Expected page is not correct");
        }
    }
}
