package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("Hello! Please enter the data for your products as prompted.");
        String fileName = "main/ProductTestData.txt";

        boolean done = false;

        while (!done) {

            String id = SafeInput.getRegExString(in, "Enter main.Product ID", "\\d+");
            String name = SafeInput.getNonZeroLenString(in, "Enter main.Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter main.Product Description");
            double cost = SafeInput.getDouble(in, "Enter main.Product Cost");


            Product p = new Product( id, name, description, cost);
            products.add(p);


            done = !SafeInput.getYNConfirm(in, "Would you like to enter another product? (Y/N)");
        }


        try (FileWriter writer = new FileWriter(fileName))
        {
            for (Product p : products) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Successfully saved " + fileName);
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}