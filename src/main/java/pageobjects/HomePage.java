package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[@class='level-top mobile-bold hovered']//span[contains(text(),'Women')]")
    WebElement womenTitle;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement menTitle;
    @FindBy(xpath = "(//ul[@id=\"desktop-menu\"]/li/a)[1]")
    WebElement kidTitle;
    @FindBy(xpath = "(//ul[@id=\"desktop-menu\"]/li/a)[2]")
    WebElement collectionTitle;
    @FindBy(xpath = "(//ul[@id=\"desktop-menu\"]/li/a)[3]")
    WebElement salesTitle;
    @FindBy(xpath = "//a[@class='level-top mobile-bold hovered']//span[contains(text(),'Moose Knuckles x Eckhaus Latta')]")
    WebElement Moose_Knuckles_x_Eckhaus_Latta;
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public boolean verifyHomePageTitle() {

        String title = driver.getTitle();

        String expected_title = "Moose Knuckles Canada | Official Website | We Bring The Heat  | Moose Knuckles";

        if (title.equals(expected_title)) {
            System.out.println("Homepage title is " + title);
            return true;
        } else
            System.out.println("Home Page title is not displayed and  " + title);
        return false;

    }

    public void acceptPopupandCookies() throws InterruptedException {


        boolean popup = driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']")).isDisplayed();
        if (popup) {
            driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']//span[contains(text(),'Continue shopping')]")).click();
            System.out.println("Popup Accepted");


        } else {
            System.out.println("Popup is not displayed");

        }

        Thread.sleep(3000);

        boolean cookies = driver.findElement(By.xpath("//button[@title='Allow Cookies']")).isDisplayed();

        if (cookies) {
            driver.findElement(By.xpath("//button[@title='Allow Cookies']")).click();
            System.out.println("Cookies accepted");

        } else {
            System.out.println("Cookies alert is not displayed");
        }


    }
    /*public boolean isHomePageSolutionsTabDisplayed() {

        return solutions.getText().contains("SOLUTIONS");
    }

    public boolean isHomePageIndustriesTabDisplayed() {

        return industries.getText().contains("INDUSTRIES");
    }

    public boolean isHomePageResourcesTabDisplayed() {

        return resources.getText().contains("RESOURCES");
    }*/

    public void acceptpopup() {

        boolean popup = driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']")).isDisplayed();
        if (popup) {
            driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']//span[contains(text(),'Continue shopping')]")).click();
            System.out.println("Popup Accepted");


        } else {
            System.out.println("Popup is not displayed");

        }


    }
}