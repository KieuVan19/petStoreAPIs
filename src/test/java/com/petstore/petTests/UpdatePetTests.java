// package com.petstore.petTests;
//
// import com.petstore.base.BaseTest;
// import com.petstore.pojo.pet.Category;
// import com.petstore.pojo.pet.Pet;
// import com.petstore.pojo.pet.Status;
// import com.petstore.pojo.pet.Tags;
// import org.testng.annotations.Test;
//
// import java.util.List;
//
// import static com.petstore.apis.pet.Post.addNewPet;
// import static com.petstore.apis.pet.Put.updateAnExistingPet;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.Matchers.equalTo;
// import static org.hamcrest.Matchers.is;
//
// public class UpdatePetTests extends BaseTest {
//    @Test
//    public void updateAnExistingPetTest() {
//        // Step 1: Create a new pet
//        Category initialCategory = new Category("Senior dog");
//        List<Tags> initialTags = List.of(
//                new Tags("K9"),
//                new Tags("Retired")
//        );
//        List<String> initialPhotoUrls = List.of("link picture 1", "Link picture 2");
//        Status initialStatus = Status.available;
//
//        Pet newPetRequest = new Pet(initialCategory, "Bonnie", initialPhotoUrls, initialTags,
// initialStatus);
//        Pet newPetResponse = addNewPet(newPetRequest);
//        Long petId = newPetResponse.getId();
//
//        // Step 2: Update the existing pet
//        Category updateCategory = new Category("Retired dog");
//        List<Tags> updateTags = List.of(
//                new Tags("Service dog")
//        );
//        List<String> updatePhotoUrls = List.of("link picture 3", "Link picture 4");
//        Status updateStatus = Status.pending;
//
//        Pet updatePetRequest = new Pet(petId, updateCategory, "Hank", updatePhotoUrls, updateTags,
// updateStatus);
//        Pet updatePetResponse = updateAnExistingPet(updatePetRequest);
//
//        //Step 3: Assertions
//        assertThat(updatePetResponse.getName(), is(equalTo("Hank")));
//    }
//
//    @Test
//    public void updateAnNonExistingPet(){}
//    @Test
//    public void updateAPetWithoutMandatoryFields(){}
// }
