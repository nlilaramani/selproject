/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sel.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author itexps
 */
public class SetupTest {
    
    public SetupTest() {
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
    @Test
    public void testHello() {
        System.out.println("Hello Test");
    }
    
    @Test
    public void testSeleniumSetup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        //driver.findElement(By.name("q")).sendKeys("Selenium jobs");
        driver.findElement(By.name("q")).sendKeys("Selenium jobs"+Keys.ENTER);
        //WebDriverManager.chromedriver().setup();
        driver.get("https://sweetshop.vivrichards.co.uk/login");
        driver.findElement(By.id("exampleInputEmail")).sendKeys("Narendra");
        driver.findElement(By.id("exampleInputEmail")).clear();
        driver.findElement(By.id("exampleInputEmail")).sendKeys("nrlilaramani@hotmail.com");
       // driver.findElement(By.id("exampleInputEmail")).submit();
        
        FileInputStream fs=new FileInputStream(new File("c:\\data\\login.xlsx"));
        Workbook wb=new XSSFWorkbook(fs);
        String un=wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        driver.findElement(By.id("exampleInputEmail")).clear();
        driver.findElement(By.id("exampleInputEmail")).sendKeys(un);
        fs.close();

    }
}
