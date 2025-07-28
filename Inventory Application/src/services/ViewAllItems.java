package services;

import java.util.Scanner;

import gui.Designing;
import model.Animations;
import model.UserInput;
import model.ValidateInput;

public class ViewAllItems extends MainMenu{

public static void banner(){
    System.out.println(Designing.CYAN + "\n╔══════════════════════════════════════════════════════════════════════════════╗"+Designing.RESET);
    System.out.println(Designing.CYAN + "║           " + Designing.BOLD + Designing.YELLOW + "                      VIEW ALL ITEMS                        " + Designing.CYAN + "       ║" + Designing.RESET);
    System.out.println(Designing.CYAN + "╚══════════════════════════════════════════════════════════════════════════════╝"+Designing.RESET); 
}

public static void viewAllItems() {

    loadInventory.loadInventoryFromCsv();
    Designing.clearContent();
    banner();
    System.out.println("");
    Animations.loadingCircle();
        System.out.print("\r");              // Return to beginning of the line
        System.out.print("               "); // Overwrite with spaces
        System.out.print("\r");              // Return again
        System.out.flush();
    if (inputs.isEmpty()) {
        System.out.println(Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        System.out.println(Designing.RED + "                            No items in inventory." + Designing.RESET);
        System.out.println(Designing.CYAN + "────────────────────────────────────────────────────────────────────────────────" + Designing.RESET);
        return;
    }

    for (int i = 0; i < inputs.size(); i++) {
        UserInput ui = inputs.get(i);

        String successBanner = Designing.CYAN
            + "\n────────────────────────────────────────────────────────────────────────────────"
            + Designing.GREEN
            + "\n                                   ITEM " + (i + 1) + "                             "
            + Designing.CYAN
            + "\n────────────────────────────────────────────────────────────────────────────────"
            + Designing.RESET;

        System.out.println(successBanner);
        System.out.println("\n      Item Name : " + Designing.YELLOW + ui.getItemName() + Designing.RESET +
                           "\n      Item Quantity : " + Designing.YELLOW + ui.getItemQuantity() + Designing.RESET +
                           "\n      Item Price : " + Designing.YELLOW + ui.getItemPrice() + Designing.RESET +
           Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────"
        );
    }
}

}
