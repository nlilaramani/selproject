/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sel.test;


import java.time.Duration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author itexps
 */
public class UserProfileTest {
    
    public UserProfileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    WebDriver driver;
    @Before
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testProfile(){

        driver.get("https://nlilaramani.github.io");
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("Robert");
        driver.findElement(By.name("lname")).sendKeys("Daley");
        driver.findElement(By.id("username")).sendKeys("Rob");
        driver.findElement(By.className("pwd")).sendKeys("testpwd");
        driver.findElements(By.name("g")).get(0).click();
        WebElement e=driver.findElement(By.tagName("select"));
        Select s=new Select(e);
        s.selectByIndex(1);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[1]")).sendKeys("Name with xpath");
        //driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        
    }
    
    @Test
    public void testAlert() throws InterruptedException{

        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        
    }
    
    @Test
    public void testTabs(){

        String h1=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.google.com");
        String h2=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://www.ibm.com");
        String h3=driver.getWindowHandle();
        driver.switchTo().window(h1);
        driver.get("http://www.microsoft.com");
        driver.switchTo().window(h2);
        driver.findElement(By.name("q")).sendKeys("Selenium jobs");
    }
}
