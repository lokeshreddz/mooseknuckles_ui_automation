package pageobjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagebase.PageBase;

import java.awt.*;
import java.util.List;

public class AddtoCartPage extends PageBase {

    @FindBy(xpath = "//span[text()='xl']")
    public WebElement selectXLSize;

    @FindBy(xpath = "//span[text()='m']")
    public WebElement selectMSize;

    @FindBy(xpath = "//span[text()='l']")
    public WebElement selectLSize;

    @FindBy(xpath = "//span[text()='xs']")
    public WebElement selectXSSize;

    @FindBy(xpath = "//span[text()='s']")
    public WebElement selectSSize;
    @FindBy(xpath = "(//span[text()='Add to cart'])[1]")
    public WebElement addToCart;
    @FindBy(xpath = "//span[text()='Secure Checkout']")
    public WebElement secureCheckoutButton;

    @FindBy(xpath = "//span[@class=\"Swatch_swatch-item__1XV2_ swatch-item text-swatch Swatch_swatch-item-disabled__3GA4v swatch-item-disabled Swatch_size-swatch__Hg-gc\"]")
    private java.util.List<WebElement> sizes;

    public AddtoCartPage(WebDriver driver) throws AWTException {
        super(driver);

    }

    public boolean addProductToCart() {

        /*WebElement button = selectLSize;
        String classes = button.getAttribute("class");
        boolean isDisabled = classes.contains("Swatch_swatch-item-disabled");*/


        try {
            //selectSSize.click();
            Thread.sleep(5000);
            addToCart.click();
            return true;

        } catch (StaleElementReferenceException | InterruptedException e) {
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