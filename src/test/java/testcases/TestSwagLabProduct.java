package testcases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginSwagLabPage;
import pages.SwagLabProductPage;
import utilities.DriverSetup;

public class TestSwagLabProduct extends DriverSetup {

    LoginSwagLabPage loginSwagLabPage = new LoginSwagLabPage();
    SwagLabProductPage swagLabProductPage = new SwagLabProductPage();

    @BeforeMethod
    public void navigateToProductPage(){
        getDriver().get(loginSwagLabPage.loginPageURL);
        loginSwagLabPage.doLogin("standard_user", "secret_sauce");
    }

    @Test(description = "Test product page Add to cart button")
    @Description("Allure Description Test product page Add to cart button")
    public void testAddTCartButton(){
        swagLabProductPage.clickOnElement(swagLabProductPage.addToCartButton);
        swagLabProductPage.addScreenShot("Add product to cart");
        Assert.assertEquals(swagLabProductPage.getCurrentCartItemCount(), "1");
    }

    @Test
    public void testRemoveCartItemButton(){
        //swagLabProductPage.clickOnElement(swagLabProductPage.addToCartButton);
        swagLabProductPage.clickOnElement(swagLabProductPage.removeCartItemButton);
        swagLabProductPage.addScreenShot("Remove product from cart");
        Assert.assertTrue(swagLabProductPage.isElementVisible(swagLabProductPage.addToCartButton));
        Assert.assertFalse(swagLabProductPage.isElementVisible(swagLabProductPage.removeCartItemButton));
    }







}
