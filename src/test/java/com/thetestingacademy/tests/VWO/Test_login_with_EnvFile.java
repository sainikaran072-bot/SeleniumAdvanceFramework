package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM.VWO_loginpage;
import com.thetestingacademy.utils.EnvUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_login_with_EnvFile {
    @Test
    public void test_vwo_loginInWithInvalidCred() {
        //Driver manage code
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        //page class code
        VWO_loginpage login_page= new VWO_loginpage(driver);
        String error_text=login_page.VWO_login_with_invalidCred(EnvUtil.getUsername(),EnvUtil.getPassword());

        //Assertions
        assertThat(error_text).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }
}
