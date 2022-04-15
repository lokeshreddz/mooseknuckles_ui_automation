package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
    By firstproduct = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div[2]/div/strong/a");
    private WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void navigateToWomenModule() throws InterruptedException {

        driver.get("https://mcstaging.mooseknucklescanada.com/en/women");
        Thread.sleep(2000);

    }

    public void selectProduct() {

        driver.findElement(firstproduct).click();


    }

    public void addToCart() {

    }

    public void proceedToCheckout() {


    }

    public void enterShippingAddress() {


    }
}