package model;

import gui.Designing;

public class UserInput{
    private String itemName;
    private int itemQuantity;
    private double itemPrice;

    public UserInput(String item, int quantity, double price){
    this.itemName = item;
    this.itemQuantity = quantity;
    this.itemPrice = price;
    }

    // Getters
    public String getItemName(){
        return itemName; 
    }
    public int getItemQuantity(){
        return itemQuantity;
    }
    public double getItemPrice(){
        return itemPrice;
    }

    // Setters
    public void setItemName(String item){
        this.itemName = item;
    }
    public void setItemQuantity(int quantity){
        this.itemQuantity = quantity;
    }
    public void setItemPrice(double price){
        this.itemPrice = price;
    }

    public String toString(String prompt){
    System.out.println(prompt);
    return "\n      Item Name : " + Designing.YELLOW + itemName + Designing.RESET +
           "\n      Item Quantity : " + Designing.YELLOW + itemQuantity + Designing.RESET +
           "\n      Item Price : " + Designing.YELLOW + itemPrice + Designing.RESET +
           Designing.CYAN + "\n────────────────────────────────────────────────────────────────────────────────";
    }
}