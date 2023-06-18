package com.virgingames.cucumber.steps;

import com.virgingames.virgingamesinfo.PotsSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class VirginGameSteps {

    static ValidatableResponse response;

    @Steps
    PotsSteps potsSteps;

    @When("User sends a GET request to roxor endpoint")
    public void userSendsAGETRequestToRoxorEndpoint() {
        response=potsSteps.getAllPotsInfo();
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^User sends a GET request with GBP query parameter to roxor endpoint$")
    public void userSendsAGETRequestWithGBPQueryParameterToRoxorEndpoint() {
        potsSteps.getAllPotsGBP();
    }

    @Then("^User should see currency in GBP and status code 200$")
    public void userShouldSeeCurrencyInGBPAndStatusCode() {
        response.statusCode(200);
    }

    @When("^User sends a GET request with EUR query parameter to roxor endpoint$")
    public void userSendsAGETRequestWithEURQueryParameterToRoxorEndpoint() {
        potsSteps.getAllPotsEUR();
    }

    @Then("^User should see currency in EUR and status code 200$")
    public void userShouldSeeCurrencyInEURAndStatusCode() {
        response.statusCode(200);
    }

    @When("^User sends a GET request with SEK query parameter to roxor endpoint$")
    public void userSendsAGETRequestWithSEKQueryParameterToRoxorEndpoint() {
        potsSteps.getAllPotsSEK();
    }

    @Then("^User should see currency in SEK and status code 200$")
    public void userShouldSeeCurrencyInSEKAndStatusCode() {
        response.statusCode(200);
    }

    @Then("^User can see id and name matching as per the scenario$")
    public void userCanSeeIdAndNameMatchingAsPerTheScenario() {
        potsSteps.getToVerifyPotIdWithName();
    }

    @Then("^User can see total records are 43")
    public void userCanSeeTotalRecordsAre() {
        potsSteps.getTotalRecords();
    }
}
