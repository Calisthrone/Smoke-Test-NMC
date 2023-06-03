package PageObjects;

import Locators.HomeLoc;
import Super.SuperPage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public HomePage searchFor(String searchText) {
        enterText(true, searchFieldLocator, searchText, false);
        return this;
    }
}