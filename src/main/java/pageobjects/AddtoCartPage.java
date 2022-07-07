package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

    private final WebDriver driver;
    By size = By.xpath("//div[@aria-label=\"XL\"]");
    By cart = By.xpath("//span[normalize-space()='Add to Cart']");

    public AddtoCartPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        //driver.findElement(colour).click();
        driver.findElement(size).click();
        driver.findElement(cart).click();
    }


}