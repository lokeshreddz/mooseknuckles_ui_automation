package testcases;

import org.testng.annotations.Test;
import pageobjects.*;
import testbase.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void E2Eflow() throws InterruptedException {
        WomenPage womenPage = new WomenPage(driver);
        womenPage.navigateToWomenModule();
        womenPage.selectProduct();
        AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
        addtoCartPage.clickCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.passShippingDetails();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.ClickPlaceOrder();

    }
}