package model;
import gui.*;
import java.util.Scanner;
import java.lang.Thread;


public class Animations {

    public static Scanner sc = new Scanner(System.in);

    public static void loadingCircle(){
    String[] load = {"\\","-","//","_","\\","-","//","_","\\","-","//","_"};
    System.out.print("Loading   ");
    try {
    for (String line : load) {
        for (char c : line.toCharArray()) {
            System.out.print("\b" + Designing.YELLOW + c);
            Thread.sleep(100);
        }
    }
        System.out.print("\r");              // Return to beginning of the line
        System.out.print("               "); // Overwrite with spaces
        System.out.print("\r");              // Return again
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
    // This Method is for
    // Loading Animation on screen
    public static void loadingAnimation(){
        String bar = Designing.RED + "\n\n════════════════════════════════════════════════════════════════════════════════" + Designing.RESET;
        try {
        for (char c : bar.toCharArray()) {
            System.out.print(c);    
            Thread.sleep(5);
        }   
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }    
    
    // This Method is for
    // printing my Introduction
    public static void myIntro(){
    String name = Designing.RESET + "\n\n\nBuilt By:" + Designing.CYAN + " Muhammad Saad" + Designing.RESET + "\nDate:" + Designing.CYAN + " 2025-07-27" + Designing.RESET;
        
        try {
        for (char c : name.toCharArray()){
            System.out.print(c);
            Thread.sleep(20);
        }
        System.out.println( Designing.CYAN + "\n\n\n                   >>>     Press " + Designing.YELLOW + " ENTER " + Designing.CYAN + " to continue    <<<               " + Designing.RESET);
        String enter = sc.nextLine();
        loadingAnimation();
        } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
        }
    }

    public static void welcomeTo(){
    System.out.print("\u001B[H\u001B[2J");
    System.out.flush();
    System.out.println();
    String[] welcomeBanner = {
    Designing.YELLOW +
    "  __        __   _                            _             ",
    "  \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___       ",
    "   \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  ",
    "    \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |     ",
    "     \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ "
    };
    System.out.println();
    String[] banner = {
    Designing.YELLOW +
    "   _____          .___                           __                       ",
    "  /     \\ ___.__. |   | _______  __ ____   _____/  |_  ___________ ___.__.",
    " /  \\ /  <   |  | |   |/    \\  \\/ // __ \\ /    \\   __\\/  _ \\_  __ <   |  |",
    "/    Y    \\___  | |   |   |  \\   /\\  ___/|   |  \\  | (  <_> )  | \\/\\___  |",
    "\\____|__  / ____| |___|___|  /\\_/  \\___  >___|  /__|  \\____/|__|   / ____|",
    "        \\/\\/               \\/          \\/     \\/                   \\/     "
    };
    try {
    for (String raw : welcomeBanner) {
            System.out.println(raw);
            Thread.sleep(40);
    }   
        System.out.println();
    for (String raw : banner) {
            System.out.println(raw);
            Thread.sleep(40);
     }   
        System.out.println();

    } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
    }
    }

}

