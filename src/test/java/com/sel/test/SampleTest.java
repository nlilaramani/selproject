/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class SampleTest {
    
    public SampleTest() {
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
    public void testSample(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // Navigate to ibm.com
        driver.get("http://www.ibm.com");
        driver.get("https://www.google.com/");
        //driver.findElement(By.name("q")).click();
        //driver.findElement(By.name("q")).clear();
        //driver.findElement(By.name("q")).sendKeys("java jobs");
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("About")).click();
    }
    
    @Test
    public void testNav(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.ibm.com");
        driver.get("https://www.google.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.close();

    }
    
    
}
