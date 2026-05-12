package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.PageObjectModel.VWO.normal_POM.VWO_loginpage;
import com.thetestingacademy.utils.EnvUtil;
import com.thetestingacademy.utils.YamlReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_login_with_yamlFile {

    @Test
    public void test_vwo_loginInWithInvalidCred() {
        YamlReader yamlReader=new YamlReader("config.yaml");
        //Driver manage code
        WebDriver driver = new ChromeDriver();
        driver.get(yamlReader.getString("project1.url"));

        //page class code
        VWO_loginpage login_page= new VWO_loginpage(driver);
        String error_text=login_page.VWO_login_with_invalidCred(yamlReader.getString("project1.invalid_username"),yamlReader.getString("project1.invalid_password"));

        //Assertions
        assertThat(error_text).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_text,yamlReader.getString("project1.error_message"));
        driver.quit();
    }
}
