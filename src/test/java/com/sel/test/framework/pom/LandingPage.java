package com.sel.test.framework.pom;

import com.sel.test.pom.pages.UserProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    @FindBy(partialLinkText = "User Registration")
    WebElement userRegistrationLink;
    @FindBy(partialLinkText = "Frame Sample")
    WebElement fameSample;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        driver.get("https://nlilaramani.github.io");
        PageFactory.initElements(driver,this);
    }

    public UserProfilePage getUserProfilePage(){
        userRegistrationLink.click();
        return new UserProfilePage(this.driver);
    }



}
