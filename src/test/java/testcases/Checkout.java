package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Checkout {

    String path = System.getProperty("user.dir");   // return project folder path
    String driverpath = path + "\\drivers\\chromedriver.exe";   // return driver folder path
    private WebDriver driver;
    private String url = "https://mcstaging.mooseknucklescanada.com/en/";

    @BeforeMethod
    public void launch() {
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.get(url);

    }

    @Test
    public void E2Eflow() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.acceptPopupandCookies();
        homePage.verifyHomePageTitle();
        WomenPage womenPage = new WomenPage(driver);
        womenPage.navigateToWomenModule();
        homePage.acceptpopup();
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

        driver.close();
    }
}