package pages;

import model.RegisterUser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class Register extends BasePage{

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By dobField = By.cssSelector("input[formcontrolname='dob']");
    private By addressField = By.id("address");
    private By postCodeField = By.id("postcode");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryDropdown = By.id("country");
    private By phoneCodeField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.cssSelector(".form-group.mb-3+button");

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    private By goToRegisterFormLink = By.cssSelector("a[data-test='register-link']");

    private By myAccountPageTitle = By.cssSelector("h1[data-test='page-title']");
    private By myAccountMenuProfile = By.cssSelector("a[data-test='nav-profile']");

    private String username;
    private String password;

    public Register(WebDriver driver) {
        super(driver);
    }

    //fluent pattern
    public Register goToRegisterPage(){
        clickOnElement(signInLink);
        clickOnElement(goToRegisterFormLink);
        return this;
    }

    public Register registerUser(){
        RegisterUser registerUser = new RegisterUser();
        username = registerUser.getEmail();
        password = registerUser.getPassword();
        typeIn(firstNameField, registerUser.getFirstName());
        typeIn(firstNameField, registerUser.getFirstName());
        typeIn(lastNameField, registerUser.getLastName());
        typeIn(dobField, "1212");
        getElement(dobField).sendKeys(Keys.TAB);
        typeIn(dobField, "1999");
        typeIn(addressField, registerUser.getAddress());
        typeIn(postCodeField, registerUser.getPostCode());
        typeIn(cityField, registerUser.getCity());
        typeIn(stateField, registerUser.getState());
        selectCountry();
        typeIn(phoneCodeField, registerUser.getPhoneNumber());
        typeIn(emailField, username);
        typeIn(passwordField, password);
        scrollToMyElement(registerButton);
        clickOnElement(registerButton);
        Utils.waitForSeconds(2);
        return this;
    }

    private void selectCountry(){
        Select select = new Select(getElement(countryDropdown));
        select.selectByValue("RS");
    }

    public boolean isUserRegistered(){
        return matchesExpectedText(myAccountPageTitle, "My account") && matchesExpectedText(myAccountMenuProfile, "Profile");
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
