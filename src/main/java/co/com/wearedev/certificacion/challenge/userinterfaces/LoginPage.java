package co.com.wearedev.certificacion.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static Target USER_FILE = Target.the("username").located(By.id("user-name"));
    public static Target PASSWORD_FILE = Target.the("password").located(By.id("password"));
    public static Target BUTTON_LOGIN = Target.the("button login").located(By.id("login-button"));

}
