package Assert;

import DataRepo.Vars;
import Locators.HomeLoc;
import Super.SuperPage;
import Super.SuperTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Asserting {

    // get the same instance of driver used in all test classes/
    private static final WebDriver driver = SuperTest.getDriver();
    private static final SuperPage superPage = new SuperPage(driver);

    // ============================== PurgeTest Assertions ============================== \\

    public static void accuracyOfCartCount() {
        Assert.assertEquals(Vars.actualCartCount, Vars.expectedCartCount,
                "\nAccuracy Of Cart Count | asserting: Actual Cart Count == Expected Cart Count");
    }

    public static void cartIsEmpty() {
        Assert.assertEquals(Vars.actualCartCount, 0,
                "\nCart Is Empty | asserting: Actual Cart Count == 0");
    }

    // ============================== SearchTest Assertions ============================== \\

    public static void noResultsFound() {
        String actualNoResultText = superPage.createElement(HomeLoc.noResultLocator).getAttribute("textContent");

        Assert.assertTrue(actualNoResultText.matches("(?i).*" + HomeLoc.expectedNoResultText + ".*"),
                "\nNo Result Found | asserting: Presence Of Pre-Defined Message Indicating No Result Are Found");
    }

    public static void resultsAreFound() {
        Assert.assertTrue(superPage.createElement(HomeLoc.firstSearchResultLocator).isDisplayed(),
                "\nResult Are Found | asserting: At Least One Result Is Displayed");
    }

    public static void searchResultsAccuracy() {

        int matchingResults = 0;
        for(WebElement link : Vars.searchResultElementList) {
            if (link.getAttribute("textContent").matches("(?i).*" + Vars.searchText + ".*")) {
                matchingResults = matchingResults + 1;
            }
        }
        String actualPercentage = ((matchingResults * 100 / Vars.searchResultsCount) + "%");

        Assert.assertEquals(actualPercentage, "100%",
                "\nSearch Results Accuracy | asserting: Search Results Are Related To Search Text");
    }

    // ============================== AddToCartTest Assertions ============================== \\

    public static void itemIsActuallyAdded() {
        Assert.assertTrue(Vars.addToCartMessage.contains(Vars.searchText),
                "\nItem Is Actually Added | asserting: Presence Of Add To Cart Message Containing Search Text");
    }

    public static void accuracyOfQuantitiesAdded() {
        Assert.assertEquals(Vars.actualQuantityToAdd, Vars.expectedQuantityToAdd,
                "\nAccuracy Of Quantities Added | asserting: Actual Quantity To Add == Expected Quantity To Add");
    }
}