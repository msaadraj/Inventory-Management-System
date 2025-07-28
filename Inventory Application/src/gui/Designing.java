package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.Log;

public class Designing {

    // Reset
    public static final String RESET = "\033[0m";  

    // Text Color
    public static final String BLACK = "\033[0;30m";  
    public static final String RED = "\033[0;31m";    
    public static final String GREEN = "\033[0;32m";  
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m";   
    public static final String PURPLE = "\033[0;35m"; 
    public static final String CYAN = "\033[0;36m";   
    public static final String WHITE = "\033[0;37m";  

    // Background Color
    public static final String BG_RED = "\033[41m";   
    public static final String BG_GREEN = "\033[42m"; 
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";  
    public static final String BG_PURPLE = "\033[45m";
    public static final String BG_CYAN = "\033[46m";  
    public static final String BG_WHITE = "\033[47m"; 

    // Bold + Underline
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\033[4m";

    // Method for Clearing the Screen
public static void clearContent() {
    System.out.print("\u001B[H\u001B[2J");
    System.out.flush();
    String[] banner = {
    Designing.BG_CYAN + "                                                                              " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + "    _____          .___                           __                        " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + "   /     \\ ___.__. |   | _______  __ ____   _____/  |_  ___________ ___.__. " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + "  /  \\ /  <   |  | |   |/    \\  \\/ // __ \\ /    \\   __\\/  _ \\_  __ <   |  | " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + " /    Y    \\___  | |   |   |  \\   /\\  ___/|   |  \\  | (  <_> )  | \\/\\___  | " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + " \\____|__  / ____| |___|___|  /\\_/  \\___  >___|  /__|  \\____/|__|   / ____| " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + "         \\/\\/               \\/          \\/     \\/                   \\/      " + Designing.BG_CYAN + "  ",
    "  " + Designing.YELLOW + "                                                                            " + Designing.BG_CYAN + "  ",
    "                                                                                " + Designing.RESET,
    };
    for (String line : banner) {
        System.out.println(line);
    }
}


}
