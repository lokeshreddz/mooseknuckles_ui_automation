package pageobjects;

import enums.PropertyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pagebase.PageBase;
import pagebase.PropertyUtils;

import java.awt.*;

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

    @FindBy(xpath = "(//input[@name=\"street.0\"])[1]")
    public WebElement streetAddressTextBox;

    @FindBy(xpath = "(//input[@name=\"city\"])[1]")
    public WebElement cityTextBox;

    @FindBy(xpath = "(//input[@name=\"postcode\"])[1]")
    public WebElement postalCodeTextBox;
    @FindBy(id = "shipping_region")
    public WebElement stateDropDown;
    @FindBy(xpath = "(//span[text()='Save Address'])[1]")
    public WebElement saveAddressButton;


    public CheckOutPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    public boolean completeContactInformation() {

        try {
            emailTextBox.sendKeys(PropertyUtils.getValue(PropertyType.EMAIL));
            continueShippingButton.click();
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
            saveAddressButton.click();
            return true;

        } catch (Exception e) {
            log.error("Exception Error is " + e);
            return false;
        }
    }


}