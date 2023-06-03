# Smoke-Test-NMC
`Uncompleted`

This is a test automation project for NMC.

Using Selenium Web Driver (JAVA) and TestNG to manage tests.

And implementing POM design architecture.

- ## Note
The readme description will be updated incrementally updated.

So every commit will include the newly added feature.

When all features are implemented, I will mark it `Completed` at the top.

- ## Project Usage
This project is intended to be used as a `Test Scenario Based` or as a `Unit Test Based`. 
This is because the test workflow is designed to accommodate with both cases. 
In the `SuperClass` a `@BeforeSuite` method is defined to just setup the driver and then goto homepage. 
From the homepage you can setup a `Scenario-Based Test` by scripting a manual test case, 
or just run a `Unit Test` for a specific module.

Note that any `Unit Test` test case will have a `// UNIT` comment before the `@Test` annotation.

```
    // UNIT
    @Test(priority = 1)
    public void searchForUnavailableItem() {
        homePage
                .searchFor("impossibleToFindText");

        // Assertion
        Asserting.assertNoResultsFound();

        homePage
                .gotoHomepage(); // go to homepage (after assertion) to make another search test
    }
```

- ## Key Files
- `SuperPage` The superclass for all page objects, contains all common methods used in page objects.
- `SuperTest` The superclass for all test classes, driver setup and page instance initiation take place here.
- `Asserting` Contains all assert methods, to make thing simple while executing test cases.

- ## Internal Architecture
### `WebDriver`
I wanted to make sure that one instance of the `WebDriver` is used in the whole project,
so the driver is defined as `static` in the `SuperTest.class` and never defined again in any part of the project.
This made the process much easier and error-free.

### `PageObject Instances`
The same goes with the instances of the page objects. Instead of defining an instance in every test case, 
I made the instances initialized in the `SuperTest.class` and made them `static` so they never need to be initialized again. 
Again this made the process more straight forward without affecting the performance.

```
    @Test(priority = 1)
    public void prepareWebsite() {

        homePage
                .gotoHomepage()
                .acceptCookies()
                .gotoLoginPage();
    }
```
In the above code snippet, you can see the simplicity of creating a test case, no need to initialize the page object. 
And the process is very understandable by any one.

### `Locators Interfaces`
For separation of areas of concerns, I added each page object locators in a corresponding interface, 
the page object will implement this interface for fast and clean access of locators.

```
public class LoginPage extends SuperPage implements LoginLoc {
```

```
public interface LoginLoc {
    By usernameFieldLocator = By.xpath("//*[@id=\"username\"]");
    By passwordFieldLocator = By.xpath("//*[@id=\"plaintextPassword\"]");
    By loginButtonLocator = By.xpath("//input[@id=\"loginbutton\"]");
}
```

- ## Tests
### `LoginTest`
Will test the login module. Using invalid and valid data.

`invalidLogin` asserts the presence of invalid login events when executed. (invalid login)

`validLogin` asserts the appearance of the expected customer name corresponding to the membership. (valid login)

### `PurgeTest`
This will read if any items are in the shopping cart, 
if cart is not empty it will goto cart and then delete all items and confirm deletion process.

`cartIsEmpty` asserts cart is empty after the purge.

`actualExpectedCartCountEquality` asserts actual and expected cart count quantities are equal.

### `SearchTest`
This will perform search test on both invalid inputs and valid inputs.

`assertNoResultsFound` asserts the presence of no-item-found message. (invalid input)

`assertResultsAreFound` asserts the appearance of items in search results. (valid input)

`assertSearchResultsAccuracy` asserts the accuracy of search results. (valid input)

```
Assert Results Accuracy.
Expected :100%
Actual   :88%
```
