package Assert;

import Super.SuperPage;
import org.testng.Assert;

public class Asserting {

    // ============================== PurgeTest Global.Asserting ============================== \\

    public static void actualExpectedCartCountEquality() {
        Assert.assertEquals(SuperPage.actualCartCount, SuperPage.expectedCartCount,
                "Assertion Error | PurgeTest \nAssert Actual & Expected Cart Quantity Count Equality.");
    }

    public static void cartIsEmpty() {
        Assert.assertEquals(SuperPage.actualCartCount, 0,
                "Assertion Error | PurgeTest \nAssert Actual Cart Count Is Equal To Zero.");
    }


    // ============================== PurgeTest Global.Asserting ============================== \\


}
