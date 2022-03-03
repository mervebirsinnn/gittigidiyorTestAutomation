package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends  BasePage{

    BasePage basePage = new BasePage(driver, wait, action);
    public ProductDetailPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public static String basketBtnId = "add-to-basket";
    public static String basketXpath =  "//div[@class='header-cart-container robot-header-cart-container hidden']/a";
    public static String productXpath = "//ul[@class='catalog-view clearfix products-container']/li";
    public  static String quantityBoxId ="buyitnow_adet";


    /*public String getProductPrice(){
        productSelect();
        add();
        return driver.findElement(By.xpath(price)).getText();
    }*/

    public void productSelect(){
        basePage.randomSelection(By.xpath(productXpath));

    }
    public void clearQuantityBox(){
        basePage.hoverClick(By.id(quantityBoxId));
        basePage.clearArea(By.id(quantityBoxId));

    }
    public void add(){
        basePage.scroll(By.id(basketBtnId));
    }

    public void goToBasket(){
        basePage.scroll(By.xpath(basketXpath));
    }



}
