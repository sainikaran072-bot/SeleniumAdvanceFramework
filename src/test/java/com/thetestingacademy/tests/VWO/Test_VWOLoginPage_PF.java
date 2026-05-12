package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageFactory.VWO.VWO_loginpage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_VWOLoginPage_PF extends CommonToAllTest {
    private static final Logger log=LogManager.getLogger(Test_VWOLoginPage_PF.class);
    @Test
    public void test_VWOLoginPage_WithInvalidCred_PF() {

        log.info("starting browser.....");
        log.info("Calling method from VWO_loginpage_PF class....");
        VWO_loginpage_PF loginPage_PF = new VWO_loginpage_PF(DriverManager.getDriver());
        log.info("Generating invalid cred error message");
        String err_msg=loginPage_PF.VWO_LoginWithInvalidCred_PF(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        log.info("Validating error message......");
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_message"));
        log.info("Error message validated successfully....");

    }
}