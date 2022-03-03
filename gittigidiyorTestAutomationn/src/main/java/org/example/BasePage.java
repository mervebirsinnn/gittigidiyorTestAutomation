package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Random;


public class BasePage {
    //Base page contains common methods which are used other classes
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    public  BasePage(WebDriver driver, WebDriverWait wait,Actions action){
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }



    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    public void clear(By elementLocation){
        driver.findElement(elementLocation).clear();
    }

    public void hoverClick(By elementLocation){
        this.action = new Actions(driver);
        action.moveToElement(driver.findElement(elementLocation)).click().build().perform();
        driver.findElement(elementLocation).click();
    }

    public String getText1(By elementLocation){
        String text= this.driver.findElement(elementLocation).getText();
        return text;
    }

    public String getQuantity(By elementLocation){
        String quantity= this.driver.findElement(elementLocation).getAttribute("value");
        return quantity;
    }



    public void writeText(By elementLocation, String text){
        driver.findElement(elementLocation).sendKeys(text);
    }

    public  void waitUntilPageContainElement(String elementName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
    }

    public void waitUntilPageContainElementsID(String elementName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName))); //waits until specified element is loaded

    }

    public String getProductQuantitiy(String elementLocation, String name) {

        String quantity = driver.findElement(By.xpath(elementLocation)).getAttribute("value");
        System.out.println();

        return quantity;
    }

    public void VerifyFullyLoaded2(WebDriver driver){ //to verify page ready or not

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String ready = (String)js.executeScript("return document.readyState");
        System.out.println("Ready or not : "+ready);
    }

    public void getCurrentUrl(){driver.getCurrentUrl();} //to get current page url

    public void scroll (By elementLocation){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementLocation));
        try {
            driver.findElement(elementLocation).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(elementLocation));
        }
    }

    public void clearArea(By elementLocation){
        driver.findElement(elementLocation).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

    }

    public void randomSelection(By elementLocation) {

        List<WebElement> elements = driver.findElements(elementLocation);
        int maxCount = elements.size();
        Random random = new Random();
        int randomCount = random.nextInt(maxCount);
        elements.get(randomCount).click();

    }


}
