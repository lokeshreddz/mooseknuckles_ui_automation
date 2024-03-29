package testcases;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddtoCartPage;
import pageobjects.CheckOutPage;
import pageobjects.WomenPage;
import testbase.BaseTest;

public class CheckoutTest extends BaseTest {

    @SneakyThrows
    @Test
    public void E2Eflow() {
        WomenPage womenPage = new WomenPage(driver);
        womenPage.navigateToWomenModule();
        womenPage.selectProduct();
        AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
        Assert.assertTrue(addtoCartPage.addProductToCart());
        Assert.assertTrue(addtoCartPage.secureCheckout());
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.completeContactInformation());
        Assert.assertTrue(checkOutPage.completeShippingDetails());
        Assert.assertTrue(checkOutPage.completePaymentAndPlaceTheOrder());


    }
}