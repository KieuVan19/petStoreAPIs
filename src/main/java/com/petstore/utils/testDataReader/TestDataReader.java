package com.petstore.utils.testDataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataReader {
    private static final String basePath = "C:\\Users\\Van.Ha.Kieu\\IdeaProjects\\PetStoreAPIs\\src\\test\\resources\\payloads";
    public static String testDataReader(String fileName){
        Path path =  Path.of(basePath+ "\\" + fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read json file: " + fileName,e);
        }
    }
}
