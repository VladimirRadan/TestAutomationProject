package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    By emailField = By.cssSelector("input[data-test='email']");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("input[data-test='login-submit']");


    public Login(WebDriver driver) {
        super(driver);
    }

    public Login loginUser(String username, String password){
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }


}
