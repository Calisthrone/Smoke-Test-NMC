package locator;

import org.openqa.selenium.By;

public interface SuperLoc {

    By mainPageLocator = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/a");
    By cartLocator = By.xpath("//a[contains(@class,'showcart')]");

    By loadingMaskLocator = By.xpath("//div[@class='loading-mask']");
}
