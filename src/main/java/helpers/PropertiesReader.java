package helpers;

import utilities.PropertiesManager;

import java.util.Properties;

public class PropertiesReader {
    private final Properties prop;

    public PropertiesReader(String fileName) {
        prop = PropertiesManager.loadPropertyFile(fileName);
    }

    public String getProperty(String propName) {
        return prop.getProperty(propName);
    }
}
