package tests;

import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login;
import pages.Register;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest{


    Register register;
    Login login;

    @BeforeMethod
    public void localSetup(){
        register = new Register(driver);
        login = new Login(driver);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registerUserTest(){
        String expectedUrl = "https://practicesoftwaretesting.com/#/accountfdewqf";
        register.goToRegisterPage()
                .registerUser();
        login.loginUser(register.getUsername(), register.getPassword());

        softAssert.assertTrue(register.isUserRegistered());
        softAssert.assertEquals(register.getCurrentUrl(), expectedUrl);
        softAssert.assertAll();
    }

    @Test
    public void registerVerifyUserIsRegistered(){
       register.verifyWelcomePageProfileText()
               .verifyWelcomePageProfileText();
    }




}
