package PageObjects;

import Locators.HomeLoc;
import Super.SuperPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends SuperPage implements HomeLoc {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage gotoHomepage() {
        driver.get(homepageURL_AR);

        return this;
    }

    public HomePage acceptCookies() {
        clickOn(acceptCookiesButtonLocator);

        return this;
    }

    // todo: return void (end of project)
    public LoginPage gotoLoginPage() {
        clickOn(loginButtonLocator);

        return new LoginPage(driver);
    }
}