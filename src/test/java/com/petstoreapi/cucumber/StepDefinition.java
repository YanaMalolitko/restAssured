package com.petstoreapi.cucumber;

import com.petstoreapi.common.RestAssuredPetTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Yana on 9/18/2018.
 */
public class StepDefinition {

    @Given("^The pet store \"(.+)\" connection is available$")
    public void the_pet_store_http_petstore_swagger_io_v_connection_is_available(String siteLink ) throws Exception {
        RestAssuredPetTest.toCheckConnection (siteLink);
    }

    @When("^I add the pet profile information with \"(.+)\" to the \"(.+)\"$")
    public void i_add_the_pet_profile_information_with(int petID, String siteLink) throws Exception {
        RestAssuredPetTest.toPostPet (petID, siteLink);
    }

    @Then("^I am able to get the pet by \"(.+)\"$")
    public void i_am_able_to_get_the_pet_by_id(int petID) throws Exception {
        RestAssuredPetTest.toGetPet(petID);
    }

    @When("^I remove the pet profile information with \"(.+)\" from the \"(.+)\"$")
    public void i_remove_the_pet_profile_information_with_id(int petID, String siteLink) throws Exception {
        RestAssuredPetTest.toDeletePet(petID,siteLink);
    }

    @Then("^Pet with \"(.+)\" is not found in \"(.+)\"$")
    public void pet_with_id_is_not_found(int petID, String siteLink) throws Exception {
        RestAssuredPetTest.checkDeletion(petID,siteLink);
    }
}
