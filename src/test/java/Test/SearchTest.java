package Test;

import Assert.Asserting;
import Super.SuperTest;
import org.testng.annotations.Test;

public class SearchTest extends SuperTest {

    // UNIT
    @Test(priority = 1)
    public void searchForUnavailableItem() {
        homePage
                .searchFor("impossibleToFindText");

        // Assertion
        Asserting.assertNoResultsFound();

        homePage
                .gotoHomepage(); // go to homepage (after assertion) to make another search test
    }

    @Test(priority = 2)
    public void searchForItem() {
        homePage.searchFor("كولد");

        // Assertion
        Asserting.assertResultsAreFound();
        Asserting.assertSearchResultsAccuracy();
    }
}