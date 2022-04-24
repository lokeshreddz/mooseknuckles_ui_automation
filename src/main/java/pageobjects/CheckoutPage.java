package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private final WebDriver driver;
    By checkout = By.xpath("//button[@title='Proceed to Checkout']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {

        driver.findElement(checkout).click();


    }


}