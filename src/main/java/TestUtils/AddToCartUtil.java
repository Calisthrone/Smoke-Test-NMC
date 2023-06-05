package TestUtils;

import DataRepo.Vars;
import Locators.HomeLoc;
import Locators.ProductLoc;
import Super.SuperPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartUtil extends SuperPage {

    public AddToCartUtil(WebDriver driver) {super(driver);}

    // This will return the locator of the plus and minus buttons of homepage according to location.
    public By getPlusButtonLocator(String location) {
        return By.xpath(HomeLoc.plusButtonLocatorHead
                + location
                + HomeLoc.plusButtonLocatorTail);
    }

    // // This will return the locator of the plus and minus buttons of homepage according to location.
    public By getMinusButtonLocator(String location) {
        return By.xpath(HomeLoc.minusButtonLocatorHead
                + location
                + HomeLoc.minusButtonLocatorTail);
    }

    public By getAddToCartLocator(String location) {
        return By.xpath(HomeLoc.addToCartButtonLocatorHead
                + location
                + HomeLoc.addToCartButtonLocatorTail);
    }

    private By getAddedQuantityLocator(String location) {
        return By.xpath(HomeLoc.addedQuantityLocatorHead
                + location
                + HomeLoc.addedQuantityLocatorTail);
    }

    public void setActualAddedQuantity_homepage(String location) {
        waitForVisibilityOf(getAddedQuantityLocator(location));
        Vars.actualQuantityToAdd = Integer.parseInt(driver.findElement(getAddedQuantityLocator(location))
                .getAttribute("value"));

    }

    public void setActualAddedQuantity_productpage() {
        waitForVisibilityOf(ProductLoc.addedQuantityLocator);
        Vars.actualQuantityToAdd = Integer.parseInt(driver.findElement(ProductLoc.addedQuantityLocator)
                .getAttribute("value"));
    }

    public void setAddToCartMessage() {
        sleepThread(1);
        waitForVisibilityOf(HomeLoc.successfulAddToCartLocator);
        Vars.addToCartMessage = driver.findElement(HomeLoc.successfulAddToCartLocator).getAttribute("textContent");
    }

    public By getItemToClickLocator(String location) {
        return By.xpath(HomeLoc.itemToClickHead
                + location
                + HomeLoc.itemToClickTail);
    }


}