package utils;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env=System.getProperty("env","test");

                try {
                    properties= utils.PropertyUtils.PropertyLoader("src/main/resources/"+env+".properties");
                } catch (FileNotFoundException e) {
                    try {
                        throw new Exception("resources file of: "+env+" not found");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
    }

    public static ConfigLoader getInstance(){
        if (configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getPropertyValue(String name){
        if (properties.containsKey(name)) {
            return properties.getProperty(name);
        }
        else
        {
            try {
                throw new Exception("property "+name+" not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }




        }

