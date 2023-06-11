package data;

import entity.Product;

import java.util.ArrayList;
import java.util.Random;

public class DataUtils {

    static TextDatasource textDatasource = new TextDatasource();

    // this method should be called when we need to generate a random product.
    public static void randomizeProduct() {
        ArrayList<Product> productList = textDatasource.getProductsList();

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(productList.size());
        Product randomProduct = productList.get(index);

        Vars.searchName_AR = randomProduct.search_AR();
        Vars.fullName_AR = randomProduct.fullName_AR();
        Vars.position = randomProduct.position();
        Vars.price = randomProduct.price();
        Vars.sku = randomProduct.sku();
    }
}