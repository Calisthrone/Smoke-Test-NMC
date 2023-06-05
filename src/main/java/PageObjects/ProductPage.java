package PageObjects;

import Locators.ProductLoc;
import Super.SuperPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends SuperPage implements ProductLoc {

    public ProductPage(WebDriver driver) {super(driver);}

    public ProductPage incQ_productpage() {

        return this;
    }

    public ProductPage decQ_productpage() {

        return this;
    }

    public ProductPage addToCart_productPage() {

        return this;
    }
}
