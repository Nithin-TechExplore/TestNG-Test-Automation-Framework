package com.ui.listeners;

import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Properties;

import static com.constants.Env.QA;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private static int currentAttempt=1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS)
        {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
