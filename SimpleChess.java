/*
 * Simple Chess Java
 */
package simplechess;

import java.util.Scanner; //Needed for scanner class usability.

/**
 *
 * @author Tony
 */
public class SimpleChess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] team = {"White", "Black"}; //Initializing and declaring color choices.
//2D Array declaring Chess Board.
        String[][] board = {{"White Rook", "White Knight", "White Bishop", "White Queen", "White King", "White Bishop", "White Knight", "White Rook"},
        {"White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn"},
        {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"},
        {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"},
        {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"},
        {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"},
        {"Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn"},
        {"Black Rook", "Black Knight", "Black Bishop", "Black Queen", "Black King", "Black Bishop", "Black Knight", "Black Rook"}};
        System.out.println("What color would you like to play, White(w) or Black(b)?");
//User choices w for White and b for Black.
        char color = input.next().charAt(0);
//Begin Infinite Loop for playing simplified version of Chess.
        do {
//Begin Switch Statement. Notice there are no breaks from each case, so program will continue and hit the infinite loop.
            switch (color) {
                case 'w': //If user choices w, case w will begin first.
                    System.out.println("You are currently playing for the color " + team[0] + "!");
                    System.out.println("Here is the current chess board:\n");
                    for (int r = 0; r < board.length; r++) { //For loop printing out current chess board.
                        System.out.print("Row " + r + ": ");
                        for (int c = 0; c < board[r].length; c++) {
                            System.out.print(board[r][c] + ", ");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < 1;) { //For loop incase user inputs invalidly.
                        System.out.println("Make a move!");
                        System.out.println("Specify the location of the piece: \nRow Index?");
                        int wprow = input.nextInt(); //User inputs White Position Row.  
                        System.out.println("Column Index?");
                        int wpcolumn = input.nextInt(); //User inputs White Position Column.
                        String wposition = board[wprow][wpcolumn]; //Declaring wposition as the user selected position for easier if statement readability.
                        if (wposition == "White Rook" || wposition == "White Knight" || wposition == "White Bishop"
                                || wposition == "White Queen" || wposition == "White King" || wposition == "White Pawn") {
                            i++; //If user inputs everything correctly, 1 will be added to i, which will then break the loop.
                            for (int ii = 0; ii < 1;) { //For loop incase user inputs invalidly. 
                                System.out.println("What position would you like to move it to?");
                                System.out.println("Specify the destination of the piece you would like to move:\nRow Index?");
                                int wdrow = input.nextInt(); //User inputs White Destination Row.
                                System.out.println("Column Index?");
                                int wdcolumn = input.nextInt(); //User inputs White Destination Column.
                                if (board[wdrow][wdcolumn] == "Empty") {
                                    board[wdrow][wdcolumn] = board[wprow][wpcolumn]; //Starting position will now be swapped to the destination.
                                    board[wprow][wpcolumn] = "Empty"; //Starting position will now be declared as Empty.
                                    ii++; //If user inputs validly, ii+1 will happen and program will continue.
                                    System.out.println("Your move was successful!");
                                    System.out.println("Here is the current chess board:\n");
                                    for (int r = 0; r < board.length; r++) { //For loop printing current chess board positions.
                                        System.out.print("Row " + r + ": ");
                                        for (int c = 0; c < board[r].length; c++) {
                                            System.out.print(board[r][c] + ", ");
                                        }
                                        System.out.println();
                                    }
                                    System.out.println("\nWould you like to continue playing? Yes(y) or No(n)?");
//If user selects n, the game will end. Otherwise continue playing.
                                    char cnt = input.next().charAt(0);
                                    if (cnt == 'n') { //Game ends if 'n' is inputed.
                                        System.out.println("Thank you for playing Simple Chess!");
                                        System.exit(0);
                                    }
                                    if (cnt == 'y') {//Game continues if 'y' is inputed.
                                        System.out.println("Continue...");
                                    }
                                } else { //If user inputs destination invalidly, message will display.
                                    System.out.println("The destination must be Empty, try again!");
                                }
                            }
                        } else { //If user inputs anything other than one's own piece, message will display.
                            System.out.println("There is nothing to move; one must choose a piece from one's own color! Try again.");
                        }
                    }
                case 'b': //If user selects b, black will begin first.
                    color = 'w'; //Color will now be 'w' so that next iteration of the infinite loop will begin with white's turn.
                    System.out.println("You are currently playing for the color " + team[1] + "!");
                    System.out.println("Here is the current chess board:\n");
                    for (int r = 0; r < board.length; r++) { //For loop printing current chess board position.
                        System.out.print("Row " + r + ": ");
                        for (int c = 0; c < board[r].length; c++) {
                            System.out.print(board[r][c] + ", ");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < 1;) { //Begin for loop incase user inputs invalidly.
                        System.out.println("Make a move!");
                        System.out.println("Specify the location of the piece you would like to move: \nRow Index?");
                        int bprow = input.nextInt(); //User inputs Black Position Row.
                        System.out.println("Column Index?");
                        int bpcolumn = input.nextInt(); //User inputs Black Position Column.
                        String bposition = board[bprow][bpcolumn]; //Declaring bposition as user selected position for easier if statement readability.
                        if (bposition == "Black Rook" || bposition == "Black Knight" || bposition == "Black Bishop" || //If statement to check if valid position.
                                bposition == "Black Queen" || bposition == "Black King" || bposition == "Black Pawn") {
                            i++; //If user inputs validly, i+1 will happen and program will continue.
                            for (int ii = 0; ii < 1;) { //For loop incase user inputs invalidly.
                                System.out.println("What position would you like to move it to?");
                                System.out.println("Specify the destination of the piece:\nRow Index?");
                                int bdrow = input.nextInt(); //User inputs Black Destination Row.
                                System.out.println("Column Index?");
                                int bdcolumn = input.nextInt(); //User inputs Black Destination Column.
                                if (board[bdrow][bdcolumn] == "Empty") {
                                    board[bdrow][bdcolumn] = board[bprow][bpcolumn];
                                    board[bprow][bpcolumn] = "Empty";
                                    ii++; //If user inputs validly, program will continue by adding 1 to ii.
                                    System.out.println("Your move was successful!");
                                    System.out.println("Here is the current chess board:\n");
                                    for (int r = 0; r < board.length; r++) { //For loop printing current chess board positions.
                                        System.out.print("Row " + r + ": ");
                                        for (int c = 0; c < board[r].length; c++) {
                                            System.out.print(board[r][c] + ", ");
                                        }
                                        System.out.println();
                                    }
                                    System.out.println("\nWould you like to continue playing? Yes(y) or No(n)?");
//If user inputs 'n' program will exit, otherwise it will continue.
                                    char cnt = input.next().charAt(0);
                                    if (cnt == 'n') { //If user inputs 'n', program will exit and message will be printed.
                                        System.out.println("Thank you for playing Simple Chess!");
                                        System.exit(0);
                                    }
                                    if (cnt == 'y') { //If user inputs 'y', continue message will appear.
                                        System.out.println("Continue...");
                                    }
                                } else { //Else statement if user inputs invalid destination.
                                    System.out.println("The destination must be Empty in order to make the move, please try again!");
                                }
                            }
                        } else { //Else statement if user inputs invalid starting position.
                            System.out.println("There is nothing to move; one must choose a piece from one's own color! Try again.");
                        }
                    }
//Technically end of Switch Statement, but will continue regardless because inside an infinite loop.
            }
        } while (true); //Infinite loop.
    }
}
