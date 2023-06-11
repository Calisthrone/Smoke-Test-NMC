package locator;

import org.openqa.selenium.By;

public interface CartLoc {
    By deleteAllItemsButtonLocator = By.xpath("//button[@value='empty_cart']");
    By confirmDeleteButtonLocator = By.xpath("//button[contains(@class,'action-accept')]");
    By emptyCartLocator = By.xpath("//div[@class='cart-empty']");

    By actualCartValueLocator = By.cssSelector("#cart-totals > div > table > tbody > tr.grand.totals > td > strong > span");

    By proceedToCheckOutButtonLocator = By.xpath("//button[@data-role='proceed-to-checkout']");
    By currentMapLocationButtonLocator = By.xpath("//button[@class='ispu-by-my-current-location-button']");

    // only for validation of page load
    By pickupLocationsContainerLocator = By.xpath("//ul[@class='pickup-locations']");

    By continueToShippingButtonLocator = By.xpath("//button[@data-role='opc-continue']");
    By cashOnDeliveryLocator = By.xpath("//label[@for='cashondelivery']");
    By placeOrderButtonLocator = By.xpath("//button[contains(@data-bind,'placeOrderAction')]");

    By orderNumberLocator = By.xpath("//div[@class='order-number-wrap']/p/span/");
}