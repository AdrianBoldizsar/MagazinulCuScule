package propertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyUtility {

    public Properties properties;

    public PropertyUtility(String testName) {
        loadFile(testName);
    }

    public void loadFile(String testName) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/inputData/" + testName +
                    ".properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDataValue(String key){
        return properties.getProperty(key);
    }

    public Map<String, Object> getAllProperties(){
        Map<String, Object> allProperties = new HashMap<>();
        for (String key: properties.stringPropertyNames()){
            String value = getDataValue(key);
            allProperties.put(key, value);
        }
        return allProperties;
    }
}
