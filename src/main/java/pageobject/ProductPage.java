package pageobject;

import data.Vars;
import locator.ProductLoc;
import superclass.SuperPage;
import pagehelper.AddToCartHelper;
import org.openqa.selenium.WebDriver;

public class ProductPage extends SuperPage implements ProductLoc {

    public ProductPage(WebDriver driver) {super(driver);}

    AddToCartHelper addToCartHelper = new AddToCartHelper(driver);

    public ProductPage incQ_productpage() {
        sleepThread(1);
        clickOn(ProductLoc.plusButtonLocator);
        Vars.expectedQuantityToAdd ++;
        return this;
    }

    public ProductPage decQ_productpage() {
        sleepThread(1);
        clickOn(ProductLoc.minusButtonLocator);
        Vars.expectedQuantityToAdd --;
        return this;
    }

    public ProductPage addToCart_productPage() {
        sleepThread(1);
        clickOn(ProductLoc.addToCartButtonLocator);
        addToCartHelper.setAddToCartMessage();
        addToCartHelper.setActualAddedQuantity_productpage();
        Vars.expectedCartCount = Vars.expectedCartCount + Vars.actualQuantityToAdd;
        updateActualCartCount();
        return this;
    }
}