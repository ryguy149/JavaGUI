//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

public class Calculations extends userData{
    public double tax;          
    public double fivePerc;
    private double tenPerc; 
    public double total; 
    public double watermelonFin;
    public double bananaFin;
    public double mangoFin;
    public double peachFin;
    public double adminFin; 
    
    public double setTax(){//sets the tax ammount
        tax = 1.06;
        return tax;
    }
    
    public double setFivePerc(){ //sets 5 percent discount
        fivePerc = 0.95;
        return fivePerc;
    }
    
     public double setTenPerc(){//sets 10 percent discount
        tenPerc = 0.90;
        return tenPerc;
    }
     
     public double[] extractAmmt(String i){
         
         double[] temps = new double[5];//initilizes temp array of size 5
         temps[0] =  watermelon;//sets ammount of watermelons to temp
         temps[1] = mango;//sets ammount of mango to temp
         temps[2] = banana;//sets ammount of banana to temp
         temps[3] = peach; //sets ammount of peach to temp
         
         if(i.equals("MCS3603") ){//if admin adds product
         temps[4] = adminInstall;//then sets ammount of said procuct to temp
         }
         else{
             temps[4] = 1; //else will initilize last spot in temp array to one 
         }
         return temps; //returns the WHOLE temp array 
     }
     
     public double getTotalAmmt00(double[] y){//gets subtotal 0 
         watermelonFin = y[0];
         return watermelonFin;     
     }
     
      public double getTotalAmmt11(double[] y){//gets subtotal 1
         mangoFin = y[1];
         return mangoFin;
     }   
     
     public double getTotalAmmt22(double[] y){//gets subtotal 2
         bananaFin = y[2];
         return bananaFin;         
     }
    
     
     public double getTotalAmmt33(double[] y){//gets subtotal 3
         peachFin = y[3];
         return peachFin;            
     }
     
     public double getTotalAmmt44(double[] y){//gets subtotal 4
         adminFin = y[4];
         return adminFin;
     }
         
     public void setTotals(){//sets all final subtotals 
         this.watermelonFin = watermelonFin;
         this.mangoFin = mangoFin;
         this.bananaFin = bananaFin; 
         this.peachFin = peachFin;
         this.tax = tax;
         this.tenPerc = tenPerc;
         this.fivePerc = fivePerc;
     }
     
     
     public double getTotal(double[] price , double[] fruit,  int arrIndx, int fruitIndex){//calculated the subtotal for each individual item 
         
         double fruittemp = fruit[fruitIndex];//created double var because 
         if (fruittemp >=10)//if more than 10 of one item selected gives discount
           {
                 int i = arrIndx;//gets the price of the item based off array index
                double total = price[arrIndx] * fruittemp;//calculates subtotal
                total = total * tenPerc; //10 percent discount
                System.out.println("10 percent off deal applied  for 1 item!");
                return total; //returns total
           }
           else
           {
                 int i = arrIndx;//gets the price of the item based off array index
                 double total = price[arrIndx] * fruittemp;//calculates subtotal
                 return total; //returns total
           }
    }
     
     public double getTrueTotal(String i){//adds up all subtotals to give us are true total of the customer order
         double temp = 0;//creates temp var for true total
         temp = watermelonFin + mangoFin + bananaFin + peachFin;
         
         if(i.equals("MCS3603") ){//if admin adds an item will add it to subtotal 
         temp = temp + adminFin;
         }
         total = temp; //gets the true total from our temp var
         return total;
     }
     
    public void setTrueTotal(){//sets the true total of the order 
        this.total = total; 
    }
}
