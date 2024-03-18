package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    private static String browserName = System.getProperty("browser","chrome"); //to run from console otherwise only = "chrome"

    private static final ThreadLocal<WebDriver> LOCAL_DRIVER =  new ThreadLocal<>(); //for parallel run one execution can not create an impact on another execution

    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get(); //getter method to get from localdriver

    }





    public static WebDriver createBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser not found! using the given name: " + browserName);
        }


//    }
//        switch (browserName.toLowerCase()) {
//            case "chrome":
//                return new ChromeDriver();
//
//            case "edge":
//                return new EdgeDriver();
//
//            case "firefox":
//                return new FirefoxDriver();
//
//            default:
//                throw new RuntimeException("Browser not Found! using given name: " + browserName);
//        }



        }

    @BeforeSuite
    public static synchronized void setBrowser(){
        WebDriver driver = createBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
    }

    @AfterSuite
    public static synchronized void quiteBrowser(){
        getDriver().quit();
    }







}
