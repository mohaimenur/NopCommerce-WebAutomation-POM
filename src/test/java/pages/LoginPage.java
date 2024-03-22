package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    //public String loginPageTitle = "nopCommerce demo store. Login";
    public String loginPageURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    public By email = By.xpath("//input[@id='Email']");
    public By password = By.xpath("//input[@id='Password']");
    public By rememberMeCheckBox = By.xpath("//input[@id='RememberMe']");
    public By forgotPasswordButton = By.xpath("//a[contains(text(),'Forgot password?')]");
    public By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public By confirmLoginMsg = By.xpath("//h2[contains(text(),'Welcome to our store')]");
    public By errorLoginMsg = By.xpath("//div[@class='message-error validation-summary-errors']");

    public String confirmLoginText = "Welcome to our store";
    public String errorLoginText = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";

///// Registration email and password is not saved

    public void demoLogin(){
        writeOnElement(email,"test@gmail.com");
        writeOnElement(password,"123456");
        clickOnElement(rememberMeCheckBox);
        //clickOnElement(forgotPasswordButton);
        clickOnElement(loginButton);




    }






}
