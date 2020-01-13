package common;

import org.apache.log4j.LogManager;

import java.io.IOException;
import java.util.Properties;


public class PropertyLoader {

    private final Properties properties;
    private static final org.apache.log4j.Logger logger = LogManager.getLogger(PropertyLoader.class);

    public PropertyLoader(String fileName) {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public Properties load() {
        return properties;
    }
}
