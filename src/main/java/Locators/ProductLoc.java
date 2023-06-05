package Locators;

import org.openqa.selenium.By;

public interface ProductLoc {

    By plusButtonLocator = By.xpath("//button[contains(@class,'icon-plus')]");
    By minusButtonLocator = By.xpath("//button[contains(@class,'icon-minus-solid')]");
    By addToCartButtonLocator = By.xpath("//button[@id='product-addtocart-button']");

    By addedQuantityLocator = By.xpath("//input[@id=\"qty\"]");
}
