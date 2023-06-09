package test;

import org.testng.annotations.Test;
import superclass.SuperTest;
import validation.Validate;

public class OrderTest extends SuperTest {

    @Test
    public void testOrder() {

        cartPage
                .proceedToCheckout()
                .selectCurrentLocationOnMap()
                .clickContinueToPayment()
                .chooseCashOnDelivery()
                .clickPlaceOrder()
                .setOrderNumber();

        Validate.validOrderNumber();
    }
}