package com.sel.pw.pages;

import com.microsoft.playwright.Page;

public class PwUserProfilePage {
    private final Page page;
    private final String title="//h1[2]";
    public PwUserProfilePage(Page page){
        this.page=page;
    }
    public String getTitle(){
        return page.locator(title).innerText();
        //return driver.findElement(title).getText();
    }

}
