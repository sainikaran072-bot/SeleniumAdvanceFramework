package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Description("sample TC-1")
    @Test
    public void sampleTest0(){
        System.out.println("Hello0");
        Assert.assertTrue(true);
    }

    @Description("Sample TC-2")
    @Test
    public void sampleTest1(){
        System.out.println("Hello1");
        Assert.assertTrue(true);
    }



}
