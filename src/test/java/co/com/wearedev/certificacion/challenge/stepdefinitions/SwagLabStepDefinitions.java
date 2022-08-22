package co.com.wearedev.certificacion.challenge.stepdefinitions;

import co.com.wearedev.certificacion.challenge.models.Data;
import co.com.wearedev.certificacion.challenge.questions.ValidateLogin;
import co.com.wearedev.certificacion.challenge.tasks.AddTheCar;
import co.com.wearedev.certificacion.challenge.tasks.EnterShippingInformation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.wearedev.certificacion.challenge.questions.ValidateOrder.validateOrder;
import static co.com.wearedev.certificacion.challenge.questions.ValidateTotalPrice.validateTotalPrice;
import static co.com.wearedev.certificacion.challenge.tasks.LoginInTheSwagLab.loginInTheSwagLab;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SwagLabStepDefinitions {


    @Given("^(.*) login in the swag lab page$")
    public void userLoginInTheSwagLabPage(String actor, List<Data> listData) {
        theActorCalled(actor).wasAbleTo(loginInTheSwagLab(listData.get(0)));
    }


    @Then("^Validate application login$")
    public void validateApplicationLogin() {
        theActorInTheSpotlight().should(seeThat(ValidateLogin.inThePage()));
    }

    @When("^the user adds a product to the cart$")
    public void theUserAddsAProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(AddTheCar.aProduct());
    }

    @When("^goes to enter your payment information$")
    public void goesToEnterYourPaymentInformation(List<Data> lisData) {
        theActorInTheSpotlight().attemptsTo(EnterShippingInformation.inFields(lisData.get(0)));
    }

    @When("^and check the summary of your purchase$")
    public void andCheckTheSummaryOfYourPurchase() {
        theActorInTheSpotlight().should(seeThat(validateTotalPrice()));
    }

    @Then("^Verify successful delivery order message created$")
    public void verifySuccessfulDeliveryOrderMessageCreated() {
        theActorInTheSpotlight().should(seeThat(validateOrder()));
    }
}
