package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ShippingPage {
    private final WebDriver driver;
    By EmailAddress = By.xpath("//input[@id='customer-email']");
    By FirstName = By.xpath("//input[@name='firstname']");
    By LastName = By.xpath("//input[@name='lastname']");
    By company = By.xpath("//input[@name='company']");
    By StreetAddress = By.xpath("//input[@title='Street Address']");
    By City = By.xpath("//input[@name='city']");
    By PostalCode = By.xpath("//input[@name='postcode']");
    By country = By.xpath("//select[@name='country_id']");
    //    Select s=new Select((WebElement) country);
    By phonenum = By.xpath("//input[@name='telephone']");
    By allowcookies = By.xpath("//button[@class='amgdprcookie-button -allow']");
    By next = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");

    public ShippingPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void passShippingDetails() throws InterruptedException {
        driver.findElement(EmailAddress).sendKeys("asuri.k3108@gmail.com");
        Thread.sleep(2000);
        driver.findElement(FirstName).sendKeys("Asuri");

        driver.findElement(LastName).sendKeys("Kesari");

        driver.findElement(StreetAddress).sendKeys("504-2200 Rue Ward");

        driver.findElement(City).sendKeys("Saint Laurent");

        driver.findElement(PostalCode).sendKeys("H4M2R1");
        Select s = new Select(driver.findElement(country));
        s.selectByVisibleText("United States");
        driver.findElement(phonenum).sendKeys("4387253636");

        Thread.sleep(2000);
        driver.findElement(next).click();
    }


}
