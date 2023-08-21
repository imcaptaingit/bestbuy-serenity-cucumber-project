package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.model.StorePojo;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

/**
 * Author - Sarvat Shaikh
 * Project Name: bestbuy-serenity-cucumber-project
 */
public class bestbuyStoreEndPoints {
    static ValidatableResponse response;
    static int id;
    static String name = "Yazdaan";
    static String type = "CarpetShop";
    static String address = "283 London Road";
    static String address2 = "Leyton";
    static String city = "London";
    static String state = "Greater London";
    static String zip = "E11 4LL";
    static int lat = 45;
    static int lng = 90;
    static String hours ="Mon: 8-8; Tue: 8-8; Wed: 8-8; Thurs: 8-8; Fri: 8-8; Sat: 8-8; Sun: 8-8";
    private StorePojo.Services services;
    @Steps
    StoreSteps storeSteps;
    @When("^User sends a GET request to stores endpoint$")
    public void userSendsAGETRequestToStoresEndpoint() {
        response = storeSteps.getAllStoreInfo();
    }

    @When("^User sends a POST request by providing the information to stores endpoint$")
    public void userSendsAPOSTRequestByProvidingTheInformationToStoresEndpoint() {
        response = storeSteps.createStore(name, type, address,address2, city, state, zip, lat, lng, hours,services);
        id = response.extract().path("id");
    }
    @Then("^User must get back valid status code 201 for post request$")
    public void userMustGetBackValidStatusCodeForPostRequest() {
        response.statusCode(201);
    }

    @When("^User sends a PUT request by providing the information to stores/id endpoint$")
    public void userSendsAPUTRequestByProvidingTheInformationToStoresIdEndpoint() {
        name = name + "_Updated";
        response = storeSteps.updateStore(id,name, type, address,address2, city, state, zip, lat, lng, hours,services);
    }

    @When("^User sends a DELETE request to stores/id endpoint$")
    public void userSendsADELETERequestToStoresIdEndpoint() {
        storeSteps.deleteStore(id);
    }
}
