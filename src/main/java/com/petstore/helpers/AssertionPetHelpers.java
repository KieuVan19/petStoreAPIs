package com.petstore.helpers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.petstore.pojo.pet.Pet;
import com.petstore.pojo.pet.Status;
import com.petstore.pojo.pet.Tags;
import io.restassured.response.Response;
import java.util.List;

public class AssertionPetHelpers {
  public static void assertResponseStatusCode(Response response, int expectedCode) {
    assertThat(response.getStatusCode(), equalTo(expectedCode));
  }

  public static void assertCategory(Pet response, Pet request) {
    String actualCategoryName = response.getCategory().getName();
    Long actualCategoryId = response.getCategory().getId();
    String expectedCategoryName = request.getCategory().getName();
    Long expectedCategoryId = request.getCategory().getId();
    assertThat(actualCategoryId, is(equalTo(expectedCategoryId)));
    assertThat(actualCategoryName, is(equalTo(expectedCategoryName)));
  }

  public static void assertTags(Pet response, Pet request) {
    List<Long> actualTagsId = response.getTags().stream().map(Tags::getId).toList();
    List<String> actualTagsName = response.getTags().stream().map(Tags::getName).toList();
    List<Long> expectedTagsId = request.getTags().stream().map(Tags::getId).toList();
    List<String> expectedTagsName = request.getTags().stream().map(Tags::getName).toList();
    assertThat(actualTagsId, is(equalTo(expectedTagsId)));
    assertThat(actualTagsName, is(equalTo(expectedTagsName)));
  }

  public static void assertPhotoUrls(Pet response, Pet request) {
    List<String> actualPhotoUrls = response.getPhotoUrls().stream().toList();
    List<String> expectedPhotoUrls = request.getPhotoUrls().stream().toList();
    assertThat(actualPhotoUrls, is(equalTo(expectedPhotoUrls)));
  }

  public static void assertStatus(Pet response, Pet request) {
    Status actualStatus = response.getStatus();
    Status expectedStatus = request.getStatus();
    assertThat(actualStatus, is(equalTo(expectedStatus)));
  }

  public static void assertName(Pet response, Pet request) {
    String actualPetName = response.getName();
    String expectedPetName = request.getName();
    assertThat(actualPetName, is(equalTo(expectedPetName)));
  }

  public static void assertPetResponse(Pet response, Pet request) {
    assertName(response, request);
    assertPhotoUrls(response, request);
    assertCategory(response, request);
    assertTags(response, request);
    assertStatus(response, request);
  }
}
