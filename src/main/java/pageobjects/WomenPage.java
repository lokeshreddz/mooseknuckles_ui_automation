package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

        Actions act = new Actions(driver);
        act.moveToElement(womenTitle).moveToElement(parkas).click().build().perform();
        log.info("Navigated to the Women's Page Outdoor -Parkas");
        closeJoinTheHeadPopUp();

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