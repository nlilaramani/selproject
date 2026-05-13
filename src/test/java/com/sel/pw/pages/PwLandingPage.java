package com.sel.pw.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PwLandingPage {
    private final Page page;

    private final String userRegistrationLink="";
    //=By.partialLinkText("User Registration");
    private final String testPopupLink="";
    //=By.partialLinkText("Frame Sample");

    public PwLandingPage(Page page){
        this.page=page;
        this.page.navigate("https://nlilaramani.github.io");
        //driver.get("https://nlilaramani.github.io");
    }

    public PwUserProfilePage clickUserRegistrationLink(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("User Registration")).click();
        //page.locator("User Registration").click();
        //driver.findElement(userRegistrationLink).click();
        //driver.findElement(userRegistrationLink).click();
        return new PwUserProfilePage(page);
    }

    public void clickTestPopupLink(){
        page.locator("Frame Sample").click();
        //return new UserProfilePage(driver);
    }

}
