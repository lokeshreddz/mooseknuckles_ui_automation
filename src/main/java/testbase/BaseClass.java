package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static WebDriver driver;
    private Properties properties;


    //@BeforeClass
    public void setup() {
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.gecko.driver", "C:\\SeleniumProject\\demoframwork\\geckodriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\SeleniumProject\\demoframwork\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

    // @AfterClass

    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();


    }

    public void acceptPopup() {


    }


}