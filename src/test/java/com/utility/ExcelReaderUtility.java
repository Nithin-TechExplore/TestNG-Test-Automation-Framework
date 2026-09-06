package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelReader()  {


        File xlsxFile=new File(System.getProperty("user.dir")+"//testData//loginData.xlsx");
        XSSFWorkbook xssfWorkbook= null;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        List<User> userList=new ArrayList<User>();
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        XSSFSheet xssfSheet=xssfWorkbook.getSheet("LoginTestData");
        Iterator<Row> rowIterator=xssfSheet.rowIterator();
        rowIterator.next();//skipping the column name
        while (rowIterator.hasNext())
        {
            row=rowIterator.next();
            emailAddressCell=row.getCell(0);
            passwordCell=row.getCell(1);
            User user=new User(emailAddressCell.toString(),passwordCell.toString());
            userList.add(user);

            System.out.println("emailAddressCell "+emailAddressCell);
            System.out.println("passwordCell "+passwordCell);
        }
        return userList.iterator();

    }
}
