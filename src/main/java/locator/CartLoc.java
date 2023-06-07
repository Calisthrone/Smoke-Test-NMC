package locator;

import org.openqa.selenium.By;

public interface CartLoc {
    By deleteAllItemsButtonLocator = By.xpath("//button[@value='empty_cart']");
    By confirmDeleteButtonLocator = By.xpath("//button[contains(@class,'action-accept')]");
    By emptyCartLocator = By.xpath("//div[@class='cart-empty']");
}