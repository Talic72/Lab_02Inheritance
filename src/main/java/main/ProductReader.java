package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        ArrayList<Product> products = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // chosen file!!

                inFile = new Scanner(target.toFile());

                System.out.printf("%-8s %-20s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("================================================================");

                while (inFile.hasNextLine()) {
                    String line = inFile.nextLine().trim();

                    String[] piece = line.split(",");

                    String id = piece[0];
                    String name = piece[1];
                    String description = piece[2];
                    double cost = Double.parseDouble(piece[3].trim());

                    Product p = new Product(name, description, id, cost);
                    products.add(p);

                    System.out.printf("%-8s %-20s %-30s $%-10.2f%n",
                            p.getID(), p.getName(), p.getDescription(), p.getCost());
                }

                inFile.close();

            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}