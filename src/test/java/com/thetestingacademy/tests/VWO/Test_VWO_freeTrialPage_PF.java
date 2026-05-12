package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageFactory.VWO.VWO_freeTrialPage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_VWO_freeTrialPage_PF extends CommonToAllTest {
    private static final Logger log= LogManager.getLogger(Test_VWO_freeTrialPage_PF.class);
    @Test
    public void Test_VWO_freeTrialPage_PF(){
        log.info("Starting browser....");
        log.info("Calling method from VWO_freetRialPage_PF class....");
        VWO_freeTrialPage_PF freeTrialPage=new VWO_freeTrialPage_PF(DriverManager.getDriver());
        log.info("Getting error message ....");
        String err_msg=freeTrialPage.VWO_feeTrialPage_PF(PropertiesReader.readKey("freeTrial_email"));
        log.info("Validating error message....");
        Assert.assertEquals(err_msg,PropertiesReader.readKey("freeTrial_error"));
        log.info("Error message is validated successfully....");

    }
}
