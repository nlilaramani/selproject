package com.sel.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;

    private By userRegistrationLink=By.partialLinkText("User Registration");
    private By testPopupLink=By.partialLinkText("Frame Sample");

    public LandingPage(WebDriver driver){
        this.driver=driver;
        driver.get("https://nlilaramani.github.io");
    }

    public UserProfilePage clickUserRegistrationLink(){
        driver.findElement(userRegistrationLink).click();
        return new UserProfilePage(driver);
    }

    public void clickTestPopupLink(){
        driver.findElement(testPopupLink).click();
        //return new UserProfilePage(driver);
    }

}
