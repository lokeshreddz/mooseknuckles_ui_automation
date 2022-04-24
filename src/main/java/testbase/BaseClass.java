package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static WebDriver driver;
    private Properties properties;


    //@BeforeClass
    public void setup() throws InterruptedException {
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
        driver.get(properties.getProperty("url"));

        Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@id=\"eshopworld-modal-window\"]/div/div/form/fieldset/div[2]/div/button/span")).click();
    }

    // @AfterClass

    public void close() {
        driver.close();


    }


}