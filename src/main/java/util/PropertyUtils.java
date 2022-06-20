package util;



import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private static Properties properties = new Properties();
    private static Map<String, String> MAP = new HashMap<>();

    static {

        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);

        }
        properties.forEach((key, value) -> MAP.put(String.valueOf(key), String.valueOf(value)));
    }

    public static String getValue(String key) {
        return MAP.get(key);
    }
}