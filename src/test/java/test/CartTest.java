package test;

import org.testng.annotations.Test;
import superclass.SuperTest;
import validation.Validate;

public class CartTest extends SuperTest {

    @Test
    public void assertCart() {
        cartPage
                .gotoCartPage()
                .calculateCartValue();

        Validate.cartValueAccuracy();}
}