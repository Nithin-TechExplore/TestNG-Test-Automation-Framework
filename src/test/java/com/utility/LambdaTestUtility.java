package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    private static final String HUB_URL="https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<DesiredCapabilities>();


    public static WebDriver intializeLambdaTestSession(String browser,String testName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "holesheshgiri");
        ltOptions.put("accessKey", "LT_jpNmQjUDKxx94U0nbr5hAhfjr0ArrBUM5kREetBEBw6deIy");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "latest");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver= null;
        try {
            driverLocal.set(new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driverLocal.set(driverLocal.get());

        return driverLocal.get();


    }

    public static void quitSession(){
        if(driverLocal.get()!=null)
        {
            driverLocal.get().quit();
        }
    }

}
