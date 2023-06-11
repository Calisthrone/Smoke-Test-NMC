package validation;

import data.Vars;
import locator.HomeLoc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import superclass.SuperPage;
import superclass.SuperTest;

public class Validate{

    // get the same instance of driver used in all test classes/
    private static final WebDriver driver = SuperTest.getDriver();
    private static final SuperPage superPage = new SuperPage(driver);

    private static final SoftAssert softAssert = new SoftAssert();

    // ============================== PurgeTest Assertions ============================== \\

    public static void accuracyOfCartCount() {

        softAssert.assertEquals(Vars.actualCartCount, Vars.expectedCartCount,
                "\nAccuracy Of Cart Count | asserting: Actual Cart Count == Expected Cart Count");
        softAssert.assertAll();
    }

    public static void cartIsEmpty() {
        softAssert.assertEquals(Vars.actualCartCount, 0,
                "\nCart Is Empty | asserting: Actual Cart Count == 0");
        softAssert.assertAll();
    }

    // ============================== SearchTest Assertions ============================== \\

    public static void noResultsFound() {
        String actualNoResultText = superPage.createElement(HomeLoc.noResultLocator).getAttribute("textContent");

        softAssert.assertTrue(actualNoResultText.matches("(?i).*" + HomeLoc.expectedNoResultText + ".*"),
                "\nNo Result Found | asserting: Presence Of Pre-Defined Message Indicating No Result Are Found");
        softAssert.assertAll();
    }

    public static void resultsAreFound() {
        softAssert.assertTrue(superPage.createElement(HomeLoc.firstSearchResultLocator).isDisplayed(),
                "\nResult Are Found | asserting: At Least One Result Is Displayed");
        softAssert.assertAll();
    }

    public static void searchResultsAccuracy() {

        int matchingResults = 0;
        for(WebElement link : Vars.searchResultElementList) {
            if (
                    link.getAttribute("textContent").matches("(?i).*" + Vars.searchName_AR + ".*")
            ) {
                matchingResults = matchingResults + 1;
            }
        }
        String actualPercentage = ((matchingResults * 100 / Vars.searchResultsCount) + "%");

        softAssert.assertEquals(actualPercentage, "100%",
                "\nSearch Results Accuracy | asserting: Search Results Are Related To Search Text");
        softAssert.assertAll();
    }

    // ============================== AddToCartTest Assertions ============================== \\

    public static void itemIsActuallyAdded() {
        softAssert.assertTrue(Vars.addToCartMessage.contains(Vars.searchName_AR),
                "\nItem Is Actually Added | asserting: Presence Of Add To Cart Message Containing Search Text");
        softAssert.assertAll();
    }

    public static void accuracyOfQuantitiesAdded() {
        softAssert.assertEquals(Vars.actualQuantityToAdd, Vars.expectedQuantityToAdd,
                "\nAccuracy Of Quantities Added | asserting: Actual Quantity To Add == Expected Quantity To Add");
        softAssert.assertAll();
    }

    // ============================== CartTest Assertions ============================== \\

    public static void cartValueAccuracy() {
        double roundedExpectedCartValue = Math.round(Vars.expectedCartValue * 100.00) / 100.00;
        softAssert.assertEquals(Vars.actualCartValue, roundedExpectedCartValue,
                "\nCart Value Accuracy | asserting: Actual Cart Value == Expected Cart Value");
        softAssert.assertAll();
    }

    public static void validOrderNumber() {
        softAssert.assertTrue(Vars.orderNumber.startsWith("100") || Vars.orderNumber.startsWith("700"));
        softAssert.assertAll();
    }
}