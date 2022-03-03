package org.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Main extends Base{


    @Test
    public void testGittiGidiyor()throws InterruptedException {

        //goToUrl
        logger.info("LandingPage Check");
        landingPage.goTo();
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        landingPage.verifyPageLoaded();
        logger.info("Check LandingPage Title");
        Assert.assertTrue(driver.getTitle().equals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi"));
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        logger.info("LandingPage Done");


        //loginHover
        logger.info("Login Check");
        landingPage.hoverClickButton();
        Thread.sleep(2000);
        landingPage.clickLogin();
        //login
        Thread.sleep(2000);
        loginPage.sendKeys();
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        Thread.sleep(2000);

        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        loginPage.clickLogin();
        logger.info("Login Check Done");


        //searchProduct
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        logger.info("SearchPage Check");
        searchListPage.sendKeys();
        searchListPage.searchButtonClick();

        //searchResult

        searchListPage.secondPageClick();
        logger.info("Check SearchPage");
        Assert.assertTrue(searchListPage.secondPageVerify().equals("2"));
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        logger.info("SearchPage Check Done");



        //productDetail
        productDetailPage.productSelect();
        productDetailPage.add();
        productDetailPage.goToBasket();
        logger.info("CardPage Check");

        //basketPageTransactions
        logger.info("Check Price");
        String oldPrice= cardPage.totalPriceOne();
        assertEquals(cardPage.getbasketPrice(),oldPrice);

        logger.info("Check Quantity");
        cardPage.increaseProductQuantity();
        Thread.sleep(2000);
        logger.info("Check Card");
        assertNotEquals(oldPrice,cardPage.totalPriceTwo());
        cardPage.deleteProduct();
        logger.info("CardPage Check Done");


    }


    @After
    public void quitDriver() {
        this.driver.manage().timeouts().implicitlyWait(45L, TimeUnit.SECONDS);
        //this.driver.quit();
    }
}
