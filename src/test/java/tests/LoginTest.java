package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginHeroku;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest{


    LoginHeroku login;

    @BeforeMethod
    public void localSetup(){
        login = new LoginHeroku(driver);
    }

    @Test
    public void loginUserTest(){
        driver.get("https://the-internet.herokuapp.com/login");
        login.loginUserHeroku("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(login.isUserLoggedIn());
    }


}
