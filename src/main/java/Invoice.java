//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

public class Invoice extends displayInvoice {
    
    public Invoice() throws Exception {
        super();
        //TODO Auto-generated constructor stub
    }

    public void saveInvoice(String first, String last, String id, double apple, 
            double orange, double watermelon, double pear, double peach, double total, double finalCost) throws java.io.IOException{
        
        java.io.File file = new java.io.File("Invoice.txt");//create text file named n=invoice
        
        if(file.exists()){
            System.out.println("Invoice already exists");//will display this message if file already exists
    }
    
        try (java.io.PrintWriter out = new java.io.PrintWriter(file) //used to write to file invoice
        ) {
            DiscountCheck check = new DiscountCheck();//utilizing discount check method to check for 10 or more items
            
            out.println("************************************");//format for external file creation
            out.println("Thank you for shopping with Ryguy");
            out.println("************************************");
            out.println("Customer name: "+ first + " "+ last);
            out.println("Customer ID: "+ id);
            out.println("************************************");
            out.println("Your Order: ");
            out.printf("%.0f" + " Apple's ---------- $"+ "%1.2f\n", apple, check.checkDiscount(apple , 1.00));
            out.printf("%.0f" + " Orange's ---------- $"+ "%1.2f\n", orange, check.checkDiscount(orange , 1.25));
            out.printf("%.0f" + " Watermelon's ------ $"+ "%1.2f\n", watermelon, check.checkDiscount(watermelon , 2.00));
            out.printf("%.0f" + " Pear's ------------ $"+ "%1.2f\n", pear, check.checkDiscount(pear , 1.50));
            out.printf("%.0f" + " Peach's ----------- $"+ "%1.2f\n", peach, check.checkDiscount(peach , 1.75));
            out.println("************************************");
            out.printf("Total Before Tax: $"+"%1.2f\n" , total);
            out.printf("Total After Tax: $"+"%1.2f\n" , finalCost);
            out.println("************************************");
            out.println("Thank you for shopping with Ryguy");
            out.println("************************************"); 
        } //utilizing discount check method to check for 10 or more items
        catch(Exception ex){
            System.out.println("Cannot Make Invoice");
        }
    }  
}