//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

import javax.swing.JFrame;//imports for this file

public class DiscountCheck extends JFrame {//this file extends JFrame to enable functionality for our GUI
    
    public double checkDiscount(double fruit, double price){//Checks if more than 10 of one item has been bought
        if(fruit >= 10){
            price = fruit * price * 0.90; 
        }
        else{
            price = fruit * price; 
        }
            return price;
    }
    
}
