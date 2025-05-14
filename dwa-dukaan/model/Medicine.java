package model;

import java.time.LocalDate;

public class Medicine {
    public String id, name;
    public LocalDate expiryDate;
    public int quantity;

    public Medicine(String id, String name, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public String toCSV() {
        return id + "," + name + "," + expiryDate + "," + quantity;
    }

    public static Medicine fromCSV(String line) {
        String[] parts = line.split(",");
        return new Medicine(parts[0], parts[1], LocalDate.parse(parts[2]), Integer.parseInt(parts[3]));
    }
}
