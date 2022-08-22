package co.com.wearedev.certificacion.challenge.tasks;

import co.com.wearedev.certificacion.challenge.models.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.wearedev.certificacion.challenge.userinterfaces.ShippingInformationPage.*;

public class EnterShippingInformation implements Task {

    private Data data;

    public EnterShippingInformation(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.getFirstName()).into(FIRST_NAME),
                Enter.theValue(data.getLastName()).into(LAST_NAME),
                Enter.theValue(data.getPostalCode()).into(POSTAL_CODE),
                Click.on(BUTTON_CONTINUE)
        );
    }

    public static EnterShippingInformation inFields(Data data) {
        return Tasks.instrumented(EnterShippingInformation.class, data);
    }
}
