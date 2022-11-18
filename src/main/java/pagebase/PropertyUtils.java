package pagebase;

import constants.FrameworkConstants;
import enums.PropertyType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private static final Properties properties = new Properties();
    private static final Map<String, String> MAP = new HashMap<>();

    static {

        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);

        }
        properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
    }

    public static String getValue(PropertyType key) {
        return MAP.get(key.name().toLowerCase(Locale.ROOT));
    }
}
