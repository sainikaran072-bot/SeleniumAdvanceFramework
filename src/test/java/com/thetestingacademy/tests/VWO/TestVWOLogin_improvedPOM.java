package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.VWO.improved_POM.VWO_loginpage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_improvedPOM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_improvedPOM.class);
    @Owner("Karan")
    @Description("Verify that with Invalid email, password, error message shown")
    @Test
    public void test_negative_vwo_login(){
        logger.info("Browser is started.....");
        VWO_loginpage loginpage=new VWO_loginpage(DriverManager.getDriver());

        logger.info("Verifying the invalid credentials....");
        String error_msg= loginpage.VWO_login_with_invalidCred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("final assert verifications....");
        logger.info(error_msg);
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
}
