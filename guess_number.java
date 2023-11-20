import java.util.Random;
import java.util.Scanner;

  



public class guess_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7; // You can change the maximum number of attempts here
        int score = 0;
        String choice;
        System.out.println("\n********************Welcome to the Number Guessing Game*********************\n");
 
        rule();
        System.out.print("\n Press Enter to continue ********************* ");
        scanner.nextLine();
        clearConsole();
        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound);
            System.out.println("\n Now your term --------------\n");
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            choice=scanner.next();
            clearConsole();
        } while (choice.equalsIgnoreCase("yes"));
        clearConsole();
        System.out.println("Thanks for playing! Your total score is: " + score +"\n");
        scanner.close();
    }

      private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Handle exceptions (e.g., if the command is not supported)
            e.printStackTrace();
        }
    }

    static void rule(){
        System.out.println("\n************** Rule of this game *****************");
        System.out.println("1. You have to enter the range of this number game.");
        System.out.println("2. You have to guess a number between a given range.");
        System.out.println("3. Depending your guess and generated number , your result will show.");
        System.out.println("4. You can play multiple round but In each round you can maximun attemp 3times.");
        System.out.println("5. After Ending the Game you will see the final result.");
        System.out.println("*****************************************************************");
    }
}
