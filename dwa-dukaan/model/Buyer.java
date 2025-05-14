package model;

public class Buyer {
    public String id;
    public String name;
    public String contactInfo;

    public Buyer(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String toCSV() {
        return id + "," + name + "," + contactInfo;
    }

    public static Buyer fromCSV(String line) {
        String[] parts = line.split(",", 3); // Ensure contactInfo with commas works
        return new Buyer(parts[0], parts[1], parts[2]);
    }
}
