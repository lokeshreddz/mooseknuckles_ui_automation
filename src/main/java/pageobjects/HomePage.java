package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagebase.PageBase;

import java.awt.*;


public class HomePage extends PageBase {
    @FindBy(xpath = "(//a[text()='Women']/parent::li)")
    public WebElement womenTitle;
    @FindBy(xpath = "(//a[text()='Men']/parent::li)")
    public WebElement menTitle;
    @FindBy(xpath = "(//a[text()='Kids']/parent::li)")
    public WebElement kidTitle;
    @FindBy(xpath = "(//a[text()='Accessories']/parent::li)")
    public WebElement accessoriesTitle;
    @FindBy(xpath = "(//a[text()='Icons']/parent::li)")
    public WebElement iconsTitle;
    @FindBy(xpath = "(//a[text()='New']/parent::li)")
    public WebElement newTitle;

    @FindBy(xpath = "//li[@class=\"LanguageDropdown_item__30Zk-\"]/a")
    private java.util.List<WebElement> selectLanguage;
    @FindBy(xpath = "//div[@aria-expanded=\"true\"]")
    private WebElement languageDropdownExpanded;
    @FindBy(xpath = "//span[@role=\"button\"]")
    private WebElement languageDropdown;


    public HomePage(WebDriver driver) throws AWTException {
        super(driver);

    }

    public boolean verifyHomePageTitleAndMenu() {

        String title = driver.getTitle();

        String expected_title = "Moose Knuckles Canada | Official Website | We Bring The Heat | Moose Knuckles";

        if (title.equals(expected_title) && womenTitle.isDisplayed() && menTitle.isDisplayed() && kidTitle.isDisplayed() && accessoriesTitle.isDisplayed() && iconsTitle.isDisplayed() && newTitle.isDisplayed()) {
            System.out.println("Homepage title and Menu is displayed ");
            return true;
        } else
            System.out.println("HomePage content is not displaying as expected  ");
        return false;

    }

    public void acceptCookies() {
        try {


            boolean cookies = driver.findElement(By.xpath("//span[text()='Accept']")).isDisplayed();

            if (cookies) {
                driver.findElement(By.xpath("//span[text()='Accept']")).click();
                log.info("Cookies accepted");

            } else {
                log.info("Cookies alert is not displayed");
            }
        } catch (NoSuchElementException e) {
            log.info("Exception Thrown is " + e);

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

    public boolean selectLanguage() {

        if (selectLanguage.get(1).isEnabled()) {
            log.info("Currency Dropdown already opened");
        } else {
            languageDropdown.click();
            log.info("clicked on language drop down");
        }

        for (int i = 0; i < selectLanguage.size(); i++) {
            log.info("There are " + selectLanguage.size() + " Languages available");
            if (selectLanguage.get(i).isEnabled()) {
                log.info(selectLanguage.get(i).getText() + " is selected ");
                selectLanguage.get(i).click();
                return true;
            }

        }
        return false;
    }

}