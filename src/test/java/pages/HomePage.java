package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homePageUrl = "https://demo.nopcommerce.com/";
    public String homePageTitle = "nopCommerce demo store";

    public By registerButton = By.xpath("//a[contains(text(),'Register')]");
    public By loginButton = By.xpath("//a[contains(text(),'Log in')]");


}
