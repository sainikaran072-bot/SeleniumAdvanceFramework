package com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VWO_loginpage {
    //driver
    WebDriver driver;
    public VWO_loginpage(WebDriver driver){

        this.driver=driver;
    }
    //page locators
    private By username= By.id("login-username");
    private By password= By.id("login-password");
    private By sighInButton= By.id("js-login-btn");
    private By error_message= By.id("js-notification-box-msg");

    //page actions
    public String VWO_login_with_invalidCred(String usr, String pwd){
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(sighInButton).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(error_message, "Your email, password, IP address or location did not match"));
        String error_message_text=driver.findElement(error_message).getText();
        return error_message_text;

    }
    public void VWO_Login_with_validCred(String usr, String pwd){
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(sighInButton).click();

    }
}
