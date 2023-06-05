package PageObjects;

import DataRepo.Vars;
import Locators.CartLoc;
import Super.SuperPage;
import org.openqa.selenium.WebDriver;

public class CartPage extends SuperPage implements CartLoc {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // checks the actual cart count if empty or not.
    public CartPage preparePurge() {

        updateActualCartCount();

        // if cart is actually empty -> set the expected quantity -> zero
        if (Vars.actualCartCount == 0) {
            Vars.expectedCartCount = 0;

            // todo: remove these debugging lines (end of project)
            System.out.println("============================== Message Start ==============================");
            System.out.println("CartPage.class | @Test: preparePurge");
            System.out.println("===== If this message appears, then the purgeCart method will not execute. =====");
            System.out.println("===== Because the actual cart count is == 0, so no need to purge the cart. =====");
            System.out.println("actual cart count = " + Vars.actualCartCount);
            System.out.println("expected cart count = " + Vars.expectedCartCount);
            System.out.println("============================== Message End ==============================\n\n");
        }
        return this;
    }

    // if cart is not empty -> delete all items from cart
    public CartPage purgeCart() {

        if (Vars.actualCartCount != 0) {

            gotoCartPage();

            // todo: (end of project)
            // todo: switchShippingLocator appears faster than couponLocator, assess the stability of switchShipping.
            // todo: couponLocator was working 100% but slow. Will decide if switchShipping is stable later on.
            // the delete all button is 100% clickable after the visibility of coupon box (now switch shipping box)
            //waitForVisibilityOf(couponLocator);
            waitForVisibilityOf(switchShippingLocator);
            clickOn(deleteAllItemsButtonLocator);

            sleepThread(1); // stable without wait, but sometimes confirm message are too fast to see.

            clickOn(confirmDeleteButtonLocator);

            // when empty cart message appears, then it is safe to update actualCartCount
            waitForVisibilityOf(emptyCartLocator);
            Vars.expectedCartCount = 0;

            sleepThread(1); // had one time 'NumberFormatException' because too fast to read the read element.

            updateActualCartCount();

//            // todo: remove these debugging lines (end of project)
//            System.out.println("============================== Message Start ==============================");
//            System.out.println("CartPage.class | @Test: purgeCart");
//            System.out.println("actual cart count = " + Vars.actualCartCount);
//            System.out.println("expected cart count = " + Vars.expectedCartCount);
//            System.out.println("============================== Message End ==============================\n\n");

            gotoMainPage();
        }
        return this;
    }
}
