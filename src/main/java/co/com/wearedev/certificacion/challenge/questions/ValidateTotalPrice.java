package co.com.wearedev.certificacion.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.wearedev.certificacion.challenge.userinterfaces.ShippingInformationPage.*;

public class ValidateTotalPrice implements Question<Boolean> {
    private String tax;
    private String itemTotal;
    private String totalPartial;
    private float totalFinal;

    @Override
    public Boolean answeredBy(Actor actor) {
        tax = SUMARY_TAX_LABEL.resolveFor(actor).getText().replace("Tax: $", "").trim();
        itemTotal = ITEM_TOTAL.resolveFor(actor).getText().replace("Item total: $", "").trim();
        totalPartial = TOTAL_PARTIAL.resolveFor(actor).getText().replace("Total: $", "").trim();
        totalFinal = Float.valueOf(tax) + Float.valueOf(itemTotal);

        Ensure.that(totalPartial).isEqualTo(String.valueOf(totalFinal));
        return true;
    }

    public static ValidateTotalPrice validateTotalPrice() {

        return new ValidateTotalPrice();
    }
}
