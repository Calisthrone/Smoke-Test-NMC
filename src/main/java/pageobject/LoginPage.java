package pageobject;

import locator.LoginLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SuperPage implements LoginLoc {

    public LoginPage(WebDriver driver) {super(driver);}

    // enter the username (email or phone number)
    public LoginPage enterUsername(String username) {
        enterText(false, usernameFieldLocator, username, true);
        return this;
    }

    // enter the password
    public HomePage enterPassword(String password) {
        enterText(false, passwordFieldLocator, password, false);
        clickOn(loginButtonLocator);
        return new HomePage(driver);
    }
}