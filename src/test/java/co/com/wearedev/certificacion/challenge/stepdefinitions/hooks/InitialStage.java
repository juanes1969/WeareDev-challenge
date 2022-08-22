package co.com.wearedev.certificacion.challenge.stepdefinitions.hooks;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class InitialStage {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }
}
