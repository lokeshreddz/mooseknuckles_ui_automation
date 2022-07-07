package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.*;
import testbase.BaseClass;
import util.PropertyUtils;

public class CheckoutTest extends BaseClass {

    @Test
    public void E2Eflow() throws InterruptedException {
        setup(PropertyUtils.getValue("browser"));
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.acceptPopupandCookies();
        Assert.assertTrue(homePage.verifyHomePageTitleAndMenu());
        WomenPage womenPage = new WomenPage(driver);
        womenPage.navigateToWomenModule();
        homePage.acceptPopUp();
        womenPage.selectProduct();
        AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
        addtoCartPage.clickCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.passShippingDetails();

    }

    @AfterMethod
    public void teardown() {

        driver.close();
    }
}