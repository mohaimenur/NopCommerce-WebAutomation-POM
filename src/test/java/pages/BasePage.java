package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebDriverWait wait;
    public WebElement getElement(By locator){
        return waitForElementPresence(locator);
    }

    public void clickOnElement(By locator){
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean isElementVisible(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public WebElement waitForElementPresence(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectWithVisibleText(By selectLocator, String visibleText){
        Select select = new Select(getElement(selectLocator));
        select.selectByVisibleText(visibleText);
    }


//    public void hover(By locator){
//        Actions actions = new Actions(getDriver());
//        actions.clickAndHold(getElement(locator)).build().perform();
//    }

//    public void clickOnNumberButton(List<WebElement> elements, int position){
//        elements.get(position - 1).click();
//    }

//    public void listItem(List<WebElement> elements, String visibleText){
//        for (WebElement element : elements){
//            if (element.getText().equals(visibleText)){
//                element.click();
//                break;
//            }
//        }
//    }

//    public Alert waitForAlert(){
//        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        return alert;
//    }

//    public void alertAccept(){
//        Alert alert = waitForAlert();
//        alert.accept();
//    }
//
//    public void alertAcceptText(String value){
//        Alert alert = waitForAlert();
//        alert.sendKeys(value);
//        alert.accept();
//    }
//
//    public void alertDismiss(){
//        Alert alert = waitForAlert();
//        alert.dismiss();
//    }

//    static Faker faker = new Faker(new Locale("en-US"));
//
//    public String emailGenerate () {
//        return faker.bothify("????##@mail.com");
//    }
//
//    public String firstNameGenerate() {
//        return faker.name().firstName();
//    }
//
//    public String lastNameGenerate() {
//        return faker.name().lastName();
//    }
//
//    public String phoneNumberGenerate() {
//        return faker.numerify("###-###-####");
//    }














    public void addScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }




}
