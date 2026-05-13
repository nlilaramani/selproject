package com.sel.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {
    private WebDriver driver;
    private final By title=By.xpath("//h1[2]");
    private final By firstName=By.id("fname");
    private final By lastName=By.name("lname");
    private final By username=By.id("username");
    private final By password=By.className("pwd");
    private final By gender=By.name("g");
    private final By qualification=By.tagName("select");

    public UserProfilePage(WebDriver driver){
        this.driver=driver;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public UserProfilePage enterFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
        return this;
    }

    public void enterLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void enterUsername(String uname){
        driver.findElement(username).sendKeys(uname);
    }
    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void setGenderToMale(){
        driver.findElements(gender).get(0).click();
    }
    public void setGenderToFemale(){
        driver.findElements(gender).get(1).click();
    }
    public void setQualification(String q){
        driver.findElement(qualification).sendKeys(q);
    }
    public void submitPage(){
        driver.findElement(lastName).submit();
    }

}
