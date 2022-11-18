package pagebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class PageBase {
    public static WebDriver driver;
    protected Logger log = Logger.getLogger(getClass().getName());

    public PageBase(WebDriver driver) throws AWTException {

        PageBase.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
