package org.example;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
    BasePage basePage = new BasePage(driver, wait, action);

    public  LoginPage(WebDriver driver, WebDriverWait wait, Actions action) { super(driver, wait, action);}


    public static String mailId = "L-UserNameField";
    public static String passwordId = "L-PasswordField";
    public static String loginButtonId = "gg-login-enter";




    public void sendKeys(){ //send keys login popup
        basePage.writeText(By.id(mailId),"anilbchg@gmail.com");
        basePage.writeText(By.id(passwordId),"Bir234");
    }
    public void clickLogin(){
        click(By.id(loginButtonId));
    } // clicks login button located on login popup

    public String verifyMail(){
        System.out.println("mail:"+basePage.getText1(By.id(mailId)));
       return basePage.getText1(By.id(mailId));

    }
    public String verifyPassword(){
        return basePage.getText1(By.id(passwordId));
    }

}
