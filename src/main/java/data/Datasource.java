package data;

import entity.Product;

import java.util.ArrayList;

public interface Datasource {

    // any class that would read data of Product should implement this interface
    // the accepted data type to be returned should always be ArrayList<Products>

    ArrayList<Product> getProductsList();
}