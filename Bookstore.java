package bookstore;
import java.text.DecimalFormat;//Utility so DecimalFormat can be declared.
import java.util.Scanner; //Utility so scanner can be declared. 
/**
 * Filename: bookstore.java
 * @author Tony
 */
public class Bookstore {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //Scanner class for user inputs.
//Begin majority of variable declaration/initialization.
    String[] items = {"Notepads", "Pens", "Pencils", "Erasers", "Markers"}; //Declaring and initializing string array for items.
    int maxq = 0; int minq = 0;
    double maxp = 0; double minp = 0;
    int[] quantity = new int[5]; //Declaring int array for quantity.
    double max = 0; double min = 0;
    double total = 0; 
    double[] price = new double[5]; //Declaring double array for price.
    String maxitem = null; //Null because java wants them initialized. 
    String minitem = null; //" "
    DecimalFormat f = new DecimalFormat("##.00");//Formating decimal place to 2 spaces. Will be needed for outputting throughout program.
//End majority of variable declaration/initialzation.
//Begin obtaining quantity of items.
    System.out.println("Before we begin, please start by entering your inventory information.");
    for(int index = 0; index < items.length;){ //Loop assigning quantities for each item.
        System.out.println("No decimals! Please enter your stock quantity for "+items[index]+":");
        quantity[index] = input.nextInt(); //Takes user's input for quantity.
        if(quantity[index]<0){
        System.out.println("Must be equal or greater than 0!");
        continue;//Skips index++ unless user inputs valid number.
        }
        index++;//+1 to index if user inputs valid number.
    }
//End obtaining quantity of items.
//Begin obtaining price of items.
    for(int index2 = 0; index2 < items.length;){//Loop assigning numbers for each item price.
        System.out.println("Digits only! Please enter the price for "+items[index2]+":");
        price[index2] = input.nextDouble(); //Takes user's input for price.
        if(price[index2]<0){
        System.out.println("Must be equal or greater than 0!");
        continue;//Skips index++ unless user inputs valid number.
        }
        index2++;//+1 to index2 if user inputs valid number.
    }
//End obtaining price of items.
    System.out.println("Thank you for your information!");
    System.out.println("Welcome to Gator Bookstore Inventory Management!");
//Begin infinite loop unless user inputs 'e'.
do{
    System.out.println("Types of Operations: \nPrint Inventory(p), Check for low inventory(c), "
            +"Highest and lowest inventory(m), Total inventory value(v), Exit(e).");
    char operation = input.next().charAt(0); //User input allowing switch to take place.
//Begin Switch Statement.
    switch(operation){
//If user inputs char 'p', program will print inventory information.        
    case 'p': 
        System.out.println("Printing Inventory information...");
        for(int i = 0; i < items.length; i++){
        System.out.println("Item Name: "+items[i]+", Quantity: "+quantity[i]+", "+"Price per: $"+f.format(price[i])+", "+"Total Item Value: $"+f.format((double)quantity[i]*price[i]));
        }
        break; //Breaks to end of loop. Also restarts operations choice list.
//If user inputs 'c', program will check inventory if item is less than 5 and input inventory information for each. Else, will tell user item is good.      
    case 'c': 
        for(int i = 0;i < quantity.length; i++){ //For loop checking all quantity values.
            if(quantity[i]<5){ //Checks if quantity is less than 5.
            System.out.println("Low Quantity! Item Name: "+items[i]+", Quantity: "+quantity[i]+", "+"Price per: $"+f.format(price[i])+", "+"Total Item Value: $"+f.format((double)quantity[i]*price[i]));
            }
            else {
            System.out.println(items[i]+" has enough stock.");
            }
        }
        break;//Breaks to end of loop. Also restarts operations choice list.
//If user inputs 'm', program will check for maximum/minimum value after multiplying quantity and price.
    case 'm':  
        System.out.println("Highest Total Item Value(s):");
        for(int i = 0; i < items.length; i++){ //For loop checking maximum value.
            if((double)quantity[i]*price[i] > max){
               max = (double)quantity[i]*price[i]; //assigning maximum quantity to variable max.
            }
        }for(int i = 0; i < items.length; i++){ //For loop to recheck all total values.
            if((double)quantity[i]*price[i] == max){ //Checks if the product of quantity and price equals variable max.
               System.out.println("Item Name: "+items[i]+", Quantity: "+quantity[i]+", "+"Price per: $"+f.format(price[i])+", "+"Total Item Value: $"+f.format(max));
            }
        }
        System.out.println("Lowest Total Item Value(s):");
        min = max; //Precursor logic telling java minimum is 'atleast' equal to max, so that Java will check for lower values.
        for(int ind = 0; ind < quantity.length; ind++){ //For loop checking for minimum value.
            if((double)quantity[ind]*price[ind] < min){
               min = (double)quantity[ind]*price[ind]; //assigning minimum quantity to variable min.
               }
        }for(int ind = 0; ind < items.length; ind++){ //For loop to recheck all total values.
            if((double)quantity[ind]*price[ind] == min){ //Checks if the product of quantity and price equals variable min. 
               System.out.println("Item Name: "+items[ind]+", Quantity: "+quantity[ind]+", "+"Price per: $"+f.format(price[ind])+", "+"Total Item Value: $"+f.format(min));
            }
        }
            break;//Breaks to end of loop. Also restarts operations choice list.
//If user inputs 'v', program will calculate total inventory value.
    case 'v': 
        System.out.println("Calculating total inventory value...");
        for(int i = 0; i < items.length; i++){
            total += (double)quantity[i]*price[i]; //Calculates value by multiplying all item's quantities and prices and adding it to a total.
        }
        System.out.println("Your total inventory value equals: $"+f.format(total)); //Output total inventory value.
        break; //Breaks to end of loop. Also restarts operations choice list.
//Exits out of program.
    case 'e':
        System.out.println("Thank you for using the Gator Bookstore Inventory Management!");
        System.exit(0);
    default:  //Incase user wants to input invalidly. 
        System.out.println("That was not a valid input, please try again!");
//End Switch Statement.
}
//Recycle infinite loop again unless 'e' is chosen to exit program on next iteration.
}while(true); 
}
}
