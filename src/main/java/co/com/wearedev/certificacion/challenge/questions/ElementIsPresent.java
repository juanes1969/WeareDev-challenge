package co.com.wearedev.certificacion.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementIsPresent implements Question<Boolean> {
    private Target element;

    public ElementIsPresent(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isEnabled();
    }

    public static ElementIsPresent elementIsPresent(Target element) {
        return new ElementIsPresent(element);
    }

}
