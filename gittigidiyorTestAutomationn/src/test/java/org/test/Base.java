package org.test;

import org.apache.log4j.PropertyConfigurator;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    Logger logger;
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected SearchListPage searchListPage;
    protected ProductDetailPage productDetailPage;
    protected CardPage cardPage;

    @Before
    public void setup() {

        String projectPath = System.getProperty("user.dir");
        String log4jConfPath = projectPath+"/src/test/resources/log4j2.properties";
        PropertyConfigurator.configure(log4jConfPath);
        logger = LoggerFactory.getLogger(Base.class.getName());

        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        this.driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        this.driver.get(url);
        this.driver.manage().window().maximize();


            landingPage = new LandingPage(driver,wait,action);
            loginPage = new LoginPage(driver,wait,action);
            searchListPage = new SearchListPage(driver,wait,action);
            productDetailPage = new ProductDetailPage(driver,wait,action);
            cardPage = new CardPage(driver,wait,action);
    }

    @After
    public void quitDriver() {
        logger.info("TEST IS TERMINATED");
        this.driver.quit();
    }
}
