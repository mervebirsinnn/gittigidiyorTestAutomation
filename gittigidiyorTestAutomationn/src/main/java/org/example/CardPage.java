package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage extends BasePage{

    BasePage basePage = new BasePage(driver, wait, action);
    public CardPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }


    public static String quantityIncrementXpath = "//span[@class='plus icon-plus gg-icon gg-icon-plus']";
    public static String quantityXpath = "//input[@class='amount']";
    public  static String quantityBoxId ="buyitnow_adet";
    public static String basketPrice = "//p[@class='new-price']";
    public static String priceXpath ="//div[@class='total-price']";
    public static String totalPriceXpath = "//div[@class='gg-d-8 detail-price'";
    public static String deleteButtonXpath = "btn-delete";


    public String totalPriceOne(){
        return basePage.getText1(By.xpath(priceXpath));
    }

    public String totalPriceTwo(){
        return basePage.getText1(By.xpath(priceXpath));

    }
    public String getbasketPrice(){
        return basePage.getText1(By.xpath(basketPrice));

    }

    public void increaseProductQuantity() {
        breakTime();
        basePage.click(By.xpath(quantityIncrementXpath));


    }



   public String  getQuantity(){
     basePage.getQuantity(By.id(quantityBoxId));
     return basePage.getQuantity(By.id(quantityBoxId));
   }

    public void deleteProduct() {
        breakTime();
        basePage.click(By.className(deleteButtonXpath));

    }


    private void breakTime() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
