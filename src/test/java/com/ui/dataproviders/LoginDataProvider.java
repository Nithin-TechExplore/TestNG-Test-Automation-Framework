package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.*;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException{
        Gson gson=new Gson();
        File testDataFile=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
        FileReader fileReader=new FileReader(testDataFile);
        TestData data=gson.fromJson(fileReader,TestData.class);
        List<Object[]> dataToReturn=new ArrayList<Object[]>();
        for(User user: data.getData())
        {
            dataToReturn.add(new Object[]{user});
        }

        return dataToReturn.iterator();

    }

    @DataProvider(name="CSVDataProvider")
    public Iterator<User> csvDataProvider()
    {
       return CSVReaderUtility.readCSVData("loginData");

    }

    @DataProvider(name="ExcelDataProvider")
    public Iterator<User> excelDataProvider()
    {
        return ExcelReaderUtility.readExcelReader();

    }
}
