package com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VWO_dashboardPage {
    WebDriver driver;
    public VWO_dashboardPage(WebDriver driver){
        this.driver=driver;
    }


        private By usernameOnLoggedIn = By.xpath("//span[@data-qa='lufexuloga']");

    public String usernameLoggedIn() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://app.vwo.com/#/dashboard?accountId=1230707");
        Thread.sleep(3000);
        WaitHelpers.visibilityOfElement(usernameOnLoggedIn);
        return driver.findElement(usernameOnLoggedIn).getText();
    }




}
