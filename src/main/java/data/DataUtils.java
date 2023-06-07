package data;

import entity.Product;

import java.util.ArrayList;
import java.util.Random;

public class DataUtils {

    static DataReader dataReader = new DataReader();

    // this method should be called when we need to generate a random product.
    public static void randomizeProduct() {
        ArrayList<Product> productList = dataReader.getProductsList();

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(productList.size());

        Product randomProduct = productList.get(index);
        Vars.searchName_AR = randomProduct.search_AR();
        Vars.fullName_AR = randomProduct.fullName_AR();
        Vars.position = randomProduct.position();
        Vars.price = randomProduct.price();

//        System.out.println("setRandomProduct() called !");
//        System.out.println("searchName_AR = " + Vars.searchName_AR);
//        System.out.println("fullName_AR = " + Vars.fullName_AR);
//        System.out.println("position = " + Vars.position);
//        System.out.println("price = " + Vars.price);
    }
}