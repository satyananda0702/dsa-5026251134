package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/lab1/rentals.txt");
        if (!file.exists()) {
          file = new File("rentals.txt");
        }

        try (Scanner scanner = new Scanner(file)) {
            int n = scanner.nextInt();

            Rental[] rentals = new Rental[n];
            int[] units = new int[n]; 

            for (int i =0; i < n; i++){
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                units[i] = scanner.nextInt();

                if (type.equals("LAPTOP")) {
                    rentals[i] = new laptopRental(id, days);
                } else if (type.equals("PROJECTOR")) {
                    rentals[i] = new projectorRental(id, days);
                } else {
                    throw new IllegalArgumentException("Unknown type: " + type);
                }
            }

            for (int i = 0; i < n; i++) {
                Rental r = rentals[i];
                System.out.println(r.getId() + " | " + r.label() + " | " + r.calculateCharge(units[i]));
            }
        } catch (FileNotFoundException e) {

            System.out.println("File rentals.txt not found.");

        }
    }
}