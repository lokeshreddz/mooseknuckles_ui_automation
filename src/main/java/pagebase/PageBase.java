package pagebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
}
