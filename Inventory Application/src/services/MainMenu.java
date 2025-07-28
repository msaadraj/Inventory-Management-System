package services;
import gui.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainMenu {
    public static List<UserInput> inputs = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void menu(){
        Designing.clearContent();
        System.out.println(Designing.CYAN+"\n╔══════════════════════════════════════════════════════════════════════════════╗"+Designing.RESET);
        System.out.println(Designing.CYAN+"║           "+Designing.BOLD+Designing.YELLOW+"                       MAIN MENU                       "+Designing.CYAN+"            ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"╠══════════════════════════════════════════════════════════════════════════════╣"+Designing.RESET);
        System.out.println(Designing.CYAN+"║  "+Designing.RESET+"1. "+Designing.YELLOW+"Add Items"+Designing.RESET+"                                                   "+Designing.CYAN+"             ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"║  "+Designing.RESET+"2. "+Designing.YELLOW+"Update Stock                                                          "+Designing.CYAN+"   ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"║  "+Designing.RESET+"3. "+Designing.YELLOW+"Delete Item                                                           "+Designing.CYAN+"   ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"║  "+Designing.RESET+"4. "+Designing.YELLOW+"View All Items                                                        "+Designing.CYAN+"   ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"║  "+Designing.RESET+"5. "+Designing.YELLOW+"Exit                                                                  "+Designing.CYAN+"   ║"+Designing.RESET);
        System.out.println(Designing.CYAN+"╚══════════════════════════════════════════════════════════════════════════════╝"+Designing.RESET); 
    }

    public static void options(){
        while (true) {
        menu();
        String option = ValidateInput.menuOption(sc, Designing.YELLOW+"\n  >   "+Designing.RESET); 
        Animations.loadingAnimation();
        Designing.clearContent(); 
        String enter;
        switch (option) {

            case "1":
            AddItem.addItem();
            System.out.println(Designing.CYAN + "\n\n                   >>>     Press " + Designing.YELLOW + " ENTER " + Designing.CYAN + " to Main Menu    <<<               \n" + Designing.RESET);
            enter = sc.nextLine();
            continue;
        
            case "2":
            UpdateStock.updateStock();
            System.out.println(Designing.CYAN + "\n\n                   >>>     Press " + Designing.YELLOW + " ENTER " + Designing.CYAN + " to Main Menu    <<<               \n" + Designing.RESET);
            enter = sc.nextLine();
            continue;

            case "3":
            DeleteItem.deleteItem();
            System.out.println(Designing.CYAN + "\n\n                   >>>     Press " + Designing.YELLOW + " ENTER " + Designing.CYAN + " to Main Menu    <<<               \n" + Designing.RESET);
            enter = sc.nextLine();
            continue;

            case "4":
            ViewAllItems.viewAllItems();
            System.out.println(Designing.CYAN + "\n\n                   >>>     Press " + Designing.YELLOW + " ENTER " + Designing.CYAN + " to Main Menu    <<<               \n" + Designing.RESET);
            enter = sc.nextLine();
            continue;

            case "5":
            System.out.println(Designing.CYAN+"\n╔══════════════════════════════════════════════════════════════════════════════╗"+Designing.RESET);
            System.out.println(Designing.CYAN+"║           "+Designing.BOLD+Designing.YELLOW+"                     Exiting...                         "+Designing.CYAN+"           ║"+Designing.RESET);
            System.out.println(Designing.CYAN+"╚══════════════════════════════════════════════════════════════════════════════╝\n"+Designing.RESET); 
            System.exit(0);
            break;
          }
        }
    }
}
