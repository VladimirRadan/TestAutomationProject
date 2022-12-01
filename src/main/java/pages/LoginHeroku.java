package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHeroku extends BasePage{

    private static final Logger logger = LogManager.getLogger(LoginHeroku.class.getName());

    private By myAccountNavBar = By.cssSelector("a[title='My Account']");
    private By navbarLoginOption = By.xpath("//a[text()='Login']");
    private By loginEmailField= By.cssSelector("#input-email");
    private By loginPasswordField= By.cssSelector("#input-password");
    private By loginButton = By.cssSelector("input[type='submit']");
    private By labelMyAccount = By.xpath("//h2[text()='My Account']");

    private By usernameField = By.cssSelector("input[name='username']");
    private By passwordField= By.cssSelector("input[name='password']");
    private By loginBtn = By.className("radius");

    private By errorMessage = By.cssSelector(".flash.error");

    private By actualText = By.id("flash");

    public LoginHeroku(WebDriver driver) {
        super(driver);
    }

    public void loginUserHeroku(String username, String password){
        typeIn(usernameField, username);
        typeIn(passwordField, password);
        clickOnElement(loginBtn);
    }


    public boolean isUserLoggedIn(){
        String expectedText = "You logged into a secure area!";
        String actualArray[] = getElement(actualText).getText().split("(?<=!)");
        String actualText = actualArray[0];
        return actualText.equals(expectedText);
    }




}
