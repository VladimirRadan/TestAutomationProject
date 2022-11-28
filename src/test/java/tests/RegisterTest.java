package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;
import pages.Register;

public class RegisterTest extends BaseTest{


    Register register;
    Login login;

    @BeforeMethod
    public void localSetup(){
        register = new Register(driver);
        login = new Login(driver);
    }

    @Test
    public void registerUserTest(){
        String expectedUrl = "https://practicesoftwaretesting.com/#/account";
        register.goToRegisterPage()
                .registerUser();
        login.loginUser(register.getUsername(), register.getPassword());
        Assert.assertTrue(register.isUserRegistered());
        Assert.assertEquals(register.getCurrentUrl(), expectedUrl);
    }




}
