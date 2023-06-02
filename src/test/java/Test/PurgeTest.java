package Test;

import Assert.Asserting;
import Super.SuperTest;
import org.testng.annotations.Test;

public class PurgeTest extends SuperTest {

    @Test(priority = 1)
    public void purgeCart() {

        cartPage
                .preparePurge()
                .purgeCart(); // this method will be only executed when actualCartCount != 0

        Asserting.cartIsEmpty();
        Asserting.actualExpectedCartCountEquality();
    }
}