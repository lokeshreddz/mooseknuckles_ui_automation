package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenPage {
    private WebDriver driver;

    public MenPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
