package com.petstore.base;

import com.petstore.utils.configs.ConfigLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  @BeforeMethod
  public void setUp() {
    ConfigLoader configLoader = ConfigLoader.getInstance();
    RestAssured.baseURI = ConfigLoader.getInstance().getProperty("BASE_URL");
    System.out.println(ConfigLoader.getInstance().getProperty("BASE_URL"));
  }
}
