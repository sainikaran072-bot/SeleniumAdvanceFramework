package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.VWO.improved_POM.VWO_freeTrialPage_improvedPOM;
import com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM.VWO_freeTrialPage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWOFreeTrialPage_ImprovedPOM extends CommonToAllTest {
    @Test
    public void test_VWO_FreeTrialPage() throws InterruptedException {

        VWO_freeTrialPage_improvedPOM freeTrialPage=new VWO_freeTrialPage_improvedPOM(DriverManager.getDriver());
        String error_text=freeTrialPage.freeTrialButton(PropertiesReader.readKey("freeTrial_email"));

        assertThat(error_text).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_text, PropertiesReader.readKey("freeTrial_error"));

    }
}
