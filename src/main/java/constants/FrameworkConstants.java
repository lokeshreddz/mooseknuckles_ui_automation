package constants;


import lombok.Getter;

public class FrameworkConstants {


    private static @Getter
    final String chromeDriverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
    private static @Getter
    final String fireFoxDriverPath = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
    private static @Getter
    final String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/properties/config.properties";

}
