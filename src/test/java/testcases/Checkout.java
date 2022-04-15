package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

public class Checkout {

    String path = System.getProperty("user.dir");   // return project folder path
    String driverpath = path + "\\drivers\\chromedriver.exe";   // return driver folder path
    private WebDriver driver;
    private String url = "https://mcstaging.mooseknucklescanada.com/en";

    @BeforeMethod
    public void launch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        Thread.sleep(2000);

    }

    @Test
    public void E2Eflow() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePageTitle();
        WomenPage womenPage = new WomenPage(driver);
        womenPage.navigateToWomenModule();
        womenPage.selectProduct();
        AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
        addtoCartPage.clickcart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();

        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.passShippingDetails();


    }

    @AfterMethod
    public void teardown() {

        // driver.close();
    }
}