package utils;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigReader {
    private Properties properties;
 
    public ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        inputStream.close();
    }
 
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}