package Test;

import Assert.Asserting;
import Super.SuperTest;
import org.testng.annotations.Test;

public class AddToCartTest extends SuperTest {

    // no need to search as we are coming from SearchTest. Will add to cart directly from homepage.
    @Test(priority = 1)
    public void addFromHomePage() {
        homePage
                .incQ_homepage("2")
                .incQ_homepage("2")
                .incQ_homepage("2")
                .decQ_homepage("2")
                .addToCart_homepage("2");

        Asserting.itemIsActuallyAdded();
        Asserting.accuracyOfQuantitiesAdded();
        Asserting.accuracyOfCartCount();
    }

    // no need to search also, will click on one of the items in the results, then add to cart from product page
    @Test(priority = 2)
    public void addFromProductPage() {
        homePage
                .clickOnItem("1")
                .incQ_productpage()
                .incQ_productpage()
                .decQ_productpage()
                .addToCart_productPage();
    }
}