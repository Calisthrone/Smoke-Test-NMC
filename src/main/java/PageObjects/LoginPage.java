package PageObjects;

import Locators.LoginLoc;
import Super.SuperPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SuperPage implements LoginLoc {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        enterText(false, usernameFieldLocator, username, true);
        return this;
    }

    // todo: return void (end of project)
    public HomePage enterPassword(String password) {
        enterText(false, passwordFieldLocator, password, false);
        clickOn(loginButtonLocator);
        return new HomePage(driver);
    }
}