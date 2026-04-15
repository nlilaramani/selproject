/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sel.test;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class HotmailLoginTest {
    
    public HotmailLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testLogin() throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.hotmail.com");
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("i0116")).clear();
        driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();
        //driver.wait(10000);
        Thread.sleep(10000);
        //driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("Sel@123!");
        driver.findElement(By.name("passwd")).submit();
    }

    @Test
    public void someTest() throws Exception{
        FileInputStream fs=new FileInputStream(new File("c:\\data\\login.xlsx"));
        Workbook wb=new XSSFWorkbook(fs);
        String un=wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        String pwd=wb.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.hotmail.com");
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("i0116")).clear();
        //driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("i0116")).sendKeys(un);
        driver.findElement(By.id("idSIButton9")).click();
        //driver.wait(10000);
        Thread.sleep(10000);
        //driver.findElement(By.name("passwd")).clear();
        //driver.findElement(By.name("passwd")).sendKeys("Sel@123!");
        driver.findElement(By.name("passwd")).sendKeys(pwd);
        driver.findElement(By.name("passwd")).submit();
        //driver.findElement(By.id("exampleInputEmail")).clear();
        //driver.findElement(By.id("exampleInputEmail")).sendKeys(un);
        fs.close();
    }
}
