package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        ArrayList<Person> people = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // chosen file!!

                inFile = new Scanner(target.toFile());

                System.out.printf("%-8s %-15s %-15s %-10s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==========================================================");

                while (inFile.hasNextLine()) {
                    String line = inFile.nextLine().trim();

                    String[] piece = line.split(",");

                    String id = piece[0];
                    String firstName = piece[1];
                    String lastName = piece[2];
                    String title = piece[3];
                    int birthYear = Integer.parseInt(piece[4].trim());

                    Person p = new Person(firstName, lastName, id, title, birthYear);
                    people.add(p);


                    System.out.printf("%-8s %-15s %-15s %-10s %-6d%n",
                            p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
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