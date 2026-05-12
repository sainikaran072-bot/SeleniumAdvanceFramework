package com.thetestingacademy.DDT;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.VWO.improved_POM.VWO_loginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DataDrivenTesting {

    @Test(dataProvider = "getData")
    public void test_negative_vwo_login(){
        VWO_loginpage loginpage=new VWO_loginpage(DriverManager.getDriver());
        String error_msg= loginpage.VWO_login_with_invalidCred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
}
