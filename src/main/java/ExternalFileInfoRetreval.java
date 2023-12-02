//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."

import java.util.Scanner;//import for this file 

public class ExternalFileInfoRetreval extends Invoice{
    
    public ExternalFileInfoRetreval() throws Exception {
        super();
        //TODO Auto-generated constructor stub
    }

    public double applePrice;                    //All Strings and Doubles are used to hold the data that is obtained from the external file
    public double orangePrice;                   //these wil hold customer info, menu info, prices, and IDs 
    public double watermelonPrice;
    public double pearPrice;
    public double peachPrice;
    public double appleId;
    public double orangeId;
    public double watermelonId;
    public double pearId;
    public double peachId;
    public String appleName;
    public String orangeName;
    public String watermelonName;
    public String pearName;
    public String peachName;
    public String returningF;
    public String returningL;
    public String returningId; 
    
    
    public double[] getPrices()throws Exception{//this function will return the temps array with the item ids and price. Obtained from the external file
        java.io.File file = new java.io.File("FruitSelection.txt");
        Scanner input = new Scanner(file);
        double temps[] = new double[10];
        String tempNames[] = new String[5];
        while(input.hasNext()){
            tempNames[0] = input.next();
            temps[0] = input.nextDouble(); 
            temps[1] = input.nextDouble(); 
            tempNames[1] = input.next();
            temps[2] = input.nextDouble(); 
            temps[3] = input.nextDouble(); 
            tempNames[2] = input.next();
            temps[4] = input.nextDouble(); 
            temps[5] = input.nextDouble(); 
            tempNames[3] = input.next();
            temps[6] = input.nextDouble(); 
            temps[7] = input.nextDouble(); 
            tempNames[4] = input.next();
            temps[8] = input.nextDouble(); 
            temps[9] = input.nextDouble(); 
        }
        return temps;
    }
    
    public String[] getNames()throws Exception{//this function will return the tempNames array with the item names. Obtained from the external file
        java.io.File file = new java.io.File("FruitSelection.txt");
        Scanner input = new Scanner(file);
        double temps[] = new double[10];
        String tempNames[] = new String[5];
        while(input.hasNext()){
            tempNames[0] = input.next();
            temps[0] = input.nextDouble(); 
            temps[1] = input.nextDouble(); 
            tempNames[1] = input.next();
            temps[2] = input.nextDouble(); 
            temps[3] = input.nextDouble(); 
            tempNames[2] = input.next();
            temps[4] = input.nextDouble(); 
            temps[5] = input.nextDouble(); 
            tempNames[3] = input.next();
            temps[6] = input.nextDouble(); 
            temps[7] = input.nextDouble(); 
            tempNames[4] = input.next();
            temps[8] = input.nextDouble(); 
            temps[9] = input.nextDouble(); 
        }
        return tempNames;
    }
    
      public String[] getCustomer()throws Exception{//this will return tempNames array which holds customer first name, last name, and ID. Obtained from the external file
        java.io.File file = new java.io.File("Returning Customer.txt");
        Scanner input = new Scanner(file);
        String tempNames[] = new String[3];
        while(input.hasNext()){
            tempNames[0] = input.next();
            tempNames[1] = input.next();
            tempNames[2] = input.next();
        }
        return tempNames;
    }
           
    
    //*******************************************************************Menu Info Retreval  \/ \/ \/ \/ \/ \/ \/ \/ \/ \/      
      public double getTotalAmmt0(double[] y){//gets apple price
         applePrice = y[0];
         return applePrice;     
     }
      
       public double getTotalAmmt1(double[] y){//gets orange price
         orangePrice = y[2];
         return orangePrice;     
     }
       
        public double getTotalAmmt2(double[] y){//gets watermelon price
         watermelonPrice = y[4];
         return watermelonPrice;     
     }
        
         public double getTotalAmmt3(double[] y){//gets pear price
         pearPrice = y[6];
         return pearPrice;     
     }
         
          public double getTotalAmmt4(double[] y){//gets peach price
         peachPrice = y[8];
         return peachPrice;     
     }
      
            public double getItemNum0(double[] y){//gets Item 1 ID
         appleId = y[1];
         return appleId;     
     }
             public double getItemNum1(double[] y){//gets Item 2 ID 
         orangeId = y[3];
         return orangeId;     
     }
              public double getItemNum2(double[] y){//gets Item 3 ID
         watermelonId = y[5];
         return watermelonId;     
     }
               public double getItemNum3(double[] y){//gets Item 4 ID 
         pearId = y[7];
         return pearId;     
     }
                public double getItemNum4(double[] y){//gets Item 5 ID
         peachId = y[9];
         return peachId;     
     }
                
         public String getItemName0(String[] y){//gets item name : apple
         appleName = y[0];
         return appleName;     
     }
          
          public String getItemName1(String[] y){//gets item name : orange
         orangeName = y[1];
         return orangeName;     
     }
          
             public String getItemName2(String[] y){//gets item name : watermelon
         watermelonName = y[2];
         return watermelonName;     
     }
                  public String getItemName3(String[] y){//gets item name : pear
         pearName = y[3];
         return pearName;     
     }
          
          public String getItemName4(String[] y){//gets item name : peach
         peachName = y[4];
         return peachName;     
     }
     //*******************************************************************Menu Info Retreval^^^^^^^^^^^^^          
                
          
                
     //*******************************************************************Customer Info Retreval \/ \/ \/ \/ \/ \/ \/ \/ \/ \/  
          
             public String getFirstName(String[] y){//gets returning user first name 
         returningF = y[0];
         return returningF;     
     }
          
          public String getLastName(String[] y){//gets returning user last name
         returningL = y[1];
         return returningL;     
     }
          
             public String getUserId(String[] y){//gets returning user ID
         returningId = y[2];
         return returningId;     
     }
     //*******************************************************************Customer Info Retreval^^^^^^^^^^^^^^^^^^ 
             
             
             
     //*********************************************************************Methods to set the Varriables \/ \/ \/ \/ \/ \/ \/ \/ \/ \/         
          public void setPrices(){//sets all prices from external file
         this.applePrice = applePrice;
         this.orangePrice = orangePrice;
         this.watermelonPrice = watermelonPrice; 
         this.pearPrice = pearPrice;
         this.peachPrice = peachPrice;
     }
               public void setIds(){//sets all item IDs from external file
         this.applePrice = applePrice;
         this.orangePrice = orangePrice;
         this.watermelonPrice = watermelonPrice; 
         this.pearPrice = pearPrice;
         this.peachPrice = peachPrice;
     }
    
          public void setCustName(){//sets returning customer name and id from external file
         this.returningF = returningF;
         this.returningL = returningL;
         this.returningId = returningId; 
     }
    
          public void setFruitName(){//sets fruit names from esternal file
         this.appleName = appleName;
         this.orangeName = orangeName;
         this.watermelonName = watermelonName; 
         this.pearName = pearName;
         this.peachName = peachName;
     }
          
}
//*********************************************************************Methods to set the Varriables^^^^^^^^^^^^^^^^         