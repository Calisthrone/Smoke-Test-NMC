package data;

import entity.Product;

import java.util.ArrayList;

public interface Datasource {

    ArrayList<Product> getProductsList();
}