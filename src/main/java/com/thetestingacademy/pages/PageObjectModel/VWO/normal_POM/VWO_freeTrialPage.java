package com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class VWO_freeTrialPage {
    WebDriver driver;
    public VWO_freeTrialPage(WebDriver driver){
        this.driver=driver;
    }

    private By freeTrialLinkElement= By.linkText("Start a FREE TRIAL");
    private By businessEmail=By.id("page-v1-step1-email");
    private By confirmCheckbox = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
    private By createButton = By.xpath("//button[@type='submit']");
    private By error_message= By.xpath("//div[text()='An account with this email already exists. ']");


    public String freeTrialButton(String email){
        driver.findElement(freeTrialLinkElement).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
      String  parentId=it.next();
      String childId=it.next();
      driver.switchTo().window(childId);

    driver.findElement(businessEmail).sendKeys(email);
    driver.findElement(confirmCheckbox).click();
    driver.findElement(createButton).click();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(error_message, "An account with this email already exists. Login Here"));
    String getTextMessage=driver.findElement(error_message).getText();
    return getTextMessage;

    }


}
