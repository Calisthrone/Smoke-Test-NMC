package Test;

import Assert.Asserting;
import Super.SuperTest;
import org.testng.annotations.Test;

public class PurgeTest extends SuperTest {

    @Test(priority = 1)
    public void purgeCart() {

        cartPage
                .purgeCart();

        Asserting.cartIsEmpty();
        Asserting.accuracyOfCartCount();
    }
}