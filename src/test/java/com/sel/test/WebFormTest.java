package com.sel.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest {
    @Test
    public void testWebForm(){
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String val=driver.findElement(By.name("my-disabled")).getAttribute("value");
        System.out.println("Disabled val:"+val);
        val=driver.findElement(By.name("my-readonly")).getAttribute("value");
        System.out.println("Read val:"+val);
        driver.findElement(By.name("my-select")).sendKeys("Two");
        //driver.findElement(By.id("my-options")).sendKeys("New York");
        WebElement element=driver.findElement(By.id("my-check-1"));
        System.out.println("Selected:"+element.isSelected());
        System.out.println("Checked:"+element.getAttribute("checked"));
        element=driver.findElement(By.id("my-check-2"));
        System.out.println("Selected:"+element.isSelected());
        System.out.println("Checked:"+element.getAttribute("checked"));
        driver.findElement(By.id("my-radio-2")).click();
        val=driver.findElement(By.name("my-range")).getAttribute("value");
        System.out.println(val);
        element=driver.findElement(By.name("my-range"));
        assertTrue(driver.getPageSource().contains("Web form"));



    }
}
