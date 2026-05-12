package com.thetestingacademy.pages.PageObjectModel.VWO.improved_POM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class VWO_loginpage extends CommonToAllPage{
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
        openVWOUrl();
        enterInput(username,(usr));
        enterInput(password,(pwd));
        clickElement(sighInButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);
    }

    public void VWO_Login_with_validCred(String usr, String pwd){
        enterInput(username,(usr));
        enterInput(password,(pwd));
        clickElement(sighInButton);

    }
}
