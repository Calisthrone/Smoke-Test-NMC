package Super;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class SuperTest {

    public static WebDriver driver;

    public static CartPage cartPage;
    public static HomePage homePage;
    public static LoginPage loginPage;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://www.nahdionline.com/ar");
    }

    // this method will return an instance of the static driver used everywhere in project.
    public static WebDriver getDriver() {return driver;}
}