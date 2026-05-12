package com.thetestingacademy.pages.PageFactory.VWO;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class VWO_loginpage_PF extends CommonToAllPage {
    WebDriver driver;

    public VWO_loginpage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement username;
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement signInButton;
    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    public String VWO_LoginWithInvalidCred_PF(String usr, String pwd) {
        openVWOUrl();
        enterInput(username,(usr));
        enterInput(password,(pwd));
        clickElement(signInButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);

    }


}
