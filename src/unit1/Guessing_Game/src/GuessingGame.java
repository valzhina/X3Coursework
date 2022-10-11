import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        boolean correctGuess = false;
        //int userGuess = 0;
        int increment = 0;

        System.out.println("Hello user. What is your name?");
        String userName = input.nextLine(); //provide a new line for a user to input their name + save it to a variable type string

        System.out.println("Welcome " + userName + ". I’m thinking of a number between 1 and 10.");

        Random rand = new Random();
        int randNumber =  rand.nextInt(10);

        System.out.println("Try to guess my number.");

        while(correctGuess == false) {

            try {
                int userGuess = input.nextInt();
                input.nextLine();

                if (userGuess > 10 || userGuess < 0) {
                    System.out.println("You’re guess is out of range. Please try again.");
                }
                else if (userGuess > randNumber) {
                    increment++;
                    System.out.println("You’re guess is too high. Please try again.");
                }
                else if (userGuess < randNumber) {
                    increment++;
                    System.out.println("You’re guess is too low. Please try again.");

                }
                else if (userGuess == randNumber){
                    increment++;
                    System.out.println("Well done, " + userName + "! You found my number in " + increment + " tries!");
                    correctGuess = true;
                }
            }
            catch (Exception e){
                String badInput = input.next();
                input.nextLine();
                System.out.println("That’s not an integer, try again");
                continue;
            }
        }

    }
}
