package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    private static final Logger logger = LogManager.getLogger(Login.class.getName());

    By emailField = By.cssSelector("input[data-test='email']");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("input[data-test='login-submit']");


    public Login(WebDriver driver) {
        super(driver);
    }

    @Step("Logging in user")
    public Login loginUser(String username, String password){
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }


}
