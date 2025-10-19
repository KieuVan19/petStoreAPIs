package com.petstore.utils.configs;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
  private static Properties properties;
  private static ConfigLoader configLoader;

  private ConfigLoader() {
    properties = new Properties();
    try {
      FileReader reader =
          new FileReader(
              "C:\\Users\\Van.Ha.Kieu\\IdeaProjects\\PetStoreAPIs\\src\\main\\resources\\config-dev.properties");
      properties.load(reader);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load config.properties file", e);
    }
  }

  public static ConfigLoader getInstance() {
    if (configLoader == null) {
      configLoader = new ConfigLoader();
    }
    return configLoader;
  }

  public String getProperty(String propertyName) {
    String value = properties.getProperty(propertyName);
    if (value == null) {
      throw new RuntimeException(
          "Property: " + propertyName + " is not defined in config.properties file");
    }
    return value;
  }
}
