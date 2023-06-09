# Smoke-test-NMC
`Uncompleted`

This is a test automation project for NMC.

Using Selenium Web Driver (JAVA) and TestNG to manage tests.

And implementing POM design architecture. Data-Driven.

- ## Note
The readme description will be updated incrementally updated.

So every commit will include the newly added feature.

When all features are implemented, I will mark it `Completed` at the top.

- ## Project Usage
This project is intended to be used as a `test Scenario Based` or as a `Unit test Based`. 
This is because the test workflow is designed to accommodate with both cases. 
In the `SuperClass` a `@BeforeSuite` method is defined to just setup the driver and then goto homepage. 
From the homepage you can set up a `Scenario-Based test` by scripting a manual test case, 
or just run a `Unit test` for a specific module.

Note that any `Unit test` test case will have a `// UNIT` comment before the `@test` annotation.

```
    // UNIT
    @test(priority = 1)
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
    @test(priority = 1)
    public void prepareWebsite() {

        homePage
                .gotoHomepage()
                .acceptCookies()
                .gotoLoginPage();
    }
```
In the above code snippet, you can see the simplicity of creating a test case, no need to initialize the page object. 
And the process is very understandable by any one.

### `locator Interfaces`
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

Login test is now integrated in the pre-suite test preparation.
This step was made to give more support toward Unit Testing and Module-Specific-Validation as most of the
app functionality 'except for search' is dependent on being in logged-in state.

~~Will test the login module. Using invalid and valid data.~~

~~`invalidLogin` asserts the presence of invalid login events when executed. (invalid login)~~

~~`validLogin` asserts the appearance of the expected customer name corresponding to the membership. (valid login)~~

##
### `PurgeTest`
This will read if any items are in the shopping cart, 
if cart is not empty it will goto cart and then delete all items and confirm deletion process.

`cartIsEmpty` asserts cart is empty after the purge.

`accuracyOfCartCount` asserts actual and expected cart count quantities are equal.

##
### `SearchTest`
This will perform search test on both invalid inputs and valid inputs.

`noResultsFound` asserts the presence of no-item-found message. (invalid input)

`resultsAreFound` asserts the appearance of items in search results. (valid input)

`searchResultsAccuracy` asserts the accuracy of search results. (valid input)

```
validation Results Accuracy.
Expected :100%
Actual   :88%
```

##
### `AddToCartTest`
This will perform two main tests, add to cart from homepage and add to cart from product page.

`itemIsActuallyAdded` asserts the pop-up message appearance when item is added and the inclusion of related item name in it.

`accuracyOfQuantitiesAdded` assert the displayed quantities to add is equal to the expected ones.

`accuracyOfCartCount` asserts actual and expected cart count quantities are equal, after adding to cart.

##
### `Cart Test`

`cartValueAccuracy` asserts the cart actual value against the expected value.

##
### `Order Test`
In this test, we will proceed to check out, select the current client location on map, continue to payment and choose COD for now. and then proceed and create a pickup order.

`validOrderNumber` asserts the creation of a successful order.

##
### `Future Plans`
There will be some upgrades to the tests to include:

Adding and removing items from favourite.

Search more complex criteria with sorting.

Reordering a previous order from history.

Modifying customer data.

Request chronic medication refill.

...

That's it for now.
