package services;
import gui.Designing;
import model.Animations;
import model.UserInput;
import model.ValidateInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddItem extends MainMenu{
    private static List<UserInput> inputs = new ArrayList<>();

    public static void banner(){
    System.out.println(Designing.CYAN + "\n╔══════════════════════════════════════════════════════════════════════════════╗"+Designing.RESET);
    System.out.println(Designing.CYAN + "║           "+Designing.BOLD+Designing.YELLOW+"                      ADD ITEMS                        "+Designing.CYAN+"            ║"+Designing.RESET);
    System.out.println(Designing.CYAN + "╚══════════════════════════════════════════════════════════════════════════════╝"+Designing.RESET); 
    }

    public static void addItem(){
    Designing.clearContent();
    banner();
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    String itemName = ValidateInput.validItemName(sc, Designing.YELLOW + "   Enter Item Name >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");

    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    int itemQuantity = ValidateInput.validItemQuantity(sc, Designing.YELLOW + "   Enter Item Quantity >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    double itemPrice = ValidateInput.validItemPrice(sc, Designing.YELLOW + "   Enter Item Price >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────\n");
    
    addToCSV(itemName,itemQuantity,itemPrice);
    sc.nextLine();   
    }

    public static void addToCSV(String itemName, int itemQuantity, double itemPrice) {
    File csvFile = new File("inventory.csv");
    boolean exists = false;

    Animations.loadingCircle();
    Animations.loadingAnimation();
    Designing.clearContent();
    banner();

    if (csvFile.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",", 2);
                if (cols[0].equalsIgnoreCase(itemName)) {
                    exists = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(Designing.CYAN + "\n\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
            e.printStackTrace();
            System.out.println(Designing.BG_RED + "  " + Designing.RED +"  Error: Unable to verify existing items." +Designing.RESET);
            System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
            return;
        }
    }

    if (exists) {
        System.out.println(Designing.CYAN + "\n\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        System.out.println(Designing.BG_RED + "  " + Designing.RED + "  Error: Item " + Designing.YELLOW + itemName + Designing.RED + " already exists in inventory!" + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        return;
    }

    UserInput userInput = new UserInput(itemName, itemQuantity, itemPrice);
    inputs.add(userInput);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
        writer.write(itemName + "," + itemQuantity + "," + itemPrice);
        writer.newLine();
    } catch (IOException e) {
        System.out.println(Designing.CYAN + "\n\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        e.printStackTrace();
        System.out.println(Designing.BG_RED + "  " + Designing.RED + " outor: Failed to save new item." + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        inputs.remove(userInput);
        return;
    }

    String successBanner = Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.GREEN
        + "\n                            ITEM SUCCESSFULLY ADDED                            "
        + Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.RESET;

    System.out.println(userInput.toString(successBanner));  
    }
}
