package pageobject;

import data.Vars;
import locator.CartLoc;
import locator.HomeLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class CartPage extends SuperPage implements CartLoc {

    public CartPage(WebDriver driver) {super(driver);}

    // if cart is not empty -> delete all items from cart
    public CartPage purgeCart() {

        updateActualCartCount();

        // if cart is actually empty -> set the expected quantity -> zero
        if (Vars.actualCartCount == 0) {
            Vars.expectedCartCount = 0;
        }

        // if cart is not empty -> start the purge process.
        if (Vars.actualCartCount != 0) {

            gotoCartPage();
            waitForVisibilityOf(HomeLoc.switchShippingLocator);
            clickOn(CartLoc.deleteAllItemsButtonLocator);

            sleepThread(1); // stable without wait, but sometimes confirm message are too fast to see.

            clickOn(CartLoc.confirmDeleteButtonLocator);

            // when empty cart message appears, then it is safe to update actualCartCount
            waitForVisibilityOf(CartLoc.emptyCartLocator);
            Vars.expectedCartCount = 0;

            sleepThread(1); // had one time 'NumberFormatException' because too fast to read the read element.

            updateActualCartCount();

            gotoMainPage();
        }
        return this;
    }
}
