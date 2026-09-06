package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest2 extends TestBase{

//    HomePage homePage;
//
//    @BeforeMethod(description = "Load the Homepage of the website")
//    public void setup(){
//        homePage=new HomePage(CHROME);
//    }

    @Test(description = "Verifies with valid user is able to login to application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {

        assertEquals( homePage.goToLoginPage().doLoginWIth(user.getEmailAddress(), user.getPassword()).getUserName(),"John Scott");

        //System.out.println(userName);

    }
}
