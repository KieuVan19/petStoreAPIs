package com.petstore.petTests;

import com.petstore.base.BaseTest;
import com.petstore.pojo.pet.Category;
import com.petstore.pojo.pet.Pet;
import com.petstore.pojo.pet.Status;
import com.petstore.pojo.pet.Tags;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static com.petstore.apis.pet.Post.addNewPet;
import static com.petstore.helpers.AssertionPetHelpers.assertPetResponse;
import static com.petstore.helpers.AssertionPetHelpers.assertResponseStatusCode;
import static com.petstore.utils.testDataReader.TestDataReader.testDataReader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CreatePetTests extends BaseTest {
    @Test
    public void testCreateNewPetWithValidDataAtAllFields_shouldReturn200() {
        // Step 1: Create a new pet
        Category category = new Category(1232L, "Senior dog");
        List<Tags> tags = List.of(new Tags(123L, "Trained"), new Tags(455L, "Vaccinated"));
        List<String> photoUrls = List.of("link picture 1", "Link picture");
        Status status = Status.available;
        Pet petRequest = new Pet(category, "Hiccup", photoUrls, tags, status);

        Response petResponse = addNewPet(petRequest);
        Pet createdPet = petResponse.as(Pet.class);

        // Step 2: Assertions
        assertResponseStatusCode(petResponse, 200);
        assertPetResponse(createdPet, petRequest);
    }

    @Test
    public void testCreateNewPetWithoutMandatoryFields_shouldReturn200() {
        // Step 1: Create a new pet
        Pet petRequest = new Pet();
        Response response = addNewPet(petRequest);
        Pet createdPet = response.as(Pet.class);

        // Step 2: Assertion
        assertResponseStatusCode(response, 200);
        assertPetResponse(createdPet, petRequest);
    }


    @Test
    public void testCreateNewPetWithInValidData_shouldReturn500() {
        // Step 1: Get the invalid request body
        String invalidPetRequest = testDataReader("post-pet-invalid.json");

        // Step 2: Call API with invalid request body
        given()
                .contentType(ContentType.JSON)
                .body(invalidPetRequest)
                .when()
                .post("/pet")
                .then()
                .statusCode(500)
                .body("code", equalTo(500))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("something bad happened"));
    }
}
