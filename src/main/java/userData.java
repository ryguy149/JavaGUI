//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

import java.util.Scanner;//imports for this file

public class userData extends DiscountCheck{
      //class not exted by anything. "end" file/class 
    public String last; 
    public String first;
    private int temp;
    public int watermelon;
    public int mango;
    public int banana;
    public int peach;
    public String userResponce;
    public double installPrice; 
    public String installName;
    public double adminInstall; 
    private boolean bool; 
    
    public String getFirst(){ //gets first name of the customer
         Scanner input = new Scanner (System.in);
         System.out.println("What is your First name?");
          while (!input.hasNext("[A-Za-z]+")) {//input validation
              if(input.hasNext("MCS3603"))
                  break;
        System.out.println("That input is not valid please enter first name");
        input.next();
    }
          first = input.next();
         return first;
    }
    
      public void setFirst(){ //sets the first name of the customer
        this.first = first; 
    }
    
    public String getLast(){ //gets last name from customer
         Scanner input = new Scanner (System.in);
         System.out.println("What is your Last name?");
          while (!input.hasNext("[A-Za-z]+")) {//input validation
        System.out.println("That input is not valid please enter last name");
        input.next();
    }
          last = input.next();
         return last;
    }
    
    public void setLast(){//sets last name for user
        this.last = last; 
    }
    
    public String printName(){//returns and prints customer name to screen 
        return "Customer name: " + first + " " + last; 
    }
  
    
    public int getAmmount(){//this function will get ammount od an item from user and store it in a temp varriable 
        Scanner input = new Scanner (System.in);
        do {//input validation
            while (!input.hasNextInt()) {
                System.out.println("That's not a number. Please enter a valid selection: (0-99)");    
                input.next(); // this is important!
            }
            temp = input.nextInt();
            if(temp < 0)
                System.out.println("Enter a positive number (0-99)");//validates number is positive 
        } while (temp < 0);
        System.out.println("Thank you! Got " + temp);
        return temp;
    }
    
    public void setAmmount1(){//sets ammmount from temp
    this.watermelon = temp; 
    }
    
      public void setAmmount2(){//sets ammmount from temp
    this.mango = temp; 
    }
      
        public void setAmmount3(){//sets ammmount from temp
    this.banana = temp; 
    }
        
          public void setAmmount4(){//sets ammmount from temp
    this.peach = temp; 
    }
          
          public void setAmmount5(){//sets ammmount from temp
    this.adminInstall = temp; 
    }      
          
    public String displayInstallments(){//asks user how they would like to complete the purchase of their order 
        System.out.println("Would you like to pay the [full amount(f)] or in [installments(i)]?");
        System.out.println("Enter 'i' or 'f' to select an option");
        Scanner input = new Scanner (System.in);//scanner for their responce 
        
        while(!input.hasNext("[if]")){//while loop for input validation. Ensures customer will input i or f
            System.out.println("That's not a valid option.");
            input.next();
        }
        
        userResponce = input.next();//gets responce from user 
        return userResponce;       
    }
    
    public void setInstallments(){//sets the user responce 
        this.userResponce = userResponce;
    }
    
    
    public String checkForInstall(){//checks for which way the customer decided to pay 
        boolean installAmmt = userResponce.equals("i");
        boolean fullAmmt = userResponce.equals("f");
        
        if (installAmmt == true){//if user had decided to pay for their orer in installmets 
        
            System.out.println("You have chosen to pay in installments");
    }
        
        else if(fullAmmt == true){//if user has chosed to pay full ammount of order
            System.out.println("You have chose to pay the full ammount");
            System.out.println("Extra five percent off total for paying full ammount!");
            
    }
        else{
            System.out.println("You have not properly selected a valid option");//extra input vaidation 
            
        }
        return userResponce;
        }
        
    public String getAdminName(){//gets the name of the admin added item  
         Scanner input = new Scanner (System.in);            
        while (!input.hasNext("[A-Za-z]+")) {//input validation
        System.out.println("That input is not valid please enter product name");
        input.next();
    }
         installName = input.nextLine();
         return installName;
    }
    
     public double getAdminPrice(){//gets the price of the admin added item  
        Scanner input = new Scanner (System.in);
          do {//input validation
            while (!input.hasNextDouble()) {
                System.out.println("That's not a number. Please enter a valid selection: (0.0-99.0)");    
                input.next(); // this is important!
            }
            installPrice = input.nextDouble();
            if(installPrice < 0)
                System.out.println("Enter a positive number (0.0-99.0)");//validates number is positive 
        } while (installPrice < 0);
        System.out.println("Thank you! Got " + installPrice);
        return installPrice;
    }
    
     public void setAdmin(){//sets the name and price of the admin added product 
    this.installName = installName; 
    this.installPrice = installPrice; 
    } 
}
