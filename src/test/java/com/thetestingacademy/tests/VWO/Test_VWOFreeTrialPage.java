package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM.VWO_freeTrialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWOFreeTrialPage {
    @Test
    public void test_VWO_FreeTrialPage() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        VWO_freeTrialPage freeTrailPage=new VWO_freeTrialPage(driver);
        Thread.sleep(5000);
        String error_text=freeTrailPage.freeTrialButton("karan@tempmail.rest");

        assertThat(error_text).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_text, "An account with this email already exists. Login Here");

        driver.quit();


    }
}