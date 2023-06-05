package PageObjects;

import DataRepo.Vars;
import Locators.ProductLoc;
import Super.SuperPage;
import TestUtils.AddToCartUtil;
import org.openqa.selenium.WebDriver;

public class ProductPage extends SuperPage implements ProductLoc {

    public ProductPage(WebDriver driver) {super(driver);}

    AddToCartUtil addToCartUtil = new AddToCartUtil(driver);

    public ProductPage incQ_productpage() {
        clickOn(ProductLoc.plusButtonLocator);
        Vars.expectedQuantityToAdd ++;
        return this;
    }

    public ProductPage decQ_productpage() {
        clickOn(ProductLoc.minusButtonLocator);
        Vars.expectedQuantityToAdd --;
        return this;
    }

    public ProductPage addToCart_productPage() {
        clickOn(ProductLoc.addToCartButtonLocator);
        addToCartUtil.setAddToCartMessage();
        addToCartUtil.setActualAddedQuantity_productpage();
        Vars.expectedCartCount = Vars.expectedCartCount + Vars.actualQuantityToAdd;
        updateActualCartCount();
        return this;
    }
}