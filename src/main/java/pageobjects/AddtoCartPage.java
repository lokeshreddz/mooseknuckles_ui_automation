package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagebase.PageBase;

import java.awt.*;

public class AddtoCartPage extends PageBase {

    @FindBy(xpath = "//span[text()='xl']")
    public WebElement selectSize;
    @FindBy(xpath = "(//span[text()='Add to cart'])[1]")
    public WebElement addToCart;
    @FindBy(xpath = "//span[text()='Secure Checkout']")
    public WebElement secureCheckoutButton;

    public AddtoCartPage(WebDriver driver) throws AWTException {
        super(driver);

    }

    public boolean addProductToCart() {
        try {
            selectSize.click();
            addToCart.click();
            return true;

        } catch (Exception e) {
            log.error("exception error is " + e);
            return false;
        }

    }

    public boolean secureCheckout() {
        try {
            Thread.sleep(3000);
            secureCheckoutButton.click();
            return true;
        } catch (Exception e) {
            log.error("There is some exception " + e);
            return false;
        }

    }


}