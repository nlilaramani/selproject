/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sel.test;

import io.github.bonigarcia.wdm.WebDriverManager;
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
public class aa1 {
    
    public aa1() {
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
    public void testUserProfile() throws InterruptedException{
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.get("https://www.advantageonlineshopping.com/");
         //Thread.sleep(5000);
    driver.findElement(By.id("menuUser")).click();
    //Thread.sleep(5000);
    driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
     //Thread.sleep(5000);
    driver.findElement(By.name("usernameRegisterPage")).clear();
    driver.findElement(By.name("usernameRegisterPage")).sendKeys("nrl111");
    driver.findElement(By.name("emailRegisterPage")).clear();
    driver.findElement(By.name("emailRegisterPage")).sendKeys("nrl111s@gmail.com");
    driver.findElement(By.name("passwordRegisterPage")).clear();
    driver.findElement(By.name("passwordRegisterPage")).sendKeys("Nrl@123");
    driver.findElement(By.name("confirm_passwordRegisterPage")).clear();
    driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Nrl@123");
    driver.findElement(By.name("first_nameRegisterPage")).clear();
    driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Guest");
    driver.findElement(By.name("last_nameRegisterPage")).clear();
    driver.findElement(By.name("last_nameRegisterPage")).sendKeys("User");
    driver.findElement(By.xpath("//div[@id='formCover']/div[3]/div/sec-view/div")).click();
    driver.findElement(By.name("countryListboxRegisterPage")).click();
    new Select(driver.findElement(By.name("countryListboxRegisterPage"))).selectByVisibleText("United States");
    driver.findElement(By.name("cityRegisterPage")).click();
    driver.findElement(By.name("cityRegisterPage")).clear();
    driver.findElement(By.name("cityRegisterPage")).sendKeys("Chicago");
    driver.findElement(By.name("addressRegisterPage")).click();
    driver.findElement(By.name("addressRegisterPage")).clear();
    driver.findElement(By.name("addressRegisterPage")).sendKeys("951 N Plum Grove Rd");
    driver.findElement(By.name("phone_numberRegisterPage")).clear();
    driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("8473509034");
    driver.findElement(By.name("state_/_province_/_regionRegisterPage")).clear();
    driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("IL");
    driver.findElement(By.name("postal_codeRegisterPage")).clear();
    driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("60173");
    driver.findElement(By.name("i_agree")).click();
    //driver.findElement(By.name("passwordRegisterPage")).click();
    driver.findElement(By.name("passwordRegisterPage")).clear();
    driver.findElement(By.name("passwordRegisterPage")).sendKeys("Nrl@123");
    driver.findElement(By.name("confirm_passwordRegisterPage")).clear();
    driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Nrl@123");
    driver.findElement(By.name("usernameRegisterPage")).click();
    driver.findElement(By.name("usernameRegisterPage")).clear();
    driver.findElement(By.name("usernameRegisterPage")).sendKeys("nrl111");
    driver.findElement(By.id("register_btnundefined")).click();
    }
    
    @Test
    public void testHotamilLogin() throws InterruptedException{
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://www.hotmail.com"); //Got to hotmail home page
        driver.findElement(By.partialLinkText("Sign in")).click(); // click on signin link
        driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.currentThread().sleep(5000);
        //driver.wait(5000);
        WebElement e=driver.findElement(By.name("passwd"));
        e.clear();
        e.sendKeys("Sel@123!");
        e.submit();
    }
    @Test
    public void testFacebookLogin() throws InterruptedException{
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://www.facebook.com"); //Got to hotmail home page
        driver.findElement(By.id("email")).sendKeys("abcxyz"); // click on signin link
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("email")).submit();
        driver.wait(10000);
        driver.close();
    }
    
     @Test
    public void testUserprofile(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://nlilaramani.github.io/");
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).sendKeys("Robert");
        driver.findElement(By.name("lname")).sendKeys("Illiffe");
        //driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.cssSelector("#username")).sendKeys("test");
        //driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.className("pwd")).sendKeys("password");
        driver.findElements(By.name("g")).get(0).click();
        driver.findElement(By.tagName("select")).sendKeys("Bachelors");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
       
        //driver.get("http://www.ibm.com");
        
        
    }
    
    @Test
    public void testopenTabs(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String w1=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
        String w2=driver.getWindowHandle();
        driver.switchTo().window(w1);
        driver.get("http://www.google.com");
        driver.switchTo().window(w2);
        driver.close();
    }
    
    @Test
    public void testAlert() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    
}
