package model;

import java.time.LocalDate;

public class Sale {
    public String saleId;
    public String medicineId;
    public String buyerId;
    public LocalDate purchaseDate;
    public int quantity;

    public Sale(String saleId, String medicineId, String buyerId, LocalDate purchaseDate, int quantity) {
        this.saleId = saleId;
        this.medicineId = medicineId;
        this.buyerId = buyerId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

    public String toCSV() {
        return saleId + "," + medicineId + "," + buyerId + "," + purchaseDate + "," + quantity;
    }

    public static Sale fromCSV(String line) {
        String[] parts = line.split(",");
        return new Sale(parts[0], parts[1], parts[2], LocalDate.parse(parts[3]), Integer.parseInt(parts[4]));
    }
}
