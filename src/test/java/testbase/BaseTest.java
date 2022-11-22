//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package testbase;

import constants.FrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    FrameworkConfig frameworkConfig = ConfigFactory.create(FrameworkConfig.class);


    public BaseTest() {
    }

    @SneakyThrows
    public void setUp(String browser) {

        // loading the log file
        PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
        BasicConfigurator.configure();


        if (browser.equals(frameworkConfig.browser())) {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            log.info("Launching Chrome !!!");

        } else if (browser.equals(frameworkConfig.browser())) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.info("Launching Firefox !!!");

        }

        driver.get(frameworkConfig.url());
        log.info("Navigated to : " + frameworkConfig.url());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(frameworkConfig.implicitWait()));
        wait = new WebDriverWait(driver, Duration.ofSeconds(frameworkConfig.explicitWait()));

    }


    @SneakyThrows
    @BeforeMethod
    public void testSetUp() {

        setUp(frameworkConfig.browser());
        log.info("Setup is completed successfully");
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage(frameworkConfig.languagecountry());
        homePage.acceptCookies();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Test Execution completed !!!");
    }
}
