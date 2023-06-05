package TestUtils;

import DataRepo.Vars;
import Locators.HomeLoc;
import Super.SuperPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartUtil extends SuperPage {

    public AddToCartUtil(WebDriver driver) {super(driver);}

    // This method must run as the first line when clicking on 'Add To Cart' button if you are coming from
    // another 'Add To Cart' operation.
    // This is because this quantity will be affected by previous addToCart operations.
    public void resetExpectedQuantityToAdd() {Vars.expectedQuantityToAdd = 1;}

    // This will return the locator of the plus and minus buttons of homepage according to location.
    public By getPlusButtonLocator(String location) {
        return By.xpath(HomeLoc.plusButtonLocatorHead + location + HomeLoc.plusButtonLocatorTail);
    }

    // // This will return the locator of the plus and minus buttons of homepage according to location.
    public By getMinusButtonLocator(String location) {
        return By.xpath(HomeLoc.minusButtonLocatorHead + location + HomeLoc.minusButtonLocatorTail);
    }

    public By getAddToCartLocator(String location) {
        return By.xpath(HomeLoc.addToCartButtonLocatorHead + location + HomeLoc.addToCartButtonLocatorTail);
    }

    private By getAddedQuantityLocator(String location) {
        return By.xpath(HomeLoc.addedQuantityLocatorHead + location + HomeLoc.addedQuantityLocatorTail);
    }

    public void setActualAddedQuantity(String location) {
        waitForVisibilityOf(getAddedQuantityLocator(location));
        Vars.actualQuantityToAdd = Integer.parseInt(driver.findElement(getAddedQuantityLocator(location))
                .getAttribute("value"));
    }

    public void setAddToCartMessage() {
        sleepThread(1);
        waitForVisibilityOf(HomeLoc.successfulAddToCartLocator);
        Vars.addToCartMessage = driver.findElement(HomeLoc.successfulAddToCartLocator).getAttribute("textContent");
    }
}