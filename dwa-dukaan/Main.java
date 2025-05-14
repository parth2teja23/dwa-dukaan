import pages.MedicinePage;
import pages.BuyerPage; // add at the top
import pages.SalePage;  // Add at the top


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Medicine Management System ---");
            System.out.println("1. Medicine Management");
            System.out.println("2. Buyer Management");
            System.out.println("3. Sales");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MedicinePage.menu();
                    break;
                case 2:
                    BuyerPage.menu();
                    break;

                case 3:
                    SalePage.menu();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
