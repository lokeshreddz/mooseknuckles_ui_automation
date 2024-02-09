package pageobjects;

import enums.PropertyType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;
import pagebase.PropertyUtils;

import java.awt.*;
import java.time.Duration;

public class CheckOutPage extends PageBase {

    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@aria-label=\"Continue to Shipping\"]")
    public WebElement continueShippingButton;

    @FindBy(xpath = "(//input[@name=\"firstname\"])[1]")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "(//input[@name=\"lastname\"])[1]")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "(//input[@name=\"telephone\"])[1]")
    public WebElement phoneNumberTextBox;

    @FindBy(xpath = "(//input[@name=\"street[0]\"])[1]")
    public WebElement streetAddressTextBox;

    @FindBy(xpath = "(//input[@name=\"city\"])[1]")
    public WebElement cityTextBox;

    @FindBy(xpath = "(//input[@name=\"postcode\"])[1]")
    public WebElement postalCodeTextBox;
    @FindBy(id = "shipping_region")
    public WebElement stateDropDown;
    @FindBy(xpath = "(//button[@type=\"submit\"])[2]")
    public WebElement confirmAddress;

    @FindBy(xpath = "//button[@aria-label=\"Continue to Payment\"]")
    public WebElement continueToPaymentButton;

    @FindBy(xpath = "//span[text()=\"Credit Card\"]")
    public WebElement creditCardButton;

    @FindBy(xpath = "//input[@aria-label=\"Card number\"]")
    public WebElement cardNumberTextBox;

    @FindBy(xpath = "//input[@aria-label=\"Expiry date\"]")
    public WebElement expiryDateTextBox;

    @FindBy(xpath = "//input[@aria-label=\"Security code\"]")
    public WebElement cvvTextBox;
    @FindBy(xpath = "//input[@name=\"holderName\"]")
    public WebElement nameOnCardTextBox;

    @FindBy(xpath = "//span[contains(text(),'Place Order ')]")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//iframe[@title=\"Iframe for secured card number\"]")
    public WebElement cardNumberIframe;

    @FindBy(xpath = "//iframe[@title=\"Iframe for secured card expiry date\"]")
    public WebElement expiryIframe;

    @FindBy(xpath = "//iframe[@title=\"Iframe for secured card security code\"]")
    public WebElement cvvIframe;


    public CheckOutPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    public boolean completeContactInformation() {

        try {
            Thread.sleep(5000);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(emailTextBox)).click();
            emailTextBox.sendKeys(PropertyUtils.getValue(PropertyType.EMAIL));
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(continueShippingButton)).click();
            log.info("EmailID provided and clicked on continue shipping button");
            return true;
        } catch (Exception e) {
            log.error("Exception Error is " + e);
            return false;

        }


    }

    public boolean completeShippingDetails() {
        try {
            firstNameTextBox.sendKeys(PropertyUtils.getValue(PropertyType.FIRSTNAME));
            lastNameTextBox.sendKeys(PropertyUtils.getValue(PropertyType.LASTNAME));
            phoneNumberTextBox.sendKeys(PropertyUtils.getValue(PropertyType.PHONENUMBER));
            streetAddressTextBox.sendKeys(PropertyUtils.getValue(PropertyType.STREETADDRESS1));
            Select state = new Select(stateDropDown);
            state.selectByVisibleText(PropertyUtils.getValue(PropertyType.STATE));
            cityTextBox.sendKeys(PropertyUtils.getValue(PropertyType.CITY));
            postalCodeTextBox.sendKeys(PropertyUtils.getValue(PropertyType.POSTALCODE));
            confirmAddress.click();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(continueToPaymentButton)).click();
            log.info("Shipping Details completed");
            return true;

        } catch (Exception e) {
            log.error("Exception Error is " + e);
            return false;
        }
    }

    @SneakyThrows
    public boolean completePaymentAndPlaceTheOrder() {


        creditCardButton.click();
        driver.switchTo().frame(cardNumberIframe);
        Thread.sleep(5000);
        cardNumberTextBox.sendKeys(PropertyUtils.getValue(PropertyType.CARDNUMBER));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(expiryIframe);
        Thread.sleep(2000);
        expiryDateTextBox.sendKeys(PropertyUtils.getValue(PropertyType.EXPIRY));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(cvvIframe);
        Thread.sleep(2000);
        cvvTextBox.sendKeys(PropertyUtils.getValue(PropertyType.CVV));
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        nameOnCardTextBox.sendKeys(PropertyUtils.getValue(PropertyType.NAMEONCARD));
        placeOrderButton.click();
        log.info("Order Placed ");
        return true;

    }


}