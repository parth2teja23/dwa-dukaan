package pages;

import model.Buyer;
import data.FileHandler;

import java.util.*;

public class BuyerPage {
    private static final String FILE_PATH = "buyers.csv";
    private static Map<String, Buyer> buyers = new HashMap<>();

    static {
        buyers = FileHandler.loadBuyers(FILE_PATH);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Buyer Menu ---");
            System.out.println("1. Add Buyer");
            System.out.println("2. View All Buyers");
            System.out.println("3. Save & Go Back");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addBuyer(sc);
                    break;
                case 2:
                    viewBuyers();
                    break;
                case 3:
                    FileHandler.saveBuyers(FILE_PATH, buyers);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBuyer(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Info: ");
        String contact = sc.nextLine();

        buyers.put(id, new Buyer(id, name, contact));
        System.out.println("Buyer added.");
    }

    private static void viewBuyers() {
        if (buyers.isEmpty()) {
            System.out.println("No buyers found.");
            return;
        }
        for (Buyer b : buyers.values()) {
            System.out.println("ID: " + b.id + " | Name: " + b.name + " | Contact: " + b.contactInfo);
        }
    }
}
