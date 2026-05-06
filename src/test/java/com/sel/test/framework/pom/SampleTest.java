package com.sel.test.framework.pom;

import com.sel.test.pom.base.BaseTest;
import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {
    @Test
    public void testSample(){
        LandingPage p=new LandingPage(driver);
        p.getUserProfilePage();
    }

}
