/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sel.test;


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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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

@Test
  public void testSearchTest2() throws Exception {

    WebDriver driver=new ChromeDriver();
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("java jobs");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("rcnt")).click();
    try {
      assertEquals("java jobs - Google Search", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  private StringBuffer verificationErrors = new StringBuffer();
}
