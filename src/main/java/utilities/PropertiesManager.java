package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final String propRoot = "src/main/resources/";
    private static final Properties prop = new Properties();

    public static Properties loadPropertyFile(String fileName) {
        try (FileReader fileReader = new FileReader(propRoot + fileName + ".properties")){
            prop.load(fileReader);
        } catch (IOException e) {
            MyLogger.severe(PropertiesManager.class.getSimpleName(), "Can not load the flowing property file: "
                    + fileName);
            e.printStackTrace();
        }
        return prop;
    }
}
