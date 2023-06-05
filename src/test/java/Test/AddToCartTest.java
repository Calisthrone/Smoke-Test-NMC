package Test;

import Assert.Asserting;
import DataRepo.Vars;
import Super.SuperTest;
import org.testng.annotations.Test;

public class AddToCartTest extends SuperTest {

    // ((( --- !!! *** IMPORTANT *** !!! --- )))
    // this method should be called at the end of each addToCart test (last line)
    private void resetExpectedQuantityToAdd() {Vars.expectedQuantityToAdd = 1;}

    // no need to search as we are coming from SearchTest. Will add to cart directly from homepage.
    @Test(priority = 1)
    public void addFromHomePage() {
        homePage
                .incQ_homepage("2") // Q = 2
                .incQ_homepage("2") // Q = 3
                .incQ_homepage("2") // Q = 4
                .decQ_homepage("2") // Q = 3
                .addToCart_homepage("2");

        Asserting.itemIsActuallyAdded();
        Asserting.accuracyOfQuantitiesAdded();
        Asserting.accuracyOfCartCount();

        resetExpectedQuantityToAdd();
    }

    // no need to search also, will click on one of the items in the results, then add to cart from product page
    @Test(priority = 2)
    public void addFromProductPage() {
        homePage
                .clickOnItem("1")
                .incQ_productpage() // Q = 2
                .incQ_productpage() // Q = 3
                .decQ_productpage() // Q = 2
                .addToCart_productPage();

        Asserting.itemIsActuallyAdded();
        Asserting.accuracyOfQuantitiesAdded();
        Asserting.accuracyOfCartCount();

        resetExpectedQuantityToAdd();
    }
}