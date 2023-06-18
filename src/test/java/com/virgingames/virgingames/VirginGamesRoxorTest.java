package com.virgingames.virgingames;

import com.virgingames.testbase.TestBase;
import com.virgingames.virgingamesinfo.PotsSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasEntry;


@RunWith(SerenityRunner.class)
public class VirginGamesRoxorTest extends TestBase {

    @Steps
    PotsSteps potsSteps;
    static ValidatableResponse response;

    @Title("This will get all the information about all Pots")
    @Test
    public void getAllInformation(){
        response= potsSteps.getAllPotsInfo();
        response.log().all().statusCode(200);
    }

    @Title("This will get all the information about Pots where currency is GBP")
    @Test
    public void getAllInformationGBP(){
        response= potsSteps.getAllPotsGBP();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("GBP"));
    }

    @Title("This will get all the information about Pots where currency is EUR")
    @Test
    public void getAllInformationEUR(){
        response= potsSteps.getAllPotsEUR();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("EUR"));
    }

    @Title("This will get all the information about Pots where currency is SEK")
    @Test
    public void getAllInformationSEK(){
        response= potsSteps.getAllPotsSEK();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("SEK"));
    }

    @Title("This will verify pot name by it's id")
    @Test
    public void getToVerifyPotIdWithName(){
        response= potsSteps.getAllPotsInfo();

        response
                .body("data.pots[1]", hasEntry("id", "bouncy_bubbles_id"))
                .body("data.pots[1]", hasEntry("name", "play-bouncy-bubbles"));
        response.log().all().statusCode(200);

    }

    @Title("This will verify total number of the records")
    @Test
    public void getTotalRecords(){
        response= potsSteps.getAllPotsInfo();
        int total=43;
        int size = response.extract().path("data.pots.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of records are : " +size);
        System.out.println("------------------End of Test---------------------------");

        Assert.assertEquals(total,size);
    }

}
