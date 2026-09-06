package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest3 extends TestBase{

//    HomePage homePage;
//
//    @BeforeMethod(description = "Load the Homepage of the website")
//    public void setup(){
//        homePage=new HomePage(CHROME);
//    }

    @Test(description = "Verifies with valid user is able to login to application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "CSVDataProvider")
    public void loginTest(User user) {

       assertEquals( homePage.goToLoginPage().doLoginWIth(user.getEmailAddress(), user.getPassword()).getUserName(),"John Scott");

        //System.out.println(userName);

    }
}
