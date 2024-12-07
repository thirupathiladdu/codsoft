import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String play = "yes";

        while (play.equals("yes")) {

            Random rand = new Random();
            int randNum = rand.nextInt(100) + 1; 
            int guess = -1;
            int tries = 0;

            while (guess != randNum) {
                System.out.print("Guess a number between 1 to 100: ");
                guess = reader.nextInt();
                tries++;

                if (guess == randNum) {
                    System.out.println("Awesome! You guessed the number!");
                    System.out.println("It only took you " + tries + " guesses! ");
                    System.out.print("Would you like to play again? Yes or No: ");
                    play = reader.next().toLowerCase();
                } else if (guess > randNum) {
                    System.out.println("Your guess is too high, try again.");
                } else {
                    System.out.println("Your guess is too low, try again.");
                }
            }
        }
    }
}