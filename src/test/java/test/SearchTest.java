package test;

import superclass.SuperPage;
import validation.Asserting;
import data.Vars;
import superclass.SuperTest;
import org.testng.annotations.Test;

public class SearchTest extends SuperTest {

    // UNIT
    @Test(priority = 1)
    public void invalidSearch() {
        homePage
                .searchFor("impossibleToFindText", false);

        // Assertion
        Asserting.noResultsFound();

        homePage
                .gotoHomepage(); // go to homepage (after assertion) to make another search test
    }

    // UNIT
    @Test(priority = 2)
    public void validSearch() {
        homePage
                .prepareRandomProduct()
                .searchFor(Vars.searchName_AR, true);

        // Assertion
        Asserting.resultsAreFound();
        Asserting.searchResultsAccuracy();
    }
}