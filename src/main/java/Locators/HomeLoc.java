package Locators;

import org.openqa.selenium.By;

public interface HomeLoc {

    String homepageURL_AR = "https://www.nahdionline.com/ar";
    By acceptCookiesButtonLocator = By.xpath("//a[@aria-label='allow cookies']");
    By loginButtonLocator = By.xpath("//li[@class='authorization-link']");

    By cartCounterLocator = By.xpath("//span[@class='counter-number']");

    By customerNameLocator = By.xpath("//span[@class='customer-name']/span");
    By searchFieldLocator = By.xpath("//input[@id=\"search\"]");
    By searchResultsContainer = By.xpath("//ol[@class=\"ais-Hits-list\"]");
}
