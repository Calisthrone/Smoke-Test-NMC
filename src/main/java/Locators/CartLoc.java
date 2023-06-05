package Locators;

import org.openqa.selenium.By;

public interface CartLoc {
    By deleteAllItemsButtonLocator = By.xpath("//button[@value='empty_cart']");
    By confirmDeleteButtonLocator = By.xpath("//button[contains(@class,'action-accept')]");
    By switchShippingLocator = By.xpath("//*[@id=\"switcher-shipping-tabs\"]");
    By emptyCartLocator = By.xpath("//div[@class='cart-empty']");
}