package Locators;

import org.openqa.selenium.By;

public interface LoginLoc {

    By usernameFieldLocator = By.xpath("//*[@id=\"username\"]");
    By passwordFieldLocator = By.xpath("//*[@id=\"plaintextPassword\"]");
    By loginButtonLocator = By.xpath("//input[@id=\"loginbutton\"]");
}
