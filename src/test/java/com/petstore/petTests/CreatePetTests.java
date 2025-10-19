package com.petstore.petTests;

import static com.petstore.apis.pet.Post.addNewPet;
import static com.petstore.helpers.AssertionPetHelpers.assertPetResponse;
import static com.petstore.helpers.AssertionPetHelpers.assertResponseStatusCode;

import com.petstore.base.BaseTest;
import com.petstore.pojo.pet.Category;
import com.petstore.pojo.pet.Pet;
import com.petstore.pojo.pet.Status;
import com.petstore.pojo.pet.Tags;
import io.restassured.response.Response;
import java.util.List;
import org.testng.annotations.Test;

public class CreatePetTests extends BaseTest {
  @Test
  public void createNewPetWithValidDataAtAllFields() {
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
  public void createNewPetWithoutMandatoryFields() {}
}
