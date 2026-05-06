package com.sel.test.pom.tests;

import com.sel.test.pom.base.BaseTest;
import com.sel.test.pom.pages.LandingPage;
import com.sel.test.pom.pages.UserProfilePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandingTest extends BaseTest {
    @Test
    void testLauchUserProfile(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.clickUserRegistrationLink();
        UserProfilePage userProfilePage=new UserProfilePage(driver);
        assertEquals("User Profile",userProfilePage.getTitle());
    }
}
