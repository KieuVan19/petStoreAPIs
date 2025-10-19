package com.petstore.apis.pet;

import static io.restassured.RestAssured.*;

import com.petstore.pojo.pet.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
  public static Response addNewPet(Pet pet) {
    return given()
        .contentType(ContentType.JSON)
        .body(pet)
        .when()
        .post("/pet")
        .then()
        .log()
        .body()
        .extract()
        .response();
  }
}
