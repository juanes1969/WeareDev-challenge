package co.com.wearedev.certificacion.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShippingInformationPage {

    public static Target FIRST_NAME = Target.the("first name").located(By.id("first-name"));
    public static Target LAST_NAME = Target.the("last name").located(By.id("last-name"));
    public static Target POSTAL_CODE = Target.the("postal code").located(By.id("postal-code"));
    public static Target BUTTON_CONTINUE = Target.the("button continue").located(By.id("continue"));
    public static Target SUMARY_TAX_LABEL = Target.the("Sumary tax label").located(By.className("summary_tax_label"));
    public static Target TOTAL_PARTIAL = Target.the("Total partial").located(By.className("summary_total_label"));
    public static Target ITEM_TOTAL = Target.the("Item total").located(By.className("summary_subtotal_label"));
    public static Target ORDER_CHECKOUT = Target.the("Order received title").located(By.xpath("//*/h2"));
    public static Target FINISH_BUTTON = Target.the("Finish button").located(By.id("finish"));
}
