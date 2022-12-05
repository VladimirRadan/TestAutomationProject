package tests;

import io.qameta.allure.*;
import listeners.TestListener;
import model.LoginUserModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginHeroku;
import utils.Utils;

import java.util.List;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest{


    LoginHeroku login;

    @BeforeMethod
    public void localSetup(){
        login = new LoginHeroku(driver);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Epic login")
    @Story("Login user story")
    @Description("Verifying if user is logged in - Expected: User is successfully logged in")
    public void loginUserTest(){
        driver.get("https://the-internet.herokuapp.com/login");
        login.loginUserHeroku("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(login.isUserLoggedIn());
    }


    @Test(description = "Login user with invalid credentials")
    public void loginWithInvalidCredentialsTest(){
        List<LoginUserModel> list = Utils.getDataFromJson();
        for (int i = 0; i < list.size(); i++) {
            login.loginUserHeroku(list.get(i).getUsername(), list.get(i).getPassword());
            softAssert.assertTrue(login.isErrorMessagePresent());
        }
        softAssert.assertAll();
    }




}
