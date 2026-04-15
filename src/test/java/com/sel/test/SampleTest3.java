package com.sel.test;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;

import static org.junit.Assert.*;

public class SampleTest3 {
    WebDriver driver;
    @Before
    public void testSetup(){
        driver=new ChromeDriver();
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        //WebElement wd=driver.findElement(By.id("123"));
        //WebElement revealed;
        //wait.until(d->wd.isDisplayed());
    }

    @Test
    public void testNavigation(){
        //WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("http://www.ibm.com");
        driver.navigate().to("http://www.microsoft.com");
        driver.navigate().back();;
        driver.navigate().forward();
        driver.navigate().refresh();
        Workbook book=new XSSFWorkbook();
    }

    @Test
    public void testWindows(){
        driver.get("https://www.google.com");
        String str=driver.getTitle();

        System.out.println(str);
        String str1=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        java.util.Set<String> handles=driver.getWindowHandles();
        for(String s:handles){
            System.out.println(s);
        }
        driver.switchTo().window(str1);
        driver.manage().window().maximize();

    }

    @Test
    public void testFacebook(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.cssSelector("input.inputtext")).sendKeys("Softwarfe ");
        //WebDriverWait wait=new WebDriverWait();
        //driver.findElement(By.id("email")).sendKeys("a@a.com");
        //driver.findElement(By.id("pass")).sendKeys("abc");
        //driver.findElement(By.name("login")).click();
        //driver.findElement(By.id("email")).sendKeys("a@a.com");
    }

}
