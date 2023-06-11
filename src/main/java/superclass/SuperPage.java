package superclass;

import data.Vars;
import locator.CartLoc;
import locator.HomeLoc;
import locator.SuperLoc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.CartPage;

import java.time.Duration;

public class SuperPage implements SuperLoc {

    public WebDriver driver;

    public SuperPage(WebDriver driver) {this.driver = driver;}

    // ============================== Create Element Helper Methods ============================== \\

    // create an element that is clickable (buttons)
    protected WebElement createClickableElement(By locator) {

        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // create all other types of elements
    public WebElement createElement(By locator) {

        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ============================== Element Interactions Helper Methods ============================== \\

    // clicks on any element (no need to trigger waits, already implemented in the createClickableElement method
    protected void clickOn(By locator) {createClickableElement(locator).click();}

    // enter text in any kind of fields
    // clearText -> if you want to clear the text field before entering text
    // clickEnter -> if you want to mimic pressing enter after entering a text
    protected void enterText(boolean clearText, By locator, String text, boolean clickEnter) {
        WebElement textField = createElement(locator);
        if (clearText) textField.clear();
        textField.sendKeys(text);
        if (clickEnter) textField.sendKeys(Keys.RETURN);
    }

    // ============================== Wait & Thread Helper Methods ============================== \\

    // sleeps the thread, takes in double, where 1 is one second and 0.5 is half second and so on
    protected void sleepThread(double seconds) {
        try {
            long waitTimeInSeconds = (long) (1000 * seconds);
            Thread.sleep(Duration.ofMillis(waitTimeInSeconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // wait for the visibility of any object
    public void waitForVisibilityOf(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // will return true when the Loading Animation is gone (the animation in cart related waits)
    public boolean loadingMaskDisappeared() {
        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.attributeContains(loadingMaskLocator, "style", "none"));
    }

    // ============================== Get Actual Data Helper Methods ============================== \\

    // update the actual cart count at any page on condition the cart icon is visible
    public void updateActualCartCount() {

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.attributeToBe(HomeLoc.customerNameLocator, "textContent", "Mohamed"));

        WebElement cartCounter = createElement(HomeLoc.cartCounterLocator);
        Vars.actualCartCount = Integer.parseInt(cartCounter.getAttribute("textContent"));
    }

    public void updateActualCartValue() {
        WebElement cartValueElement = createElement(CartLoc.actualCartValueLocator);
        String priceString = cartValueElement.getAttribute("textContent")
                .replaceAll("[^\\d.]", ""); // remove spaces and currency signs.
        Vars.actualCartValue = Double.parseDouble(priceString);
    }

    // increase the expected quantity by 1 (triggered when clicking + button anywhere)
    public void increaseExpectedQuantityToAdd() {Vars.expectedQuantityToAdd ++;}

    // decrease the expected quantity by 1 (triggered when clicking - button anywhere)
    public void decreaseExpectedQuantityToAdd() {Vars.expectedQuantityToAdd --;}

    // ============================== Access From Anywhere Helper Methods ============================== \\

    public void gotoMainPage() {clickOn(mainPageLocator);}

    // this will go to the cart page from any page on the app where the cart icon is visible
    public CartPage gotoCartPage() {
        clickOn(cartLocator);
        return new CartPage(driver);}
}