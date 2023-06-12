package pageobject;

import data.Vars;
import locator.CartLoc;
import locator.HomeLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class CartPage extends SuperPage implements CartLoc {

    public CartPage(WebDriver driver) {super(driver);}

    // if cart is not empty -> delete all items from cart
    public void purgeCart() {

        updateActualCartCount();

        // if cart is actually empty -> set the expected quantity -> zero
        if (Vars.actualCartCount == 0) {
            Vars.expectedCartCount = 0;
        }

        // if cart is not empty -> start the purge process.
        if (Vars.actualCartCount != 0) {

            gotoCartPage();
            waitForVisibilityOf(HomeLoc.switchShippingLocator);
            clickOn(deleteAllItemsButtonLocator);

            sleepThread(1); // stable without wait, but sometimes confirm message are too fast to see.

            clickOn(confirmDeleteButtonLocator);

            // when empty cart message appears, then it is safe to update actualCartCount
            waitForVisibilityOf(emptyCartLocator);
            Vars.expectedCartCount = 0;

            sleepThread(1); // had one time 'NumberFormatException' because too fast to read the read element.

            updateActualCartCount();

            gotoMainPage();
        }
    }

    // calculate cart value before assertion
    public void calculateCartValue() {
        updateActualCartValue();
    }

    // first step executed in cart in order to start making an order
    public CartPage proceedToCheckout() {
        clickOn(proceedToCheckOutButtonLocator);
        return this;
    }

    // select the nearest store to the actual location of user to pick the order from, after clicking the ..
    // .. map button, the driver should wait for the appearance of the suggested location container
    public CartPage selectCurrentLocationOnMap() {
        clickOn(currentMapLocationButtonLocator);
        waitForVisibilityOf(pickupLocationsContainerLocator);
        return this;
    }

    // proceed to select the payment method
    public CartPage clickContinueToPayment() {
        clickOn(continueToShippingButtonLocator);
        return this;
    }

    // select cash on delivery
    public CartPage chooseCashOnDelivery() {
        clickOn(cashOnDeliveryLocator);
        return this;
    }

    // create the order
    public CartPage clickPlaceOrder() {
        if (loadingMaskDisappeared()) {
            clickOn(placeOrderButtonLocator);
        }
        return this;
    }

    // read the order number and store it in Vars for assertion
    public void setOrderNumber() {
        waitForVisibilityOf(orderNumberLocator);
        Vars.orderNumber = driver.findElement(orderNumberLocator).getAttribute("textContent");
        System.out.println("Order Number = " + Vars.orderNumber);
    }
}