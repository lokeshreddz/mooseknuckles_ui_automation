package pageobjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pagebase.PageBase;

import java.awt.*;

public class WomenPage extends PageBase {

    @FindBy(xpath = "(//a[text()='Women']/parent::li)[3]")
    public WebElement womenTitle;

    @FindBy(xpath = "(//a[text()=\"Parkas\"])[4]")
    public WebElement parkas;

    @FindBy(xpath = "(//div[@class=\"Plpgrid_Plpgrid__1SVDs\"]//div[@class=\"ProductTile_productitem-block__2sZ1u\"])[1]")
    public WebElement firstProduct;


    public WomenPage(WebDriver driver) throws AWTException {
        super(driver);

    }

    public void navigateToWomenModule() {

        try {
            Actions action = new Actions(driver);
            //action.moveToElement(womenTitle).moveToElement(parkas).click().build().perform();
            driver.get("https://pylotstage.mooseknucklescanada.com/us-en/c/women/outerwear/parkas");
            log.info("Navigated to the Women's Page Outdoor -Parkas");
            closeJoinTheHeadPopUp();
        } catch (StaleElementReferenceException e) {
            driver.get("https://pylotstage.mooseknucklescanada.com/us-en/c/women/outerwear/parkas");
            log.info("Navigated to the Women sub menu ");

        }
    }


    public void selectProduct() {
        firstProduct.click();
        log.info("Clicked on the first product");


    }

    public void addToCart() {

    }

    public void proceedToCheckout() {


    }

    public void enterShippingAddress() {


    }
}