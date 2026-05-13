package com.sel.pw.pages;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PwUserProfileSteps {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    private PwLandingPage pwLandingPage;
    private PwUserProfilePage pwUserProfilePage;
    @Given("pw user is on the landing page")
    public void pwuserIsOnLandingPage(){
        pwLandingPage=new PwLandingPage(page);
    }
    @When("pw user clicks on  user registration link")
    public void pwuserClicksOnUserRegistrationLink(){
        pwUserProfilePage=pwLandingPage.clickUserRegistrationLink();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("pw user profile page is displayed")
    public void pwuserProfilePageIsDisplayed(){
        System.out.println(pwUserProfilePage.getTitle());
        Assert.assertTrue(pwUserProfilePage.getTitle().equalsIgnoreCase("User Profile"));
    }
    @Before
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();

        page = context.newPage();
    }

    @After
    public void teardown() {

        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
