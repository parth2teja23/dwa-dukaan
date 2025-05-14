package data;

import model.Medicine;
import model.Buyer; // also make sure this import is at the top
import model.Sale; // make sure to import Sale at the top



import java.io.*;
import java.util.*;

public class FileHandler {

    public static Map<String, Medicine> loadMedicines(String path) {
        Map<String, Medicine> map = new HashMap<>();
        File file = new File(path);

        if (!file.exists()) return map;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Medicine m = Medicine.fromCSV(line);
                map.put(m.id, m);
            }
        } catch (IOException e) {
            System.out.println("Error loading medicines: " + e.getMessage());
        }

        return map;
    }
    public static Map<String, Sale> loadSales(String path) {
    Map<String, Sale> map = new HashMap<>();
    File file = new File(path);

    if (!file.exists()) return map;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            Sale s = Sale.fromCSV(line);
            map.put(s.saleId, s);
        }
    } catch (IOException e) {
        System.out.println("Error loading sales: " + e.getMessage());
    }

    return map;
}

public static void saveSales(String path, Map<String, Sale> map) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
        for (Sale s : map.values()) {
            pw.println(s.toCSV());
        }
    } catch (IOException e) {
        System.out.println("Error saving sales: " + e.getMessage());
    }
}

    public static Map<String, Buyer> loadBuyers(String path) {
    Map<String, Buyer> map = new HashMap<>();
    File file = new File(path);

    if (!file.exists()) return map;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            Buyer b = Buyer.fromCSV(line);
            map.put(b.id, b);
        }
    } catch (IOException e) {
        System.out.println("Error loading buyers: " + e.getMessage());
    }

    return map;
}

public static void saveBuyers(String path, Map<String, Buyer> map) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
        for (Buyer b : map.values()) {
            pw.println(b.toCSV());
        }
    } catch (IOException e) {
        System.out.println("Error saving buyers: " + e.getMessage());
    }
}


    public static void saveMedicines(String path, Map<String, Medicine> map) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (Medicine m : map.values()) {
                pw.println(m.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving medicines: " + e.getMessage());
        }
    }
}
