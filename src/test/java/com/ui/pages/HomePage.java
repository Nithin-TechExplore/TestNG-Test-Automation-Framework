package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.QA;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_LINK_LOCTOR=By.xpath("//*[contains(text(),'Sign in')]");

    public HomePage(WebDriver driver) {
        super(driver);
        maximizeWindow();
        goToWebsite(JSONUtility.readJSON(QA));
    }

    public HomePage(Browser driver)
    {
        super(driver);
        maximizeWindow();
        //goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
        goToWebsite(JSONUtility.readJSON(QA));
    }

    public HomePage(Browser driver,boolean headless)
    {
        super(driver,headless);
        maximizeWindow();
        //goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
        goToWebsite(JSONUtility.readJSON(QA));
    }


    public LoginPage goToLoginPage()
    {
        clickOn(SIGN_IN_LINK_LOCTOR);
        LoginPage loginPage=new LoginPage(getDriver());
        return loginPage;
    }






}
