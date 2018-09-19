package com.petstoreapi.serenity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.petStore.models.Category;
import com.petStore.models.Pet;
import com.petStore.models.Tag;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Yana on 9/18/2018.
 */
public class RestAssuredPetTest {

    static Pet pet = new Pet();
    Integer petId = pet.getId();

    @BeforeClass

    public static void createPet() {

        Category category = new Category();
        category.setId(9876);
        category.setName("Cat");
        Tag tag = new Tag();
        tag.setId(9876);
        tag.setName("Domestic");

        Pet pet = new Pet();
        pet.setId(9876);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tag));
        pet.setPhotoUrls(Arrays.asList("Url example 1"));
        pet.setStatus("available");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonPet = gson.toJson(pet);

    }


    @Step
    public static void toCheckConnection(String apiLink) {
//        RestAssured responce = new RestAssured();
        RestAssured.given()
                .contentType("application/json")
                .get(apiLink).
                then().
                statusCode(equalTo(200));


    }

    @Step
    public static void toPostPet(int petId, String siteLink) {
        Category category1 = new Category();
        category1.setId(petId);
        category1.setName("Cat");
        Tag tag2 = new Tag();
        tag2.setId(petId);
        tag2.setName("Domestic");

//        Pet pet1 = new Pet();
        pet.setId(9876);
        pet.setCategory(category1);
        pet.setTags(Arrays.asList(tag2));
        pet.setPhotoUrls(Arrays.asList("Url example 1", "Url Example 2"));
        pet.setStatus("available");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonPet = gson.toJson(pet);

        new RestAssured().given().contentType("application/json")
                .accept("application/json")
                .body(jsonPet)
                .post(siteLink)
                .then()
                .statusCode(200)
                .log();
    }

    @Step
    public static void toGetPet(int petId) {
        Integer id = pet.getId();

        Pet pet = new Pet();
        RestAssured.get("http://petstore.swagger.io/v2/pet/{id}", petId)
                .then().statusCode(200)
                .body("id", equalTo(9876))
                .body("status", equalTo("available"));

    }

    @Step
    public static void toDeletePet(int petId, String siteLink) {

        new RestAssured().given().accept("application/json").header("api_key", "special-key")
                .delete(siteLink +"/"+ petId)
                .then().statusCode(200);


    }

    @Step
    public static void checkDeletion (int petId, String siteLink)
    {
        RestAssured.get(siteLink+"/{id}", petId)
                .then().statusCode(404);
    }

}
