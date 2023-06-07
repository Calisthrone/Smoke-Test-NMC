package pageobject;

import locator.LoginLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SuperPage implements LoginLoc {

    public LoginPage(WebDriver driver) {super(driver);}

    public LoginPage enterUsername(String username) {
        enterText(false, usernameFieldLocator, username, true);
        return this;
    }

    public HomePage enterPassword(String password) {
        enterText(false, passwordFieldLocator, password, false);
        clickOn(loginButtonLocator);
        return new HomePage(driver);
    }
}