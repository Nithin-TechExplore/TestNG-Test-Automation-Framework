package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest1 extends TestBase{

//    HomePage homePage;
//
//    @BeforeMethod(description = "Load the Homepage of the website")
//    public void setup(){
//        homePage=new HomePage(CHROME);
//    }

    @Test(description = "Verifies with valid user is able to login to application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "ExcelDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginTest(User user) {
//       Logger logger= LoggerUtility.getLogger(this.getClass());
//       logger.info("Started my Login Test");

        assertEquals( homePage.goToLoginPage().doLoginWIth(user.getEmailAddress(), user.getPassword()).getUserName(),"John Scott1");

        //System.out.println(userName);

    }
}
