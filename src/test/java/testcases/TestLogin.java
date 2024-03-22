package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void navigateToLoginPage(){
        getDriver().get(loginPage.loginPageURL);
    }

    @Test
    public void testLoginWithValidCredentials(){
        loginPage.demoLogin();
        Assert.assertTrue(loginPage.isElementVisible(loginPage.errorLoginMsg));
        Assert.assertEquals(loginPage.getElementText(loginPage.errorLoginMsg),loginPage.errorLoginText);

    }


}
