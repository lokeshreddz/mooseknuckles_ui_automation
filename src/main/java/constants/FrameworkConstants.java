package constants;


import lombok.Getter;

public class FrameworkConstants {


    private static @Getter
    final String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/properties/config.properties";

}
