package co.com.wearedev.certificacion.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.wearedev.certificacion.challenge.questions.ElementIsPresent.elementIsPresent;
import static co.com.wearedev.certificacion.challenge.userinterfaces.ShippingInformationPage.FINISH_BUTTON;
import static co.com.wearedev.certificacion.challenge.userinterfaces.ShippingInformationPage.ORDER_CHECKOUT;

public class ValidateOrder implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Click.on(FINISH_BUTTON));
        actor.should(GivenWhenThen.seeThat(elementIsPresent(ORDER_CHECKOUT)));
        return true;
    }

    public static ValidateOrder validateOrder() {

        return new ValidateOrder();
    }
}
