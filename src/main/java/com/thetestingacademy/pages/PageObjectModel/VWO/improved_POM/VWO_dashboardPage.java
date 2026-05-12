package com.thetestingacademy.pages.PageObjectModel.VWO.improved_POM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static java.sql.DriverManager.getDriver;

public class VWO_dashboardPage extends CommonToAllPage {
    WebDriver driver;

    public VWO_dashboardPage(WebDriver driver) {
        this.driver = driver;
    }


    private By usernameOnLoggedIn = By.xpath("//span[@data-qa='lufexuloga']");

    public String usernameLoggedIn() throws InterruptedException {
        Thread.sleep(3000);
        try {
            getDriver("url_dashboard");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(3000);
        WaitHelpers.visibilityOfElement(usernameOnLoggedIn);
        return getText(usernameOnLoggedIn);
    }
}