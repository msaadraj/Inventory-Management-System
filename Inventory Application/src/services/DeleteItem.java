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

public class DeleteItem extends MainMenu{

public static void banner(){
    System.out.println(Designing.CYAN + "\n╔══════════════════════════════════════════════════════════════════════════════╗"+Designing.RESET);
    System.out.println(Designing.CYAN + "║           " + Designing.BOLD + Designing.YELLOW + "                       DELETE ITEM                      " + Designing.CYAN + "           ║" + Designing.RESET);
    System.out.println(Designing.CYAN + "╚══════════════════════════════════════════════════════════════════════════════╝"+Designing.RESET); 
}

public static void deleteItem() {
    Designing.clearContent();
    loadInventory.loadInventoryFromCsv();
    banner();
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
    String itemName = ValidateInput.validItemName(sc, Designing.YELLOW + "   Enter Item Name to delete >    " + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────\n" + Designing.RESET);

    Optional<UserInput> toDelete = inputs.stream()
        .filter(ui -> ui.getItemName().equalsIgnoreCase(itemName))
        .findFirst();

    Animations.loadingCircle();
    Animations.loadingAnimation();
    Designing.clearContent();
    banner();

    if (toDelete.isEmpty()) {
        System.out.println(Designing.CYAN + "\n\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        System.out.println(Designing.BG_RED + "  " + Designing.RED + "  Error: Item " + itemName + " not found in inventory!" + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        return;
    }

    inputs.remove(toDelete.get());

    File csvFile = new File("inventory.csv");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, false))) {
        for (UserInput ui : inputs) {
            writer.write(ui.getItemName() + "," 
                       + ui.getItemQuantity() + "," 
                       + ui.getItemPrice());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println(Designing.CYAN + "\n\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        e.printStackTrace();
        System.out.println(Designing.BG_RED + "  " + Designing.RED + "  Error: Failed to update inventory file." + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        inputs.add(toDelete.get());
        return;
    }

    String successBanner = Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.GREEN
        + "\n                           ITEM DELETED SUCCESSFULLY                         "
        + Designing.CYAN
        + "\n────────────────────────────────────────────────────────────────────────────────"
        + Designing.RESET;

    System.out.println(successBanner);
    System.out.println("  Deleted: " + Designing.YELLOW + toDelete.get().getItemName() + Designing.RESET);
    System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
}

}
