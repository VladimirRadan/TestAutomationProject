package tests;

import core.DriverManager;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {


    WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = DriverManager.getInstance().setDriver();
        Thread.sleep(3000);
        //driver.get("https://practicesoftwaretesting.com/#/");
        softAssert = new SoftAssert();
        new Environment(driver).openBrowser();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
