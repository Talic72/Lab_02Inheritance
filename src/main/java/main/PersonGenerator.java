package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        System.out.println("Hello! Please enter the data for your persons as prompted.");
        String fileName = "main/PersonTestData.txt";

        boolean done = false;

        while (!done) {

            String id = SafeInput.getRegExString(in, "Enter ID number", "\\d+");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr, Ms, Dr, etc.)");
            int birthYear = SafeInput.getInt(in, "Enter Birth Year (1940 - 2010)");

        // object creation
            Person p = new Person(firstName, lastName, id, title, birthYear);
            people.add(p);

            // continue?
            done = !SafeInput.getYNConfirm(in, "Would you like to enter another record? (Y/N)");
        }


        try (FileWriter writer = new FileWriter(fileName)) {
            for (Person p : people) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Successfully saved " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
