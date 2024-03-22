package pages;

import org.openqa.selenium.By;

public class LoginSwagLabPage extends BasePage{

    public String loginPageURL = "https://www.saucedemo.com";
    public By username = By.xpath("//input[@id='user-name']");
    public By password = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//input[@id='login-button']");
    public By error = By.xpath("//h3[@data-test='error']");
    public String errorMsg = "Epic sadface: Password is required";
    public String errorloginPageURL = "https://www.saucedemo.com/";

    public String afterLogin = "https://www.saucedemo.com/inventory.html";


    public void doLogin(String username_text, String password_text){
        writeOnElement(username, username_text);
        writeOnElement(password, password_text);
        clickOnElement(loginButton);
    }


}
