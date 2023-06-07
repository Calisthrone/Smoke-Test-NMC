package data;

import entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader implements Datasource {

    @Override
    public ArrayList<Product> getProductsList() {

        ArrayList<Product> productsInFile = new ArrayList<>();
        String fileName = "data-products.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String currentLine;
            while ((currentLine = br.readLine()) != null){

                // separating the data by the comma
                String[] singleLineArray = currentLine.split(",");

                // for csv files
                // Skipping the first line since it has only titles and no the data I want to store
                if(singleLineArray[0].startsWith("!STRUCTURE!"))
                    continue;

                // Store data in variables.
                String search_EN = singleLineArray[0];
                String fullName_EN = singleLineArray[1];
                String position = singleLineArray[2];
                String price = singleLineArray[3];
                String sku = singleLineArray[4];
                String search_AR = singleLineArray[5];
                String fullName_AR = singleLineArray[6];

                //adding the data to the arraylist
                productsInFile.add(new Product(search_EN, fullName_EN, position, price, sku, search_AR, fullName_AR));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return productsInFile;
    }
}
