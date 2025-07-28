package model;
import java.util.Scanner;
import java.util.InputMismatchException;
import gui.*;

public class ValidateInput {

    public static String menuOption(Scanner sc, String prompt){   // Validate Main Menu
        System.out.print(prompt);
        String option = " ";
        while (true) {
        try {
        option = sc.nextLine();
        if(!option.isBlank() && option.matches("[1-5]")){
        break;
        }
        else{
        System.out.print("\033[F"); // Move cursor up one line
        System.out.print("\033[2K"); // Clear entire line
        System.out.flush();
        System.out.print(Designing.BG_RED + "  " + Designing.RED + " Invalid Item Name! Please Choose (1-5) >    " + Designing.RESET);
        continue;
        }
        } catch (InputMismatchException e) {
        System.out.print("\033[F"); // Move cursor up one line
        System.out.print("\033[2K"); // Clear entire line
        System.out.flush();
        System.out.print(Designing.BG_RED + "  " + Designing.RED + " Invalid Item Name! Please Choose (1-5) >    " + Designing.RESET);
        sc.next();
        continue;
        }            
        }
        return option;
    }

    public static String validItemName(Scanner sc, String prompt){    // Validate The Item Name
    System.out.print(prompt);
    String itemName;
    while (true) {
    itemName = sc.nextLine().toUpperCase().trim();
    if(itemName.matches("[A-Z]+") && !itemName.isEmpty()){
    break;
    }
    else{
    System.out.print("\033[F"); // Move cursor up one line
    System.out.print("\033[2K"); // Clear entire line
    System.out.flush();
    System.out.print(Designing.BG_RED + "  " + Designing.RED + " Invalid Item Name! Please Enter a Valid Item Name >    " + Designing.RESET);
    continue;
    }
    }
    return itemName;
    }

    public static int validItemQuantity(Scanner sc, String prompt){ // Validate The Item Quantity
    System.out.print(prompt);
    int itemQuantity;
    while (true) {
    try {
    itemQuantity = sc.nextInt();
    break;
    }catch (Exception e) {
    System.out.print("\033[F"); // Move cursor up one line
    System.out.print("\033[2K"); // Clear entire line
    System.out.flush();
    System.out.print(Designing.BG_RED + "  " + Designing.RED + " Invalid Item Quantity! Please Enter a Valid Item Quantity >    " + Designing.RESET);
    sc.nextLine();
    continue;
}
    }
    return itemQuantity;
    }   

    public static Double validItemPrice(Scanner sc, String prompt){
    System.out.print(prompt);
    double itemPrice;
    while (true) {
    try {
    itemPrice = sc.nextDouble();
    break;
    }catch (Exception e) {
    System.out.print("\033[F"); // Move cursor up one line
    System.out.print("\033[2K"); // Clear entire line
    System.out.flush();
    System.out.print(Designing.BG_RED + "  " + Designing.RED + " Invalid Item Price! Please Enter a Valid Item Price >    " + Designing.RESET);
    sc.nextLine();
    continue;    
}
    }
    return itemPrice;
    }   
}

