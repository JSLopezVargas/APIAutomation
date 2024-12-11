package placeHolder.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import placeHolder.models.InfoDataModel1;
import placeHolder.questions.ObjectUser;
import placeHolder.tasks.PostPlaceHolderTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static placeHolder.constants.Constants.URL_Base;

public class placeHolderStepDefinitions {

    @When("the user sends a request using the {string} with {string} {string} and {string}")
    public void theUserSendsARequestUsingTheWithAnd(String endpoint, String name, String email, String age) {
        String restAPIUrl = URL_Base;
        Actor user = Actor.named("Steven").whoCan(CallAnApi.at(restAPIUrl));
        ObjectUser objectUser = new ObjectUser(name, email, age);
        InfoDataModel1 InfoDataModel1 = objectUser.answeredBy(null);

        System.out.println(InfoDataModel1);

        user.attemptsTo(

                PostPlaceHolderTask.withUserData(InfoDataModel1, endpoint)

        );

    }

    @Then("validates the {string} response")
    public void validatesTheResponse(String code) {

        Actor User = Actor.named("Steven");

        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        User.should(
                seeThat("The response code is", res -> codeRest, equalTo(code))
        );

    }

    @And("validates the expected {string}")
    public void validatedTheID(String id) {

        Actor User = Actor.named("Steven");

        String actualId = String.valueOf(SerenityRest.lastResponse().jsonPath().getInt("id"));
        User.should(
                seeThat("The response id is", res -> actualId, equalTo(id))
        );

    }
}