package pages;

import model.Sale;
import model.Medicine;
import model.Buyer;
import data.FileHandler;

import java.time.LocalDate;
import java.util.*;

public class SalePage {
    private static final String FILE_PATH = "sales.csv";
    private static Map<String, Sale> sales = new HashMap<>();
    private static Map<String, Medicine> medicines = FileHandler.loadMedicines("medicines.csv");
    private static Map<String, Buyer> buyers = FileHandler.loadBuyers("buyers.csv");

    static {
        sales = FileHandler.loadSales(FILE_PATH);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Sale Menu ---");
            System.out.println("1. Record a Sale");
            System.out.println("2. View All Sales");
            System.out.println("3. Save & Go Back");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    recordSale(sc);
                    break;
                case 2:
                    viewSales();
                    break;
                case 3:
                    FileHandler.saveSales(FILE_PATH, sales);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void recordSale(Scanner sc) {
        System.out.println("Choose a buyer:");
        for (Buyer b : buyers.values()) {
            System.out.println("ID: " + b.id + " | Name: " + b.name);
        }
        System.out.print("Enter Buyer ID: ");
        String buyerId = sc.nextLine();

        System.out.println("Choose a medicine:");
        for (Medicine m : medicines.values()) {
            System.out.println("ID: " + m.id + " | Name: " + m.name + " | Qty: " + m.quantity);
        }
        System.out.print("Enter Medicine ID: ");
        String medicineId = sc.nextLine();

        if (!buyers.containsKey(buyerId)) {
            System.out.println("Buyer not found.");
            return;
        }

        if (!medicines.containsKey(medicineId)) {
            System.out.println("Medicine not found.");
            return;
        }

        Medicine medicine = medicines.get(medicineId);
        if (medicine.quantity <= 0) {
            System.out.println("Insufficient quantity.");
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int qty = sc.nextInt();
        sc.nextLine(); // consume newline

        if (qty > medicine.quantity) {
            System.out.println("Not enough stock.");
            return;
        }

        String saleId = UUID.randomUUID().toString();
    Sale sale = new Sale(saleId, medicineId, buyerId, LocalDate.now(), qty);
    sales.put(saleId, sale);

    // Update medicine quantity
    medicine.quantity -= qty;

    // Save updated medicines back to file
    FileHandler.saveMedicines("medicines.csv", medicines);

    System.out.println("Sale recorded successfully.");

    }

    private static void viewSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales found.");
            return;
        }
        for (Sale s : sales.values()) {
            System.out.println("Sale ID: " + s.saleId + " | Medicine ID: " + s.medicineId + " | Buyer ID: " + s.buyerId + " | Date: " + s.purchaseDate + " | Quantity: " + s.quantity);
        }
    }
}
