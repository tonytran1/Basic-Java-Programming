package bmicalculator;
import java.util.Scanner; //Needed to use scanner for program.
/**
 * Filename: BMICalculator.java
 * @author Tony
 */
public class BMICalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Creates scanner object.
        System.out.println("This program calculates your Body Mass Index");
        System.out.println("Enter your name:");
        String name = input.nextLine(); //User inputs name.
        System.out.println("Please enter your height in feet and inches");
        System.out.println("How many Feet?(Should only be one digit)");
        byte feet = input.nextByte(); //User inputs first value of height variable.
        if(feet>9) {System.out.println("Hey wtf, I said only one digit");
        feet = input.nextByte();}
        System.out.println("How many inches?");
        byte inches = input.nextByte(); //User inputs second value of height variable.
        System.out.println("How many pounds do you weigh?");
        double pounds = input.nextDouble(); //User inputs weight in pounds.
        System.out.println("\nThank you for your information");
        int heighttotal = ((feet*12)+inches); //Calculates total height in inches.
        Double power = Math.pow (heighttotal, 2); //Takes the total height to the power of 2 to use for BMI calculation.
        Double BMI = ((pounds/power)*703); //BMI calculation.
        System.out.println("Name: "+name);
        System.out.println("Height: "+feet+" ft,"+inches+" in = "+heighttotal+" in"); //Prints height in two different formats.
        System.out.println("Weight: "+pounds);
        System.out.printf("BMI: %.1f\n",BMI); //Prints BMI rounded by one decimal point. 
        System.out.println("\nBMI Categories:");
        System.out.println("Underweight = <18.5");
        System.out.println("Normal weight = 18.5-24.9");
        System.out.println("Overweight = 25-24.9");
        System.out.println("Obesity = BMI of 30 or greater");
    }
    
}
