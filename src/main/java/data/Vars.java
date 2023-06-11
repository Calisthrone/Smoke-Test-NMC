package data;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Vars {

    public static String orderNumber; // number of the order placed

    // these dara are the expected data of a product according to the data source
    public static String searchName_AR = ""; // search product name in Arabic
    public static String fullName_AR = ""; // product full name in Arabic
    public static String position = ""; // product position in search results
    public static double price = 0; // price of the product
    public static String sku = "";

    public static double actualCartValue = 0.00; // actual -> to be read from the cart itself
    public static double expectedCartValue = 0.00; // expected -> calculated

    public static String addToCartMessage = ""; // the content of the pop-up message that appears after adding item to cart.

    public static int actualCartCount = 1000; // actual cart quantity, being read from the number in the cart icon.
    public static int expectedCartCount = 1000; // mathematically calculated cart count.

    public static int actualQuantityToAdd = 0; // actual quantity to add, being read from the counter between + & - buttons.
    public static int expectedQuantityToAdd = 1; // mathematically calculated by clicking + & - buttons.

    public static List<WebElement> searchResultElementList; // contains all elements of found results
    public static int searchResultsCount; // number of search results found after search
}