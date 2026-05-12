package com.thetestingacademy.DDT;

import com.thetestingacademy.utilExcels.UtilExcel;
import org.testng.annotations.Test;

public class TestDataDrivenViaApachePOI {
    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void test_VWOLogin(String email, String password){
        System.out.println("eamil:"+ email);
        System.out.println("password:"+ password);
    }
}
