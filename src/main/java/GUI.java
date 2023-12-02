//Ryan Fleury
//Assignment 4
//Java Programing
//"I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."


import javax.swing.JLabel;  //imports for this file
import javax.swing.JTextField;
import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.GridLayout; 
import java.awt.event.*; 
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class GUI extends ExternalFileInfoRetreval{
    private JButton yesButton = new JButton();//all eight buttons that are implemented in the program
    private JButton noButton= new JButton();
    private JButton calculate= new JButton();
    private JButton loadMenu= new JButton();
    private JButton installments= new JButton();
    private JButton fullAmmount= new JButton();
    private JButton displayInvoice= new JButton();
    private JButton saveInvoice= new JButton();
    
    public JTextField firstName= new JTextField(); //first and last name text fields
    public JTextField lastName = new JTextField(); 
    
   public JLabel welcomeBack = new JLabel(); //all nine labels that are implemented in the program
   public JLabel appleLabel = new JLabel(); 
   public JLabel orangeLabel = new JLabel(); 
   public JLabel watermelonLabel = new JLabel(); 
   public JLabel pearLabel = new JLabel(); 
   public JLabel peachLabel = new JLabel(); 
   public JLabel custId = new JLabel();
   public JLabel paymentMethod = new JLabel();
   public JLabel errorAlert = new JLabel();
   
   public JTextField apple = new JTextField(); //other eight text fields that are in the program
   public JTextField orange = new JTextField(); 
   public JTextField watermelon = new JTextField(); 
   public JTextField peach = new JTextField(); 
   public JTextField pear = new JTextField(); 
   public JTextField totalCost = new JTextField(); 
   public JTextField custIdField = new JTextField(); 
   public JTextField finalAmmount = new JTextField(); 
    
     
    public GUI() throws Exception{
        setLayout(new GridLayout(16,2));//defines a 16 by 2 grid for our GUI
        
        add(new JLabel("Returning Customer?"));//first label on GUI
        add(welcomeBack);
        
        yesButton = new JButton("Yes"); 
        add(yesButton);
        yesButton.addActionListener(new yesButtonClass());
        
        noButton = new JButton("No (Careful, this button will clear the three text fields below)"); 
        add(noButton);
        noButton.addActionListener(new noButtonClass());
        
       add (new JLabel("First Name"));
       add(firstName); 
       
       add (new JLabel("Last Name"));
       add(lastName);
       
       add(new JLabel("Customer ID (If your a new customer enter any 6 digit number)"));
       add(custIdField);
       
       loadMenu.setText("Click this button to load the menu!");
       add(loadMenu);
       loadMenu.addActionListener(new loadMenuClass());
       add(errorAlert); 
       
       
       add(new JLabel("Current Stock "));
       add(new JLabel("Enter desired ammount of each item below,"
               + " then select 'Calculate Total Cost'"));
      
       add(appleLabel);
       add(apple);
       
       add(orangeLabel);
       add(orange);
       
       add(watermelonLabel);
       add(watermelon);
       
       add(pearLabel);
       add(pear);
       
       add(peachLabel);
       add(peach);
       
       calculate = new JButton("Calculate Total Cost");
       add(calculate);
       
       calculate.addActionListener(new totalCostClass());
       totalCost.setText("This text field is where the sub total will be displayed");//temp display message
       
       add(totalCost);
       add(paymentMethod);
       
       finalAmmount.setText("This text field is where the final Total will be displayed");//temp display message
       add(finalAmmount); 
       
       add(installments);
       installments.addActionListener(new installmentsClass());//adds action listener to button installments
       
       add(fullAmmount);
       fullAmmount.addActionListener(new fullAmmountClass());//adds action listener to button fullAmmount
       
       add(displayInvoice);
       displayInvoice.addActionListener(new displayInvoiceClass());//adds action listener to button displayInvoice
       
       add(saveInvoice); 
       saveInvoice.addActionListener(new saveInvoiceClass());//adds action listener to button saveInvoice
       
       
    }
    
 class yesButtonClass implements ActionListener{  //action will set customer name from external file
     @Override
     public void actionPerformed(ActionEvent e){
    firstName.setText(returningF);
    lastName.setText(returningL); 
    custIdField.setText(returningId); 
    welcomeBack.setText(String.format("Welcome Back Returning customer!!"));
        }
    }   
     
      class noButtonClass implements ActionListener{   //action will clear customer name and ID
     @Override
     public void actionPerformed(ActionEvent e) {
     firstName.setText(String.format(""));
    lastName.setText(String.format(""));
    custIdField.setText(""); 
    welcomeBack.setText(String.format("That's Ok, Welcome! Please enter Name and ID Below"));
        }
    }  
      
      class loadMenuClass implements ActionListener{  //action loads menu from external file
     @Override
     public void actionPerformed(ActionEvent e) {         
     appleLabel.setText(appleName +"------------------------$"+String.format("%.2f", applePrice)+ "------------------Item ID: " + String.format("%.0f", appleId));
     orangeLabel.setText(orangeName +"----------------------$"+String.format("%.2f", orangePrice)+ "------------------Item ID: " + String.format("%.0f", orangeId));
     watermelonLabel.setText(watermelonName +"---------------$"+String.format("%.2f", watermelonPrice)+ "------------------Item ID: " + String.format("%.0f", watermelonId));
     pearLabel.setText(pearName +"--------------------------$"+String.format("%.2f", pearPrice)+ "------------------Item ID: " + String.format("%.0f", pearId));
     peachLabel.setText(peachName +"------------------------$"+String.format("%.2f", peachPrice)+ "------------------Item ID: " + String.format("%.0f", peachId));
        }
    }
   class totalCostClass implements ActionListener{//action calculates the total cost for out customer
      @Override  
        public void actionPerformed(ActionEvent e) {
         try{
         double apples = Double.parseDouble(apple.getText()); 
         double oranges = Double.parseDouble(orange.getText()); 
         double watermelons = Double.parseDouble(watermelon.getText()); 
         double pears = Double.parseDouble(pear.getText()); 
         double peaches = Double.parseDouble(peach.getText()); 
         DiscountCheck check = new DiscountCheck();
         double appleSub = applePrice;
         
         if (apples < 0 || oranges < 0 || watermelons < 0 || pears < 0 || peaches < 0 ){
             NumberFormatException numexception = new NumberFormatException();
             
             throw  numexception;//manually will throw an exception if numbers are less than 0 
         }
         
         
         appleSub = check.checkDiscount(apples, appleSub);//check for discount
         
         double orangeSub = orangePrice;//set price
         orangeSub = check.checkDiscount(oranges, orangeSub);//check for discount
         
         double watermelonSub = watermelonPrice;//set price
         watermelonSub = check.checkDiscount(watermelons ,watermelonSub);//check for discount
         
         double pearSub = pearPrice;//set price
         pearSub = check.checkDiscount(pears , pearSub);//check for discount
         
         double peachSub = peachPrice;//set price
         peachSub = check.checkDiscount(peaches, peachSub);//check for discount
         
         
         double total = appleSub + orangeSub + watermelonSub + pearSub + peachSub; //get total
         String textTotal = String.valueOf(String.format("%.2f", total)); //parse to a string
         totalCost.setText(textTotal); //display in text field
         
         paymentMethod.setText("Please select a payment method below");//display in text field
         installments.setText("installments");//display in text field
         fullAmmount.setText("Full Ammount");//display in text field
                }
        catch (Exception ex) {
            
             errorAlert.setText("Correct Fields need to be filled out/Numbers have to be positive");//display in label
         }  
       }
     }  
   
      
  class installmentsClass implements ActionListener{    
     @Override
     public void actionPerformed(ActionEvent e) {
         try{
          double x = Double.parseDouble(totalCost.getText()); //parse the string to a double
          x = x* 1.06;
          finalAmmount.setText(String.format("%.2f", x));//display in text field
          paymentMethod.setText("Final Ammount: ");//display in label
          displayInvoice.setText("Display Invoice");//display in text field
          saveInvoice.setText("Save Invoice to External File");//display in text field
         }
         catch (Exception ex) {
             errorAlert.setText("Correct Fields need to be filled out");//display in label
         }
       }
    }
        
 class fullAmmountClass implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e) {
        try{
        double x = Double.parseDouble(totalCost.getText()); 
          x = x *0.95 * 1.06;
         finalAmmount.setText(String.format("%.2f", x));//display in text field
         paymentMethod.setText("Final Ammount: ");//display in label
         displayInvoice.setText("Display Invoice");//display in text field
         saveInvoice.setText("Save Invoice to External File");//display in text field
         }
         catch (Exception ex) {
             errorAlert.setText("Correct Fields need to be filled out");//display in label
         }
       }
    }
          
   class displayInvoiceClass implements ActionListener{
         
     @Override
     public void actionPerformed(ActionEvent e) {//action creates a new GUI to display the invoice
         try {
             String first = firstName.getText();      //retrieve all data from the text fields. 
             String last = lastName.getText();
             String id = custIdField.getText();
             double apples = Double.parseDouble(apple.getText());
             double oranges = Double.parseDouble(orange.getText());
             double watermelons = Double.parseDouble(watermelon.getText());
             double pears = Double.parseDouble(pear.getText());
             double peaches = Double.parseDouble(peach.getText());
             double total = Double.parseDouble(totalCost.getText());
             double finaltotal = Double.parseDouble(finalAmmount.getText());
             
                       
             displayInvoice frame2 = new displayInvoice(); //create a new window 
             DiscountCheck check = new DiscountCheck();
            frame2.setTitle("Ryans Fruit Cart GUI");
            frame2.setSize(330,630);
            frame2.setLocationRelativeTo(null); 
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);
            frame2.setLayout(new GridLayout(17,1));            
            frame2.add(new JLabel("*********************************************************"));
            frame2.add(new JLabel("Thank you for shopping with RyGuy"));
            frame2.add(new JLabel("*********************************************************"));
            frame2.add(new JLabel("Customer Name: "+ first + " " + last));
            frame2.add(new JLabel("Customer ID: "+ id));
            frame2.add(new JLabel("*********************************************************"));
            frame2.add(new JLabel("Ammount of Apples: " + String.format("%.0f", apples) + "   Subtotal for item:  $" + String.format("%.2f", check.checkDiscount(apples , 1.00)))); 
            frame2.add(new JLabel("Ammount of Oranges: " + String.format("%.0f", oranges) + "   Subtotal for item:  $" + String.format("%.2f", check.checkDiscount(oranges , 1.00)))); 
            frame2.add(new JLabel("Ammount of Watermelons: " + String.format("%.0f", watermelons) + "   Subtotal for item:  $" + String.format("%.2f", check.checkDiscount(watermelons , 1.00)))); 
            frame2.add(new JLabel("Ammount of Pears: " + String.format("%.0f", pears) + "   Subtotal for item:  $" + String.format("%.2f", check.checkDiscount(pears , 1.00)))); 
            frame2.add(new JLabel("Ammount of Peaches: " + String.format("%.0f", peaches) + "   Subtotal for item:  $" + String.format("%.2f", check.checkDiscount(peaches , 1.00)))); 
            frame2.add(new JLabel("*********************************************************"));
            frame2.add(new JLabel("Total Cost Before Tax:  $"+ String.format("%.2f", total)));
            frame2.add(new JLabel("Total Cost After Tax:  $"+ String.format("%.2f", finaltotal)));
            frame2.add(new JLabel("*********************************************************"));
            frame2.add(new JLabel("Thank you for shopping with RyGuy"));
            frame2.add(new JLabel("*********************************************************"));
         } catch (Exception ex) {
             errorAlert.setText("Correct Fields need to be filled out");
         }
        }
    }
          
          class saveInvoiceClass implements ActionListener{
         
     @Override
     public void actionPerformed(ActionEvent e)  {
         try {
             String first = firstName.getText();
             String last = lastName.getText();
             String id = custIdField.getText();
             double apples = Double.parseDouble(apple.getText());
             double oranges = Double.parseDouble(orange.getText());
             double watermelons = Double.parseDouble(watermelon.getText());
             double pears = Double.parseDouble(pear.getText());
             double peaches = Double.parseDouble(peach.getText());
             double total = Double.parseDouble(totalCost.getText());
             double finaltotal = Double.parseDouble(finalAmmount.getText());
             
             Invoice save = new Invoice();
             save.saveInvoice(first, last, id, apples, oranges, watermelons, pears, peaches, total , finaltotal);
        } 
         catch (Exception ex) {
             errorAlert.setText("Correct Fields need to be filled out");            
         }   
       }
    }
                
    public static void main(String[] args) throws Exception {
   
        
System.out.println("Please input 1 to use GUI");
System.out.println("Please input 2 to use counsel");
int type = 0;
Scanner input = new Scanner (System.in);
while (!input.hasNext("[1-2]+")) {//input validation
 System.out.println("Please enter the number 1 or 2");
 input.next();
}
type = input.nextInt(); 

switch(type){ 
    case 1:     GUI frame = new GUI();//creates new GUI
    
                double priceIds[] = new double[10];//array for getting Price GUI from external file
                String fruitNames[] = new String[5];//array for getting Fruit names GUI from external file
                String customer[] = new String[3];//array for getting customer GUI from external file
    
                fruitNames = frame.getNames(); //sets frut names to array fruitNames
                priceIds = frame.getPrices();  //sets Price and Ids to array priceIds
                customer = frame.getCustomer(); //Sets customer info to customer
    
                frame.getItemName0(fruitNames); //gets item name: apple
                frame.getItemName1(fruitNames); //gets item name: orange
                frame.getItemName2(fruitNames); //gets item name: watermelon
                frame.getItemName3(fruitNames); //gets item name: pear
                frame.getItemName4(fruitNames); //gets item name: peach
                frame.setFruitName();           //sets fruit names 
    
                frame.getTotalAmmt0(priceIds); //gets price 1 apple: $1.00
                frame.getTotalAmmt1(priceIds); //gets price 2 orange: $1.25
                frame.getTotalAmmt2(priceIds); //gets price 3 watermelon: $2.00
                frame.getTotalAmmt3(priceIds); //gets price 4 pear: $1.50
                frame.getTotalAmmt4(priceIds); //gets price 5 peach: $1.75
                frame.setPrices();             //sets external prices
    
                frame.getItemNum0(priceIds);  //gets item ID: apple
                frame.getItemNum1(priceIds);  //gets item ID: orange
                frame.getItemNum2(priceIds);  //gets item ID: watermelon
                frame.getItemNum3(priceIds);  //gets item ID: pear
                frame.getItemNum4(priceIds);  //gets item ID: peach
                frame.setIds();               //sets item ID info
    
                frame.getFirstName(customer); //gets existing customer first name
                frame.getLastName(customer);  //gets existing customer last name
                frame.getUserId(customer);    //gets existing customer ID 
                frame.setCustName();          //sets customer info
    
                frame.setTitle("Ryans Fruit Cart GUI"); //adds title to GUI
                frame.setSize(895,600);                //sets size of GUI
                frame.setLocationRelativeTo(null);      //location relative to the center
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //will exit when the x is hit
                frame.setVisible(true);                               //the GUI is set to be visable 
                break; 
                
                
    case 2:     double adminPrice = 1;//initilizes admin price to 1
                GUI frame2 = new GUI();        
        
                frame2.displayAdminAcess();//will display to user if they would like to enter admin panel or not
                String admin = frame2.getFirst();//sets string admin == to the first user input
                frame2.setFirst();//sets user input for first name or admin access
         
                if(admin.equals("MCS3603")){//if string admin == MCS3603
                frame2.displayAdmin();// asks for display name of new product
                frame2.getAdminName();//gets the name of the new admin product
                frame2.displayAdmin2();//displays the invoice for the customer
                adminPrice = frame2.getAdminPrice();////gets the admins price of the item and brings the price back to main
                frame2.displayAdmin3();//display if the item was added sucessfully
                frame2.setAdmin();//sets the name and price of the item the admin added
                frame2.getFirst();//gets first name of the customer
                frame2.setFirst();//sets the first name of the customer
             }
            
                frame2.getLast();//gets last name from customer
                frame2.setLast();//sets last name for user
                System.out.println(frame2.printName());  //gathers and displays first and last name of customer
         
                frame2.displayMenu(admin);//displays the menu to the user
         
                frame2.displayWatermelon();//asks for number watermelon
                frame2.getAmmount(); //gets ammount from user
                frame2.setAmmount1();//sets ammount of watermelons
         
                frame2.displayMango();//asks for number mangos
                frame2.getAmmount(); //gets ammount from user
                frame2.setAmmount2();//sets ammount of mangos
         
                frame2.displayBanana();//asks for number banana
                frame2.getAmmount(); //gets ammount from user
                frame2.setAmmount3();//sets ammount of bananas
         
                frame2.displayPeach();//asks for number watermelon
                frame2.getAmmount(); //gets ammount from user
                frame2.setAmmount4();//sets amount of peaches
         
                if(admin.equals("MCS3603")){//if string admin == MCS3603
                 frame2.displayAdminItem();//displays admin added item
                 frame2.getAmmount(); //gets ammount from user
                 frame2.setAmmount5(); //sets ammount of admin item
             
              }
         
                frame2.setTax();//gets the tax ammount
                frame2.setFivePerc();//sets 5 percent discount
                frame2.setTenPerc();//sets 10 percent discount 
         
                double userAmmtArry[] = frame2.extractAmmt(admin);//returns array of ammount of items user has selected
                double priceArr[] = new double[5];//declares a new array to hold prices
                priceArr[0] = 2.00;//watermellon price
                priceArr[1] =  1.50;//mango price
                priceArr[2] = 1.25;//banana price
                priceArr[3] = 0.75;//peach price
         
                if(admin.equals("MCS3603")){//if string admin == MCS3603
                  priceArr[4] = adminPrice; //admin item price
             }                  
                           
                double tempPrice[] = new double[5];//declares new temp price array
                tempPrice[0] = frame2.getTotal(priceArr ,userAmmtArry,  0, 0); //calculates price 1 and stores to array
                tempPrice[1] = frame2.getTotal(priceArr ,userAmmtArry,  1, 1); //calculates price 2 and stores to array
                tempPrice[2] = frame2.getTotal(priceArr ,userAmmtArry,  2, 2); //calculates price 3 and stores to array
                tempPrice[3] = frame2.getTotal(priceArr ,userAmmtArry,  3, 3); //calculates price 4 and stores to array

                if(admin.equals("MCS3603")){
                 tempPrice[4] = frame2.getTotal(priceArr ,userAmmtArry,  4, 4);//calculates price 5 and stores to array if applicable
                 frame2.getTotalAmmt4(tempPrice);//gets subtotal 5
              }                  
            
         
                frame2.getTotalAmmt00(tempPrice);//gets subtotal 1
                frame2.getTotalAmmt11(tempPrice);//gets subtotal 2
                frame2.getTotalAmmt22(tempPrice);//gets subtotal 3
                frame2.getTotalAmmt33(tempPrice);//gets subtotal 4
                frame2.setTotals();//sets all final subtotals 
                frame2.getTrueTotal(admin);//calculates and gets the true total of the order from subtootals
                frame2.setTrueTotal(); //sets the true total of the order 

                frame2.displayInstallments();//displays to customer if they want to pay in installments or full ammount 
                frame2.setInstallments();//sets the user responce to the above statement

                String discount = frame2.checkForInstall();//gives string discount user responce
                boolean fullAmmt = discount.equals("f");//boolean true if == to f
                boolean installAmmt = discount.equals("i");//boolean true if == to o

                frame2.diplayInvoice();

                 if(admin.equals("MCS3603")){
                     frame2.displayAdmin4();
                 }

                 if(fullAmmt == true){//if statement will determine how to calculate total based of user responce 
                     double x = 0.95;//grants 5 percent off for paying the full ammount

                     frame2.diplayInvoice2(x);//displays the second part of the invoice: total and total + tax
                 }
                 else if(installAmmt  == true)
                 {
                     double x = 1;//grants no dicount for paying in installments
                     frame2.diplayInvoice2(x);//displays the second part of the invoice: total and total + tax
                 }
                 else{
                    System.out.println("please start over and select a valid field");//extra validation of input
                 }
    }   
   }
}

