package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

    private final WebDriver driver;
    // By colour= By.xpath("//*[@id=\"option-label-color_id-141-item-560\"]");
    By size = By.xpath("//*[@id=\"option-label-adult_size-142-item-51\"]");
    By cart = By.xpath("//*[@id=\"product-addtocart-button\"]");
    public AddtoCartPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickcart() {
        //driver.findElement(colour).click();
        driver.findElement(size).click();
        driver.findElement(cart).click();
    }


}