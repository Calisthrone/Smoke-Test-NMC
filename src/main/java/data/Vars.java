package data;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Vars {

    public static String searchName_AR = "";
    public static String fullName_AR = "";
    public static String position = "";
    public static String price = "";

    public static String addToCartMessage = ""; // the content of the pop-up message that appears after adding item to cart.

    public static int actualCartCount = 1000; // actual cart quantity, being read from the number in the cart icon.
    public static int expectedCartCount = 1000; // mathematically calculated cart count.

    public static int actualQuantityToAdd = 0; // actual quantity to add, being read from the counter between + & - buttons.
    public static int expectedQuantityToAdd = 1; // mathematically calculated by clicking + & - buttons.

    public static List<WebElement> searchResultElementList; // contains all elements of found results
    public static int searchResultsCount; // number of search results found after search
}