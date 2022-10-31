package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.RETURN;

public class RozetkaPage {

    private final static String ROZETKA_SEARCH_BAR_NAME = "//input[@name='search']";
    private final static String ROZETKA_SEARCH_RESULTS = "//a[@class='goods-tile__heading ng-star-inserted']";

    private WebDriver driver;

    public RozetkaPage (WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchValue(String searchValue) {
        driver.findElement(By.xpath(ROZETKA_SEARCH_BAR_NAME)).clear();
        driver.findElement(By.xpath(ROZETKA_SEARCH_BAR_NAME)).sendKeys(searchValue);
    }
    public void performSearch(boolean usingMouse) {
        if (usingMouse) {
        } else {
            driver.findElement(By.xpath(ROZETKA_SEARCH_BAR_NAME)).sendKeys(RETURN);
        }}
        public List<String> getSearchResults() {
            return driver.findElements(By.xpath(ROZETKA_SEARCH_RESULTS))
                    .stream()
                    .map(webElement -> webElement.getText())
                    .collect(Collectors.toList());
        }
    public String getHeaderText() {
        return driver.findElement(By.xpath("//a[@class='goods-tile__heading ng-star-inserted']")).getText();
    }
    }

