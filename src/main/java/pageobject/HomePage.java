package pageobject;

import data.DataUtils;
import data.Vars;
import locator.HomeLoc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import superclass.SuperPage;

import java.util.Objects;

public class HomePage extends SuperPage implements HomeLoc {

    // override superclass constructor
    public HomePage(WebDriver driver) {super(driver);}

    // get the url of the homepage
    public HomePage gotoHomepage() {
        driver.get(homepageURL_AR);
        return this;
    }

    // accept the cookies message (appears once)
    public HomePage acceptCookies() {
        clickOn(acceptCookiesButtonLocator);
        return this;
    }

    // go to login page to enter the user credentials
    public LoginPage gotoLoginPage() {
        clickOn(loginButtonLocator);
        return new LoginPage(driver);
    }

    // prepare random product before search (will generate a new Product object and set its variables in Vars)
    public HomePage prepareRandomProduct() {
        DataUtils.randomizeProduct();
        return this;
    }

    // make a search query for any product (works on any page where the search bar is visible)
    // in case the search is intended to return no results (eg: invalid words) set validSearch -> false
    public HomePage searchFor(String searchText, Boolean validSearch) {

        enterText(true, searchFieldLocator, searchText, true);

        if (validSearch) {
            // this will only run if we want to run a valid search
            setResultsList();
            setResultsCount();
            setItemLocation(Vars.sku);
        }
        return this;
    }

    // step up the item quantity (only compatible with products shown on homepage). location -> location in search results
    public HomePage incQ_homepage(String location) {
        clickOn(getPlusButtonLocator(location));
        increaseExpectedQuantity();
        return this;
    }

    // step down the item quantity (only compatible with products shown on homepage). location -> location in search results
    public HomePage decQ_homepage(String location) {
        clickOn(getMinusButtonLocator(location));
        decreaseExpectedQuantity();
        return this;
    }

    // add product to cart (only compatible with products shown on homepage)
    public HomePage addToCart_homepage(String location) {
        clickOn(getAddToCartButtonLocator(location));
        setAddToCartMessage();
        setActualQuantityToAdd(location);
        updateExpectedCartCount();
        updateExpectedCartValue();
        updateActualCartCount();
        return this;
    }

    public HomePage switchToStorePickup() {
        clickOn(HomeLoc.storePickupLocator);
        return this;
    }

    public ProductPage clickOnItem(String location) {
        clickOn(getItemToClickLocator(location));
        return new ProductPage(driver);
    }

    // =========================================================================== \\
    // ============================== HELPER METHOD ============================== \\

    // set the searchResultsList with the list of search results element list
    private void setResultsList() {
        waitForVisibilityOf(HomeLoc.allSearchResultsSelector);
        Vars.searchResultElementList = driver.findElements(HomeLoc.allSearchResultsSelector); // contains all results
    }

    // set the searchResultsCount with the number of search results found
    private void setResultsCount() {Vars.searchResultsCount = Vars.searchResultElementList.size();}

    // generate the plusButtonLocator according to the location of the item you want to increase quantity of
    private By getPlusButtonLocator(String location) {
        return By.xpath(HomeLoc.plusButtonLocatorHead
                + location
                + HomeLoc.plusButtonLocatorTail);
    }

    // generate the minusButtonLocator according to the location of the item you want to decrease quantity of
    private By getMinusButtonLocator(String location) {
        return By.xpath(HomeLoc.minusButtonLocatorHead
                + location
                + HomeLoc.minusButtonLocatorTail);
    }

    // increase the expected quantity by 1
    private void increaseExpectedQuantity() {Vars.expectedQuantityToAdd ++;}

    // decrease the expected quantity by 1
    private void decreaseExpectedQuantity() {Vars.expectedQuantityToAdd --;}

    // generates the addToCart button locator according to the location of the item you want to add
    private By getAddToCartButtonLocator(String location) {
        return By.xpath(HomeLoc.addToCartButtonLocatorHead
                + location
                + HomeLoc.addToCartButtonLocatorTail);
    }

    // set the addToCartMessage -> the pop-up message that appears after adding an item to cart
    private void setAddToCartMessage() {
        sleepThread(1);
        waitForVisibilityOf(HomeLoc.successfulAddToCartLocator);
        Vars.addToCartMessage = driver.findElement(HomeLoc.successfulAddToCartLocator).getAttribute("textContent");
    }

    // generate the locator of addedQuantityLocator (the number which is located between + and - buttons in homepage)
    private By getAddedQuantityLocator(String location) {
        return By.xpath(HomeLoc.addedQuantityLocatorHead
                + location
                + HomeLoc.addedQuantityLocatorTail);
    }

    // set the actual quantity of the item added to the cart
    private void setActualQuantityToAdd(String location) {
        waitForVisibilityOf(getAddedQuantityLocator(location));
        Vars.actualQuantityToAdd = Integer.parseInt(driver.findElement(getAddedQuantityLocator(location))
                .getAttribute("value"));
    }

    // update the expected cart count
    private void updateExpectedCartCount() {Vars.expectedCartCount = Vars.expectedCartCount + Vars.actualQuantityToAdd;}

    private void updateExpectedCartValue() {Vars.expectedCartValue = Vars.expectedCartValue + (Vars.price * Vars.expectedQuantityToAdd);}

    // get the item you want to click according to the location
    private By getItemToClickLocator(String location) {
        return By.xpath(HomeLoc.itemToClickHead
                + location
                + HomeLoc.itemToClickTail);
    }

    public void setItemLocation(String sku) {

        waitForVisibilityOf(allSearchResultsSelector); // wait fot all results to show up

        for (int i = 1; i <= Vars.searchResultsCount; i++) {

            // each search result locator is //li[@class='ais-Hits-item'][#!#]/div. replace #!# with the index start with 1
            By singleSearchResultLocator = By.xpath("//li[@class='ais-Hits-item'][" + i + "]/div");

            // each iteration we create the corresponding element in search results
            WebElement searchResult = createElement(singleSearchResultLocator);

            // if the created element attributes == sku -> will use the index of the element to click buttons
            if (Objects.equals(searchResult.getAttribute("data-sku"), sku)) {
                Vars.sku = String.valueOf(i);
            }
        }
    }
}