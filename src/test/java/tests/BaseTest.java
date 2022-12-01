package tests;

import core.DriverManager;
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
        Thread.sleep(3000);
        driver = DriverManager.getInstance().setDriver();
        driver.get("https://practicesoftwaretesting.com/#/");
        softAssert = new SoftAssert();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }


}
