package co.com.wearedev.certificacion.challenge.tasks;

import co.com.wearedev.certificacion.challenge.interactions.SelectedRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.wearedev.certificacion.challenge.userinterfaces.HomePage.*;

public class AddTheCar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(SelectedRandom.aProduct());
        actor.attemptsTo(Click.on(SHOPPING_CART));


        actor.remember("price", PRICE_PRODUCT.resolveFor(actor).getText().replace("$",""));
        actor.attemptsTo(Click.on(CHECKOUT_OPTION));
    }


    public static AddTheCar aProduct() {

        return Tasks.instrumented(AddTheCar.class);
    }
}
