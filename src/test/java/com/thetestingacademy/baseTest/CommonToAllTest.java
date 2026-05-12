package com.thetestingacademy.baseTest;

import com.thetestingacademy.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        WebDriver driver = DriverManager.getDriver();
        DriverManager.down();
    }
}
