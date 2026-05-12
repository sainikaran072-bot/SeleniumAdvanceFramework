package com.thetestingacademy.pages.PageFactory.VWO;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class VWO_freeTrialPage_PF extends CommonToAllPage {
    WebDriver driver;
    public VWO_freeTrialPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText ="Start a FREE TRIAL")
    private WebElement freeTrialLinkElement;
    @FindBy(id="page-v1-step1-email")
    private WebElement businessEmail;
    @FindBy(id="page-free-trial-step1-cu-gdpr-consent-checkbox")
    private WebElement confirmCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;
    @FindBy(xpath = "//div[text()='An account with this email already exists. ']")
    private WebElement error_message;

    public String VWO_feeTrialPage_PF(String email){
        openVWOUrl();
        clickElement(freeTrialLinkElement);
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        enterInput(businessEmail,(email));
        clickElement(confirmCheckBox);
        clickElement(createButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);
    }
}
