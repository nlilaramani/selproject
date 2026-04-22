/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sel.test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
        
        //FileInputStream fs=new FileInputStream(new File("c:\\data\\login.xlsx"));
        //Workbook wb=new XSSFWorkbook(fs);
        //String un=wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        //driver.findElement(By.id("exampleInputEmail")).clear();
        //driver.findElement(By.id("exampleInputEmail")).sendKeys(un);
        //fs.close();

    }

    @Test
    public void testTimeouts() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        // Set implicit wait for 2 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("adder")).click();
        // Wait for 5 seconds
        //Thread.sleep(5000); Not a good idea
        driver.findElement(By.id("box0")).click();
        driver.findElement(By.id("reveal")).click();
        //Thread.sleep(5000);
        WebElement element=driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d->element.isDisplayed());
        if(element.isDisplayed() && element.isEnabled()) {
            element.sendKeys("Hello");
        }
        if(element.isSelected()){

        }
    }

    @Test
    public void testAlert() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
        // Dismiss the alert
        String text=driver.switchTo().alert().getText();
        System.out.println("Alert Text:"+text);
        //driver.switchTo().alert().dismiss(); // Click on cancel button
        driver.switchTo().alert().accept(); // Click on ok button
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5})
    public void testParameterized(int num){
        System.out.println("Number is "+num);
    }

    @ParameterizedTest
    @CsvFileSource(resources="/profiletest.csv",numLinesToSkip=1)
    public void testProfile(String firstName,String lastName, String uname, String pwd, String gender){
        WebDriver driver=new ChromeDriver();
        driver.get("https://nlilaramani.github.io");
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).clear();
        //driver.findElement(By.id("fname")).sendKeys("Robert");
        driver.findElement(By.id("fname")).sendKeys(firstName);
        //driver.findElement(By.name("lname")).sendKeys("Daley");
        driver.findElement(By.name("lname")).sendKeys(lastName);
        driver.findElement(By.id("username")).sendKeys("Rob");
        driver.findElement(By.className("pwd")).sendKeys("testpwd");
        driver.findElements(By.name("g")).get(0).click();
        WebElement e=driver.findElement(By.tagName("select"));
        Select s=new Select(e);
        s.selectByIndex(1);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//input[1]")).sendKeys("Name with xpath");
        //driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }

    @ParameterizedTest
    @CsvSource(value={"Robert,Ill,ril,123","Paul,Hardy,phardy,222"})
    public void testProfile1(String firstName,String lastName, String uname, String pwd){
        WebDriver driver=new ChromeDriver();
        driver.get("https://nlilaramani.github.io");
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).clear();
        //driver.findElement(By.id("fname")).sendKeys("Robert");
        driver.findElement(By.id("fname")).sendKeys(firstName);
        //driver.findElement(By.name("lname")).sendKeys("Daley");
        driver.findElement(By.name("lname")).sendKeys(lastName);
        driver.findElement(By.id("username")).sendKeys("Rob");
        driver.findElement(By.className("pwd")).sendKeys("testpwd");
        driver.findElements(By.name("g")).get(0).click();
        WebElement e=driver.findElement(By.tagName("select"));
        Select s=new Select(e);
        s.selectByIndex(1);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//input[1]")).sendKeys("Name with xpath");
        //driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
}
