package com.sel.cuke;

import com.sel.test.pom.pages.LandingPage;
import com.sel.test.pom.pages.UserProfilePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserProfileSteps {
    WebDriver driver=new ChromeDriver();
    LandingPage landingPage;
    UserProfilePage userProfilePage;
    @Given("user is on the landing page")
    public void userIsOnLandingPage(){
        landingPage=new LandingPage(driver);
    }
    @When("user clicks on  user registration link")
    public void userClicksOnRegistrationLink(){
        userProfilePage=landingPage.clickUserRegistrationLink();
    }
    @Then("user profile page is displayed")
    public void userProfilePageIsDisplayed(){
        Assert.assertTrue(userProfilePage.getTitle().equalsIgnoreCase("User Profile"));
    }
    @And("user enters first name {string}")
    public void userEntersFirstName(String fname){
        userProfilePage.enterFirstName(fname);
    }
    @And ("user submits the page")
    public void submitUserProfilePage() throws InterruptedException {
        Thread.sleep(5000);
        userProfilePage.submitPage();
    }
    @Then ("success page is displayed ewqew")
    public void successPageDispalyed(){
        //User Profile successfully saved.
    }

    @Then("success page is displayed")
    public void successPageIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
       Assert.assertTrue(driver.findElement(By.xpath("//h1[1]")).getText().equalsIgnoreCase("User Profile successfully saved."));
    }

    @And("user enter last name {string}")
    public void userEnterLastName(String lname) {
        // Write code here that turns the phrase above into concrete actions
       userProfilePage.enterLastName(lname);
    }

    @Before
    public void setup() {
        System.out.println("Cucumber Setup()");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        System.out.println("Cucumber tearDown()");

        if(driver != null) {
            driver.quit();
        }
    }
}
