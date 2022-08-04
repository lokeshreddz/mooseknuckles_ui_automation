package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

    private final WebDriver driver;

    By selectcrd = By.xpath("//label[@for='paysafe_gateway']//div[@class='radio-box']");
    By crdnum = By.xpath("//input[@id='paysafe_gateway_cc_number']");
    By Expdate = By.xpath("//select[@id='paysafe_gateway_expiration']");
    By expyear = By.xpath("//select[@id='paysafe_gateway_expiration_yr']");
    By crdvernum = By.xpath("//input[@id='paysafe_gateway_cc_cid']");
    By placeorder = By.xpath("//button[@data-role='review-save']");

    //By saveadd = By.xpath("//span[.=\"Save Address\"]");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickPlaceOrder()
    {
        driver.findElement(selectcrd).click();
        driver.findElement(crdnum).sendKeys("4111111111111111");

        Select objSelect = new Select(driver.findElement(Expdate));
        objSelect.selectByIndex(2);

        Select obj = new Select(driver.findElement(expyear));
        obj.selectByVisibleText("2027");

        driver.findElement(crdvernum).sendKeys("201");

        driver.findElement(placeorder).click();

       // driver.findElement(saveadd).click();
    }
}