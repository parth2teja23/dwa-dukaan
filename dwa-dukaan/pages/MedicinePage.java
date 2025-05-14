package pages;

import model.Medicine;
import data.FileHandler;

import java.util.*;

public class MedicinePage {
    private static final String FILE_PATH = "medicines.csv";
    private static Map<String, Medicine> medicines = new HashMap<>();

    static {
        medicines = FileHandler.loadMedicines(FILE_PATH);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Medicine Menu ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. View All Medicines");
            System.out.println("3. Save & Go Back");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addMedicine(sc);
                    break;
                case 2:
                    viewMedicines();
                    break;
                case 3:
                    FileHandler.saveMedicines(FILE_PATH, medicines);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMedicine(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt(); sc.nextLine();

        Medicine m = new Medicine(id, name, java.time.LocalDate.parse(dateStr), qty);
        medicines.put(id, m);
        System.out.println("Medicine added.");
    }

    private static void viewMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("No medicines found.");
            return;
        }
        for (Medicine m : medicines.values()) {
            System.out.println("ID: " + m.id + " | Name: " + m.name + " | Expiry: " + m.expiryDate + " | Qty: " + m.quantity);
        }
    }
}
