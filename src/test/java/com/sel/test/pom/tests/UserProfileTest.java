package com.sel.test.pom.tests;

import com.sel.test.pom.base.BaseTest;
import com.sel.test.pom.pages.LandingPage;
import com.sel.test.pom.pages.UserProfilePage;
import org.junit.jupiter.api.Test;

public class UserProfileTest extends BaseTest {
    @Test
    public void testUserProfile(){
        LandingPage landingPage=new LandingPage(driver);
        UserProfilePage userProfilePage=landingPage.clickUserRegistrationLink();
        userProfilePage.enterFirstName("Narendra");
        userProfilePage.enterLastName("Lilaramani");
        userProfilePage.enterUsername("narentest");
        userProfilePage.enterPassword("mytestpwd");
        userProfilePage.setGenderToMale();
        userProfilePage.setQualification("Masters");
    }
}
