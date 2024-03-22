package testcases;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginSwagLabPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLoginSwagLab extends DriverSetup {
    LoginSwagLabPage loginSwag = new LoginSwagLabPage();

    @BeforeMethod
    public void navigateToLoginPage(){
        getDriver().get(loginSwag.loginPageURL);

    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginWithValidCredentials(){
        loginSwag.writeOnElement(loginSwag.username,"standard_user");
        loginSwag.writeOnElement(loginSwag.password,"secret_sauce");
        loginSwag.clickOnElement(loginSwag.loginButton);
        loginSwag.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginSwag.afterLogin);
    }

    @Test
    public void testLoginWithoutPassword(){
        loginSwag.writeOnElement(loginSwag.username,"standard_user");
        //loginSwag.writeOnElement(loginSwag.password,"secret_sauce");
        loginSwag.clickOnElement(loginSwag.loginButton);
        loginSwag.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), loginSwag.errorloginPageURL);
        Assert.assertEquals(loginSwag.getElementText(loginSwag.error),loginSwag.errorMsg);

    }

    @Test
    public void testLoginWithoutUsername(){
        loginSwag.writeOnElement(loginSwag.username, "");
        loginSwag.writeOnElement(loginSwag.password, "secret_sauce");
        loginSwag.clickOnElement(loginSwag.loginButton);
        loginSwag.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginSwag.errorloginPageURL);
        Assert.assertEquals(loginSwag.getElementText(loginSwag.error), "Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithoutCredentials(){
        loginSwag.writeOnElement(loginSwag.username, "");
        loginSwag.writeOnElement(loginSwag.password, "");
        loginSwag.clickOnElement(loginSwag.loginButton);
        loginSwag.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginSwag.errorloginPageURL);
        Assert.assertEquals(loginSwag.getElementText(loginSwag.error), "Epic sadface: Username is required");
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String username, String password, String error_msg){
        loginSwag.writeOnElement(loginSwag.username, username);
        loginSwag.writeOnElement(loginSwag.password, password);
        loginSwag.clickOnElement(loginSwag.loginButton);
        loginSwag.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginSwag.getElementText(loginSwag.error), error_msg);
    }





}
