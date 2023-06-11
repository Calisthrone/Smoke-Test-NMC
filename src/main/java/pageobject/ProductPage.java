package pageobject;

import com.google.errorprone.annotations.Var;
import data.Vars;
import locator.HomeLoc;
import locator.ProductLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends SuperPage implements ProductLoc {

    public ProductPage(WebDriver driver) {super(driver);}

    // step up the quantity of an item
    public ProductPage incQ_productpage() {
        sleepThread(0.25); // optimal wait not to skip clicking
        clickOn(ProductLoc.plusButtonLocator);
        increaseExpectedQuantityToAdd(); // increase expected quantity to add with each + button click
        return this;
    }

    public ProductPage decQ_productpage() {
        sleepThread(0.25); // optimal wait not to skip clicking
        clickOn(ProductLoc.minusButtonLocator);
        decreaseExpectedQuantityToAdd(); // decrease expected quantity to add with each - button click
        return this;
    }

    public ProductPage addToCart_productPage() {
        sleepThread(0.25); // optimal wait not to skip clicking
        clickOn(ProductLoc.addToCartButtonLocator);
        setAddToCartMessage(); // waits for the pop-up message that appears when adding an item to cart
        setActualAddedQuantity(); // update the actual added quantity (read from web elements)
        updateExpectedCartCount(); // update expected cart count (calculated)
        updateExpectedCartValue(); // update expected cart value (calculated)
        updateActualCartCount(); // update actual cart count (read from web elements)
        return this;
    }

    // ============================================================================ \\
    // ============================== HELPER METHODS ============================== \\

    // set the add to cart with the text that appears in the pop-up message (for assertion)
    private void setAddToCartMessage() {
        sleepThread(1);
        waitForVisibilityOf(HomeLoc.successfulAddToCartLocator);
        Vars.addToCartMessage = driver.findElement(HomeLoc.successfulAddToCartLocator).getAttribute("textContent");
    }

    // read the number between the + and - buttons in the same moment the addToCart button is clicked
    private void setActualAddedQuantity() {
        waitForVisibilityOf(ProductLoc.addedQuantityLocator);
        Vars.actualQuantityToAdd = Integer.parseInt(driver.findElement(ProductLoc.addedQuantityLocator)
                .getAttribute("value"));
    }

    // update the expected cart count
    private void updateExpectedCartCount() {Vars.expectedCartCount = Vars.expectedCartCount + Vars.actualQuantityToAdd;}

    // update the expected cart value
    private void updateExpectedCartValue() {Vars.expectedCartValue = Vars.expectedCartValue + (Vars.price * Vars.expectedQuantityToAdd);}

}