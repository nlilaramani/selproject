package com.sel.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class KatalonGeneratedYserProfileTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testUserProfile() throws Exception {
        driver.get("https://nlilaramani.github.io/");
        driver.findElement(By.linkText("User Registration")).click();
        driver.findElement(By.id("fname")).click();
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("Narendra");
        driver.findElement(By.name("lname")).clear();
        driver.findElement(By.name("lname")).sendKeys("Lilaramani");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("narentest");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("g")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Educational Qualification:'])[1]/following::select[1]")).click();
        new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Educational Qualification:'])[1]/following::select[1]"))).selectByVisibleText("Masters");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Educational Qualification:'])[1]/following::textarea[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Educational Qualification:'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Educational Qualification:'])[1]/following::textarea[1]")).sendKeys("My comments");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Katalon Recorder is recording ...'])[1]/preceding::h1[1]")).click();
        try {
            assertEquals("User Profile successfully saved.", driver.findElement(By.xpath("//h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
