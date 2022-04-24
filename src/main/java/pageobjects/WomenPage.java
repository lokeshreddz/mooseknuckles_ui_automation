package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Iterator;
import java.util.Set;

public class WomenPage {
    By firstproduct = By.xpath("//a[normalize-space()='NOOTKA PANTS']");
    private WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void navigateToWomenModule() {

        WebElement hover = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]/span[1]"));

        Actions act = new Actions(driver);
        act.moveToElement(hover).perform();

        driver.findElement(By.xpath("//a[.='Fall/Winter New Arrivals']")).click();

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