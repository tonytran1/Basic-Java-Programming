package simplebank;

/**
 * Filename: SimpleBank.java
 * This program stimulates a simple bank account which consists of a checkings and savings account.
 * @author Tony
 */
public class SimpleBank {

    public static String menu(String menu){ //Stringing together the menu. 
        menu = "Welcome to Gater Bank! \nCurrent Checking Balance: $500 \nCurrent Savings Balance: $1000\nWhat type of transaction would you like to use today?\n"
            + "Checking(c) or Savings(s)?\n";
    return menu;
    }
    public static void balance(String msg, int num1){
        System.out.println(msg+num1+"."); //Prints balance for user. 
    }
    public static int deposit(int num1, int num2){
       Scanner input = new Scanner(System.in);//Scanner needed for user inputs
       num2 = input.nextInt(); //User inputs how much they would like to deposit into checking account.
       return (num1+num2); //return value of adding num1 and num2.
    }
    public static int withdraw(int num1, int num2, int num3){
       Scanner input = new Scanner(System.in); //Scanner needed for user inputs
       num2 = input.nextInt();
       num3 = num1-num2; //num 3 now equals num1-num2.
       return num3; //return value of subtracting num1 and num2.
    }
    public static void main(String[] args) {
        //Variable Declaration
        int cbalance = 500;
        int cadd = 0;
        int csubtract = 0;
        int sbalance = 1000;
        int sadd = 0;
        int csum = 0;
        int ssum = 0;
        int ssubtract = 0;
        String smsg = "Your current Savings account balance is $";
        String cmsg = "Your current Checking account balance is $";
        String menu = null;
        //End of Variable Declaration
        Scanner input = new Scanner(System.in); //Creates scanner object.
        System.out.print(menu(menu));
        char bank = input.next().charAt(0); //User inputs whether they want Savings(s) or Checking(c).
        if(bank == 'c'){ //User inputs 'c' for checking account.
                System.out.println("Check Balance(c), Deposit(d), or Withdrawal(w).");
        char userinput1 = input.next().charAt(0);
        switch(userinput1) { //Start switch statement.
        case 'c': //If user inputs 'c', balance check will commence.
            balance(cmsg, cbalance); //Outputs balance.
            break;
        case 'd': //If user inputs 'd', deposit command will commence.
            System.out.println("How much would you like to deposit into your Checking account?");
            System.out.println("Current Checking Balance: $"+deposit(cbalance,cadd)); //Math that adds deposited amount into checking account.
            break;
        case 'w': //If user inputs 'w', withdraw command will commence.
            for(int i = 0; i < 1;){
            System.out.println("How much would you like to withdraw from your Checking account?");
            csum = withdraw(cbalance,csubtract,csum);
            if(csum < 10){ //Checks if checking account is lower than $10, if it is, message will show.
                System.out.println("Your checking balance must be higher than $10!");
            }else{
                System.out.println("Your new Checking balance is $"+csum);
                i++; //i++ to remove from loop if valid input is used.
                }
            }
            break;
        default:
            System.out.println("Invalid command, please restart program."); //User inputs invalid command.
        }
            }else{
            System.out.println("Invalid command. Ending program...");
            }
        if(bank == 's'){ //User inputs 'c' for checking account.
                System.out.println("Check Balance(c), Deposit(d), or Withdrawal(w).");
        char userinput1 = input.next().charAt(0);
        switch(userinput1) { //Start switch statement.
        case 'c': //If user inputs 'c', balance check will commence.
            balance(smsg, sbalance); //Outputs balance.
            break;
        case 'd': //If user inputs 'd', deposit command will commence.
            System.out.println("How much would you like to deposit into your Savings account?");
            System.out.println("Current Savings Balance: $"+deposit(sbalance,sadd)); //Math that adds deposited amount into checking account.
            break;
        case 'w': //If user inputs 'w', withdraw command will commence.
            for(int i = 0; i < 1;){
            System.out.println("How much would you like to withdraw from your Savings account?");
            ssum = withdraw(sbalance,ssubtract,ssum);
            if(ssum < 100){//Checks if Savings account is lower than $10, if it is, message will show.
                System.out.println("Your Savings balance must be higher than $10!");
            }else{
                System.out.println("Your new Savings balance is $"+ssum);
                i++; //i++ to remove from loop if valid input is used.
                }
            }
            break;
        default:
            System.out.println("Invalid command, please restart program."); //User inputs invalid command.
        }
            }
}
}
