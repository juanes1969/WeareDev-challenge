package co.com.wearedev.certificacion.challenge.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Random;

import static co.com.wearedev.certificacion.challenge.userinterfaces.HomePage.*;

public class SelectedRandom implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random rand = new Random();
        List<WebElementFacade> listElement = PRODUCTS.resolveAllFor(actor);
        WebElementFacade elemet = listElement.get(rand.nextInt(listElement.size()));

        actor.attemptsTo(Click.on(elemet));

    }


    public static SelectedRandom aProduct() {

        return Tasks.instrumented(SelectedRandom.class);
    }
}
