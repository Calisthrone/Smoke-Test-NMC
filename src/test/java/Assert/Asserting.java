package Assert;

import Locators.HomeLoc;
import Super.SuperPage;
import Super.SuperTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Asserting {

    // get the same instance of driver used in all test classes/
    private static final WebDriver driver = SuperTest.getDriver();
    private static final SuperPage superPage = new SuperPage(driver);

    private boolean locatorIsVisible(By locator) {
        boolean isVisible = false;
        WebElement element;

        return isVisible;
    }
    // ============================== PurgeTest Assertions ============================== \\

    public static void actualExpectedCartCountEquality() {
        Assert.assertEquals(SuperPage.actualCartCount, SuperPage.expectedCartCount,
                "Assertion Error | PurgeTest \nAssert Actual & Expected Cart Quantity Count Equality.");
    }

    public static void cartIsEmpty() {
        Assert.assertEquals(SuperPage.actualCartCount, 0,
                "Assertion Error | PurgeTest \nAssert Actual Cart Count Is Equal To Zero.");
    }

    // ============================== SearchTest Assertions ============================== \\

    public static void assertNoResultsFound() {
        String actualNoResultText = superPage.createElement(HomeLoc.noResultLocator).getAttribute("textContent");
        String expectedNoResultText = "لا توجد منتجات للاستعلام";

        Assert.assertTrue(actualNoResultText.matches("(?i).*" + expectedNoResultText + ".*"),
                "Assertion Error | SearchTest \nAssert Presence Of Message For No Results Found.");
    }

    public static void assertResultsAreFound() {
        Assert.assertTrue(superPage.createElement(HomeLoc.firstSearchResultLocator).isDisplayed(),
                "\"Assertion Error | SearchTest \nAssert Appearance Of Test Results.");
    }

    public static void assertSearchResultsAccuracy() {
        superPage.waitForVisibilityOf(HomeLoc.allSearchResultsSelector);
        List<WebElement> resultsLinks = driver.findElements(HomeLoc.allSearchResultsSelector); // contains all results

        int matchingResults = 0;

        for(WebElement link : resultsLinks) {
            if (link.getAttribute("textContent").matches("(?i).*" + "كولد" + ".*")) {
                matchingResults = matchingResults + 1;
            }
        }
        String actualPercentage = ((matchingResults * 100 / resultsLinks.size()) + "%");

        Assert.assertEquals(actualPercentage, "100%",
                "\"Assertion Error | SearchTest \nAssert Results Accuracy.");
    }
}
