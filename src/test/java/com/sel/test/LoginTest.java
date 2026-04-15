package com.sel.test;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginTest {

    @Parameterized.Parameters
    public static Collection getData() throws Exception{
        Collection<Object[]> data=new ArrayList<>();
        /*data.add(new Object[]{"abc","abc"});
        data.add(new Object[]{"xyz","xyz"});
        return data;*/
        FileInputStream fs=new FileInputStream(new File("c:\\data\\login.xlsx"));
        Workbook wb=new XSSFWorkbook(fs);
        String un=wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        String pwd=wb.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        data.add(new Object[]{un,pwd});
        un=wb.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        pwd=wb.getSheetAt(0).getRow(2).getCell(1).getStringCellValue();
        data.add(new Object[]{un,pwd});
        fs.close();
        return data;
    }

    String name;
    String value;
    public LoginTest(String name,String value){
        this.name=name;
        this.value=value;
    }

    WebDriver driver;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testLogin(){
        System.out.println(this.name+" "+this.value);
    }

    @Test
    public void testHotamilLogin() throws InterruptedException{
        //WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://www.hotmail.com"); //Got to hotmail home page
        driver.findElement(By.partialLinkText("Sign in")).click(); // click on signin link
        //driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("i0116")).sendKeys(name);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.currentThread().sleep(5000);
        //driver.wait(5000);
        WebElement e=driver.findElement(By.name("passwd"));
        e.clear();
        //e.sendKeys("Sel@123!");
        e.sendKeys(value);
        e.submit();
    }


}
