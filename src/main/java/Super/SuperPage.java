package Super;

import DataRepo.Vars;
import Locators.HomeLoc;
import Locators.SuperLoc;
import com.google.errorprone.annotations.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuperPage implements SuperLoc {

    public WebDriver driver;

    public SuperPage(WebDriver driver) {this.driver = driver;}

    // temporary verification & debugging method
    // todo: remove by the end of project

    public static void printCurrentVars(String whereIsCalled) {
        System.out.println("This current status of Vars is called from: " + whereIsCalled);
        System.out.println("searchText = " + Vars.searchText);
        System.out.println("addToCartMessage = " + Vars.addToCartMessage);
        System.out.println("actualCartCount = " + Vars.actualCartCount);
        System.out.println("expectedCartCount = " + Vars.expectedCartCount);
        System.out.println("expectedQuantityToAdd = " + Vars.expectedQuantityToAdd);
        System.out.println("actualQuantityToAdd = " + Vars.actualQuantityToAdd);
        System.out.println("searchResultsCount = " + Vars.searchResultsCount);
    }

    // ============================== Create Element Helper Methods ============================== \\

    // creates an element that is clickable (wait for it to be clickable)
    protected WebElement createClickableElement(By locator) {

        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement createElement(By locator) {

        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ============================== Element Interactions Helper Methods ============================== \\

    protected void clickOn(By locator) {createClickableElement(locator).click();}

    // clearText -> if you want to clear the text field before entering text
    // clickEnter -> if you want to mimic pressing enter after entering a text
    protected void enterText(boolean clearText, By locator, String text, boolean clickEnter) {
        WebElement textField = createElement(locator);
        if (clearText) textField.clear();
        textField.sendKeys(text);
        if (clickEnter) textField.sendKeys(Keys.RETURN);
    }

    // ============================== Wait & Thread Helper Methods ============================== \\

    protected void sleepThread(long seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForVisibilityOf(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // ============================== Get Actual Data Helper Methods ============================== \\

    public void updateActualCartCount() {

        // wait for the real customer name to appear. when it appears, the cart counter is 100% updated.
        WebElement customerName = createElement(HomeLoc.customerNameLocator);
        // todo: change the value to -> customer.firstName
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.attributeToBe(customerName, "textContent", "محمد"));

        WebElement cartCounter = createElement(HomeLoc.cartCounterLocator);
        Vars.actualCartCount = Integer.parseInt(cartCounter.getAttribute("textContent"));
    }

    // ============================== Access From Anywhere Helper Methods ============================== \\

    public void gotoMainPage() {clickOn(mainPageLocator);}

    public void gotoCartPage() {clickOn(cartLocator);}
}