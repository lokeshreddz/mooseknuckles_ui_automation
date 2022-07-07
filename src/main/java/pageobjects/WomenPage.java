package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
    By firstproduct = By.xpath("(//li[@class='item product product-item']//strong[contains(@class,'product name product-item-name')]/a)[2]");
    private WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void navigateToWomenModule() throws InterruptedException {

        Thread.sleep(4000);

        WebElement hover = driver.findElement(By.xpath("//span[text()='Women']/parent::a"));
        WebElement hover1 = driver.findElement(By.xpath("//span[text()='Parkas']/parent::a"));
        Actions act = new Actions(driver);
        act.moveToElement(hover).moveToElement(hover1).click().build().perform();

    }

    public void selectProduct() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(firstproduct).click();


    }

    public void addToCart() {

    }

    public void proceedToCheckout() {


    }

    public void enterShippingAddress() {


    }
}