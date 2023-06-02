package Test;

import Super.SuperTest;
import org.testng.annotations.Test;

public class LoginTest extends SuperTest {

    @Test(priority = 1)
    public void prepareWebsite() {

        homePage
                .gotoHomepage()
                .acceptCookies()
                .gotoLoginPage();
    }

    // todo: test invalid login data after creating 'User' class
    @Test(priority = 2)
    public void testInvalidUser() {
        System.out.println("Not testing logging-in with invalid username yet!");
    }

    @Test(priority = 3)
    public void testValidLogin() {

        loginPage
                .enterUsername("calisthrone@gmail.com")
                .enterPassword("a0100350048");

        // todo: Assert - displayed customer name == stored Customer.firstName
    }
}