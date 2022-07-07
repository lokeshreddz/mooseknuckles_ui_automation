package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

public class HomePage extends BaseClass {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "(//span[text()='Women']/parent::a)[1]")
    public WebElement womenTitle;
    @FindBy(xpath = "(//span[text()='Men']/parent::a)[1]")
    public WebElement menTitle;
    @FindBy(xpath = "(//span[text()='Kids']/parent::a)[1]")
    public WebElement kidTitle;
    @FindBy(xpath = "(//span[text()='Collections']/parent::a)[1]")
    public WebElement collectionTitle;
    @FindBy(xpath = "(//span[text()='Sale']/parent::a)[1]")
    public WebElement salesTitle;


    public boolean verifyHomePageTitleAndMenu() {

        String title = driver.getTitle();

        String expected_title = "Moose Knuckles Canada | Official Website | We Bring The Heat | Moose Knuckles";

        if (title.equals(expected_title) && womenTitle.isDisplayed() && menTitle.isDisplayed() && kidTitle.isDisplayed() && collectionTitle.isDisplayed() && salesTitle.isDisplayed()) {
            System.out.println("Homepage title and Menu is displayed ");
            return true;
        } else
            System.out.println("HomePage content is not displaying as expected  ");
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
        boolean newsLetter = driver.findElement(By.xpath("(//p[contains(text(),'Subscribe to our Newsletter')])[3]")).isDisplayed();
        if (newsLetter) {
            driver.findElement(By.xpath("//div[@class='mbdialog popupid11']//a[@class='dialogClose style1 overlay2']")).click();
            System.out.println("NewsLetter Closed");

        } else {
            System.out.println("NewsLetter is not displayed");

        }

    }

    public void acceptPopUp() {

        boolean popup = driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']")).isDisplayed();
        if (popup) {
            driver.findElement(By.xpath("//div[@id='eshopworld-landing-page']//span[contains(text(),'Continue shopping')]")).click();
            System.out.println("Popup Accepted");


        } else {
            System.out.println("Popup is not displayed");

        }


    }
}