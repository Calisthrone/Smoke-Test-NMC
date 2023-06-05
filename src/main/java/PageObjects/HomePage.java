package PageObjects;

import DataRepo.Vars;
import Locators.HomeLoc;
import Super.SuperPage;
import TestUtils.AddToCartUtil;
import TestUtils.SearchUtil;
import org.openqa.selenium.WebDriver;

public class HomePage extends SuperPage implements HomeLoc {

    public HomePage(WebDriver driver) {super(driver);}

    SearchUtil searchUtil = new SearchUtil(driver);
    AddToCartUtil addToCartUtil = new AddToCartUtil(driver);

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

    // for invalid search, no results will be displayed, so we don't set the results list and results count.
    public HomePage searchFor(String searchText, Boolean validSearch) {
        enterText(true, searchFieldLocator, searchText, false);
        if (validSearch) { // only perform when we are searching for real items.
            searchUtil.setResultsList();
            searchUtil.setResultsCount();
        }
        return this;
    }

    public HomePage incQ_homepage(String location) {
        clickOn(addToCartUtil.getPlusButtonLocator(location));
        Vars.expectedQuantityToAdd ++;
        return this;
    }

    public HomePage decQ_homepage(String location) {
        clickOn(addToCartUtil.getMinusButtonLocator(location));
        Vars.expectedQuantityToAdd --;
        return this;
    }

    public HomePage addToCart_homepage(String location) {
        clickOn(addToCartUtil.getAddToCartLocator(location));
        addToCartUtil.setAddToCartMessage();
        addToCartUtil.setActualAddedQuantity(location);
        Vars.expectedCartCount = Vars.expectedCartCount + Vars.actualQuantityToAdd;
        updateActualCartCount();

        printCurrentVars("After addToCart_homepage(String location)");
        return this;
    }

    public ProductPage clickOnItem(String location) {


        return new ProductPage(driver);
    }
}