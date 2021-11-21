package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties PropertyLoader(String file) throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
