package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LandingPage extends BasePage{

    BasePage basePage = new BasePage(driver, wait, action);
    public LandingPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public static String loginPageUrl =  "https://www.gittigidiyor.com/";
    public static String firstLoginButtonXpath = "//*[contains(text(),'Giriş Yap')]";
    public static String LoginButtonXpath = "//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']";

    public void goTo() {
        driver.get(loginPageUrl);
    } //gets loginpage url and opens it

    public void verifyPageLoaded(){ basePage.VerifyFullyLoaded2(driver); } //check page loaded

    public void hoverClickButton(){
        basePage.hoverClick(By.xpath(firstLoginButtonXpath));
    }

    public void clickLogin(){
        basePage.click(By.xpath(LoginButtonXpath));
    }



}
