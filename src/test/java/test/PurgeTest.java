package test;

import validation.Validate;
import superclass.SuperTest;
import org.testng.annotations.Test;

public class PurgeTest extends SuperTest {

    @Test(priority = 1)
    public void purgeCart() {

        cartPage
                .purgeCart();

        Validate.cartIsEmpty();
        Validate.accuracyOfCartCount();
    }
}