package co.com.wearedev.certificacion.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;

import static co.com.wearedev.certificacion.challenge.questions.ElementIsPresent.elementIsPresent;
import static co.com.wearedev.certificacion.challenge.userinterfaces.HomePage.*;

public class ValidateLogin implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(GivenWhenThen.seeThat(elementIsPresent(TITLE_LOGIN)));
        return true;
    }

    public static ValidateLogin inThePage() {
        return new ValidateLogin();
    }
}
