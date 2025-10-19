package com.petstore.apis.pet;

import static io.restassured.RestAssured.*;

import com.petstore.pojo.pet.Pet;
import io.restassured.http.ContentType;

public class Put {
  public static Pet updateAnExistingPet(Pet pet) {
    return given()
        .contentType(ContentType.JSON)
        .body(pet)
        .when()
        .put("/pet")
        .then()
        .log()
        .body()
        .statusCode(200)
        .extract()
        .as(Pet.class);
  }
}
