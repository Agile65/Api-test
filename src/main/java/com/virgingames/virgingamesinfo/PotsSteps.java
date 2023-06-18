package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;

//  PotsSteps class to write methods, which have been used within cucumber steps
public class PotsSteps {

    // ValidatableResponse allows you to log different parts of the Response
    static ValidatableResponse response;

    //@Step annotation shows the step info in Serenity Report

    @Step("Getting all pots information")
    public ValidatableResponse getAllPotsInfo(){

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_POTS)
                .then().statusCode(200);

    }

    @Step("Getting all pots information where currency is GBP")
    public ValidatableResponse getAllPotsGBP(){

        return SerenityRest.given().log().all()
                .when()
                .queryParam("currency","GBP")
                .get(EndPoints.GET_ALL_POTS)
                .then().statusCode(200);

    }

    @Step("Getting all pots information where currency is EUR")
    public ValidatableResponse getAllPotsEUR(){

        return SerenityRest.given().log().all()
                .when()
                .queryParam("currency","EUR")
                .get(EndPoints.GET_ALL_POTS)
                .then().statusCode(200);
    }

    @Step("Getting all pots information where currency is SEK")
    public ValidatableResponse getAllPotsSEK(){

        return SerenityRest.given().log().all()
                .when()
                .queryParam("currency","SEK")
                .get(EndPoints.GET_ALL_POTS)
                .then().statusCode(200);
    }

    @Step("Verify pot name by it's id")
    public void getToVerifyPotIdWithName(){

        response= getAllPotsInfo();

        response
                .body("data.pots[1]", hasEntry("id", "bouncy_bubbles_id"))
                .body("data.pots[1]", hasEntry("name", "play-bouncy-bubbles"));
        response.log().all().statusCode(200);

    }

    @Step("Verify total number of the records")
    public void getTotalRecords(){
        response= getAllPotsInfo();
        int total=43;
        int size = response.extract().path("data.pots.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of records are : " +size);
        System.out.println("------------------End of Test---------------------------");

        Assert.assertEquals(total,size);
    }
}
