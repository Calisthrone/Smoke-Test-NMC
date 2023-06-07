package locator;

import org.openqa.selenium.By;

public interface HomeLoc {

    String homepageURL_AR = "https://www.nahdionline.com/ar";

    By acceptCookiesButtonLocator = By.xpath("//a[@aria-label='allow cookies']");
    By loginButtonLocator = By.xpath("//li[@class='authorization-link']");

    By cartCounterLocator = By.xpath("//span[@class='counter-number']");
    By customerNameLocator = By.xpath("//span[@class='customer-name']/span");

    By switchShippingLocator = By.xpath("//div[@id=\"switcher-shipping-tabs\"]");
    By storePickupLocator = By.xpath(" //a[@id=\"switcher-tab-label-ispu-title\"]");

    By searchFieldLocator = By.xpath("//input[@id=\"search\"]");
    By noResultLocator = By.xpath("//div[@class=\"no-results\"]");
    String expectedNoResultText = "لا توجد منتجات للاستعلام";
    By firstSearchResultLocator = By.xpath("//ol[@class=\"ais-Hits-list\"]");
    By allSearchResultsSelector = By.cssSelector("ol.ais-Hits-list li.ais-Hits-item");

    // this will be used in generating the locators for getPlusButtonLocator(String location) method.
    String plusButtonLocatorHead = "//*[@id=\"instant-search-results-container\"]/div/div/ol/li[";
    String plusButtonLocatorTail = "]/div/div/div[1]/div[2]/div[4]/div/form/div[1]/span[2]";

    // this will be used in generating the locators for getMinusButtonLocator(String location) method.
    String minusButtonLocatorHead = "//*[@id=\"instant-search-results-container\"]/div/div/ol/li[";
    String minusButtonLocatorTail = "]/div/div/div[1]/div[2]/div[4]/div/form/div[1]/span[1]";

    // this will be used in generating the locators for getAddToCartButtonLocator(String location) method.
    String addToCartButtonLocatorHead = "//*[@id=\"instant-search-results-container\"]/div/div/ol/li[";
    String addToCartButtonLocatorTail = "]/div/div/div[1]/div[2]/div[4]/div/form/div[2]/button";

    // this will be used in generating the locators for getAddedQuantityLocator(String location) method.
    String addedQuantityLocatorHead = "//*[@id=\"instant-search-results-container\"]/div/div/ol/li[";
    String addedQuantityLocatorTail = "]/div/div/div[1]/div[2]/div[4]/div/form/div[1]/input";

    By successfulAddToCartLocator = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[3]/div/div/div[1]");

    // Parts of item to click locators
    String itemToClickHead = "//*[@id=\"instant-search-results-container\"]/div/div/ol/li[";
    String itemToClickTail = "]/div/div/div[1]/div[1]/a/img";
}