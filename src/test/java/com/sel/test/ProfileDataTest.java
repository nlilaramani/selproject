package com.sel.test;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ProfileDataTest {

    @Parameterized.Parameters
    public static Collection getTestData() throws Exception{
        Collection<Object[]> data=new ArrayList<>();
        // Read data from external file
        // and then add it to the collection
        FileInputStream fs=new FileInputStream(new File("c:\\data\\profiledata.xlsx"));
        Workbook wb=new XSSFWorkbook(fs);
        String fname=wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        String lname=wb.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        data.add(new Object[]{fname,lname});
        fname=wb.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        lname=wb.getSheetAt(0).getRow(2).getCell(1).getStringCellValue();
        data.add(new Object[]{fname,lname});
        fs.close();
        //data.add(new Object[]{"Robert","Illiffe"});
        //data.add(new Object[]{"Paul","Hardy"});
        return data;
    }
    // External data properties
    private String firstName;
    private String lastName;

    public ProfileDataTest(String fname,String lname){
        this.firstName=fname;
        this.lastName=lname;
    }



    // Common Webdriver interface
    WebDriver driver;

    @Before
    public void setUp(){
        // Open Chrome browser
        driver=new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Setup implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(){
        driver.quit(); // Close the browser
    }

    @Test
    public void testProfile(){
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
