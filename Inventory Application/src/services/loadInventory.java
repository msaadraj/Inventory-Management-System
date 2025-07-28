package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.UserInput;

public class loadInventory extends MainMenu{
    
    // 1️⃣ Call this once at application startup (or before any add/delete/read)
public static void loadInventoryFromCsv() {
    inputs.clear();                           // reset list
    File csvFile = new File("inventory.csv");
    if (!csvFile.exists()) return;            // nothing to load yet

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] cols = line.split(",");
            if (cols.length == 3) {
                String name = cols[0].trim();
                int qty    = Integer.parseInt(cols[1].trim());
                double pr = Double.parseDouble(cols[2].trim());
                inputs.add(new UserInput(name, qty, pr));
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
}

}
