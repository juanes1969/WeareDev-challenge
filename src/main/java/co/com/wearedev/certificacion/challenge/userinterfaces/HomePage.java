package co.com.wearedev.certificacion.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static Target TITLE_LOGIN = Target.the("Title page").located(By.className("app_logo"));
    public static Target PRODUCTS = Target.the("Products home page {0}").located(By.xpath("//div/button[contains(text(),'Add to cart')]"));
    public static Target SHOPPING_CART = Target.the("Shopping cart").located(By.className("shopping_cart_link"));
    public static Target CHECKOUT_OPTION = Target.the("Checkout option").located(By.id("checkout"));
    public static Target PRICE_PRODUCT = Target.the("Price product").located(By.className("inventory_item_price"));
}
