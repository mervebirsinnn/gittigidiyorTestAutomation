package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchListPage extends BasePage{

    BasePage basePage = new BasePage(driver, wait, action);

    public SearchListPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public static String searchBoxName =  "k";
    public static String key ="Bilgisayar";
    public static String searchButtonXpath = "//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']/span";
    public static String secondPageXpath = "//a[text()='2']";



    public void sendKeys(){
        basePage.writeText(By.name(searchBoxName),key);
    }

    public  void searchButtonClick(){
        basePage.click(By.xpath(searchButtonXpath));
    }

    public void secondPageClick() {
        basePage.scroll(By.xpath(secondPageXpath));

    }
    public String secondPageVerify(){
       return basePage.getText1(By.xpath(secondPageXpath));
    }





}
