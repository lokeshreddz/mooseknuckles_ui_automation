package pagebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public static WebDriver driver;

    public WebDriverWait wait;
    protected Logger log = Logger.getLogger(getClass().getName());
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public PageBase(WebDriver driver) {

        PageBase.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void closeJoinTheHeadPopUp() {
        try {


            boolean cookies = driver.findElement(By.xpath("//button[@class=\"ltkpopup-close ltkpopup-close-button\"]")).isDisplayed();

            if (cookies) {
                driver.findElement(By.xpath("//button[@class=\"ltkpopup-close ltkpopup-close-button\"]")).click();
                log.info("Join the herd pop up is handled");

            } else {
                log.info("Join the herd pop up is not displayed");
            }
        } catch (NoSuchElementException e) {
            log.info("Exception Thrown is " + e);

        }

    }
}
