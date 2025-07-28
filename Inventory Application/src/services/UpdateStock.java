package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import gui.Designing;
import model.Animations;
import model.UserInput;
import model.ValidateInput;

public class UpdateStock extends MainMenu{

public static void banner(){
System.out.println(Designing.CYAN + "\n╔══════════════════════════════════════════════════════════════════════════════╗" + Designing.RESET);
System.out.println(Designing.CYAN + "║           " + Designing.BOLD + Designing.YELLOW + "                       UPDATE STOCK                     " + Designing.CYAN + "           ║" + Designing.RESET);
System.out.println(Designing.CYAN + "╚══════════════════════════════════════════════════════════════════════════════╝" + Designing.RESET);
}
        
public static void updateStock() {
    loadInventory.loadInventoryFromCsv();
    Designing.clearContent();
    banner();    

    System.out.println(Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────");
    String itemName = ValidateInput.validItemName(sc, Designing.YELLOW + "   Enter Item Name to update >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────\n");

    Optional<UserInput> opt = inputs.stream().filter(ui -> ui.getItemName().equalsIgnoreCase(itemName)).findFirst();
    
    Animations.loadingCircle();
    Animations.loadingAnimation();
    Designing.clearContent();
    banner();

    if (opt.isEmpty()) {
        System.out.println(Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        System.out.println(Designing.BG_RED + "  " + Designing.RED + "  Error: Item " + itemName + " not found in inventory!" + Designing.RESET);
        System.out.println(Designing.CYAN + "──────────────────────────────────────────────────────────────────────────────── \n" + Designing.RESET);
        return;
    }

    UserInput ui = opt.get();
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    int newQty = ValidateInput.validItemQuantity(sc, Designing.YELLOW + "   Enter new Quantity for " + itemName + " >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");

    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────");
    double newPrice = ValidateInput.validItemPrice(sc,Designing.YELLOW + "   Enter new price for " + itemName + " >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────\n");
    
    Animations.loadingCircle();
    Animations.loadingAnimation();
    Designing.clearContent();
    banner();

    ui.setItemQuantity(newQty);
    ui.setItemPrice(newPrice);


    File csvFile = new File("inventory.csv");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, false))) {
        for (UserInput entry : inputs) {
            writer.write(entry.getItemName() + "," 
                       + entry.getItemQuantity() + "," 
                       + entry.getItemPrice());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println(Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        e.printStackTrace();
        System.out.println(Designing.BG_RED + "  " + Designing.RED + "Error: Failed to update inventory file." + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        return;
    }


    String successBanner = Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.GREEN
        + "\n                          STOCK " + itemName + "UPDATED SUCCESSFULLY                        "
        + Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.RESET;
    System.out.println(successBanner);
    System.out.println("\n      Item Name : " + Designing.YELLOW + itemName + Designing.RESET +
                       "\n      Item Quantity : " + Designing.YELLOW + newQty + Designing.RESET +
                       "\n      Item Price : " + Designing.YELLOW + newPrice + Designing.RESET +
           Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────"
    );
    sc.nextLine();
}

}
