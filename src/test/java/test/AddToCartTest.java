package test;

import validation.Asserting;
import data.Vars;
import superclass.SuperTest;
import org.testng.annotations.Test;

public class AddToCartTest extends SuperTest {

    // ((( --- !!! *** IMPORTANT *** !!! --- )))
    // this method should be called at the end of each addToCart test (last line)
    private void resetExpectedQuantityToAdd() {Vars.expectedQuantityToAdd = 1;}

    // no need to search as we are coming from SearchTest. Will add to cart directly from homepage.
    @Test(priority = 1)
    public void addFromHomePage() {
        homePage
                .incQ_homepage(Vars.position) // Q = 2
                .incQ_homepage(Vars.position) // Q = 3
                .incQ_homepage(Vars.position) // Q = 4
                .decQ_homepage(Vars.position) // Q = 3
                .addToCart_homepage(Vars.position);

        Asserting.itemIsActuallyAdded();
        Asserting.accuracyOfQuantitiesAdded();
        Asserting.accuracyOfCartCount();

        resetExpectedQuantityToAdd();
    }

    // no need to search also, will click on one of the items in the results, then add to cart from product page
    @Test(priority = 2)
    public void addFromProductPage() {
        homePage
                .prepareRandomProduct()
                .gotoHomepage()
                .searchFor(Vars.searchName_AR, true)
                .clickOnItem(Vars.position)
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