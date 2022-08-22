package co.com.wearedev.certificacion.challenge.tasks;

import co.com.wearedev.certificacion.challenge.models.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.wearedev.certificacion.challenge.userinterfaces.LoginPage.*;
import static co.com.wearedev.certificacion.challenge.utils.Constants.URL;

public class LoginInTheSwagLab implements Task {


    private final Data data;

    public LoginInTheSwagLab(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL),
                Enter.theValue(data.getUser()).into(USER_FILE),
                Enter.theValue(data.getPassword()).into(PASSWORD_FILE),
                Click.on(BUTTON_LOGIN));
    }

    public static LoginInTheSwagLab loginInTheSwagLab(Data data) {
        return Tasks.instrumented(LoginInTheSwagLab.class, data);
    }

}
