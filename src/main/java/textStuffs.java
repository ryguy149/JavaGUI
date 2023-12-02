//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

public class textStuffs extends Calculations{
    public void displayMenu(String i){  //displays the menu to the user
        System.out.println("------------------------------------------------------------------------");
	System.out.println("Inventory:");   
	System.out.println("(Num.101) Watermelon's: $2.00--Fresh Seedless Watermelon");
	System.out.println("(Num.102)      Mango's: $1.50--Fresh picked Mangos");
	System.out.println("(Num.103)      Apple's: $1.00--Granny Smith fresh picked");
        System.out.println("(Num.106)      Peach's: $0.75--Sweat and savery peach's\n");
          if(i.equals("MCS3603")){
             // double temp = installPrice;
            System.out.println("(Num.199)      "+ installName +"'s: $" + installPrice);
        }
        System.out.println("------------------------------------------------------------------------");
    }
     
     public void displayWatermelon(){//asks for number watermelon
     System.out.println("Enter number of watermelon's you would like: ");
     }
     
     public void displayMango(){//asks for number mango
     System.out.println("Enter number of mangos's you would like: ");
     }
     
     public void displayBanana(){//asks for number of banana
     System.out.println("Enter number of banana's you would like: ");
     }
     
     public void displayPeach(){//asks for number of peaches
     System.out.println("Enter number of peach's you would like: ");
     }
     
     public void displayAdminItem(){//if admin add item this will ask how many of said item
     System.out.println("Enter number of " + installName +"'s you would like: ");
     }
     
   public void diplayInvoice(){//displays the invoice for the customer
       double temp;
        System.out.println("-------------------------------INVOICE----------------------------------\n");
        System.out.println("Customer Name:"+ first +" "+last);//displays customer first and last name
        temp = watermelonFin;
        System.out.printf("Ammount of watermelon's----"+ watermelon + "--------Price: $"+ "%.2f%n", temp);//displays ammount of item and subtotal
        temp = mangoFin;
        System.out.printf("Ammount of mango's---------" + mango+ "--------Price: $"+ "%.2f%n", temp);
        temp = bananaFin;
        System.out.printf("Ammount of banna's---------" + banana+ "--------Price: $"+ "%.2f%n", temp);
        temp = peachFin;
        System.out.printf("Ammount of peach's---------" + peach + "--------Price: $"+ "%.2f%n", temp); 
     }
   
    public void displayAdmin4(){//if admin adds item will add this to the invoice
        double temp = adminInstall; 
       System.out.printf("Ammount of "+ installName +"'s---------" + "%.0f" + "--------Price: $"+ adminFin +"%n", temp);
   }
   
   public void diplayInvoice2(double i){//will show totals before and after tax to user
       double x = total;
       System.out.printf("Total ammont before tax-----$"+ "%.2f%n" , x * i);
       double temp = total * i * tax;
       System.out.printf("Total ammont after tax-----$" + "%.2f", temp);
   }
   
   
   public void displayAdminAcess(){//will display to user if they would like to enter admin panel or not
       System.out.println("If you would like to enter the Admin panel enter the password now\n\n");
       System.out.println("Welcome to RyGuy's fruit cart!!!\n");
   } 
   
   
   public void displayAdmin(){// asks for display name of new product
       System.out.println("You have now enterd the admin access panel");
       System.out.println("Please enter the name of the product you would like to add:");
   }
   
   public void displayAdmin2(){ ////displays the invoice for the customer
    System.out.println("Please enter the price of the product you would like to add");
}  
   
      public void displayAdmin3(){//display if the item was added sucessfully
    System.out.println("The administrator has sucessfully added an item to the menu!!!\n");
    System.out.println("Welcome to RyGuy's fruit cart!!!\n\n");
}   
}
