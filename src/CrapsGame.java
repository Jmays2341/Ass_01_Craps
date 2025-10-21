import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Rolling the dice...");
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                int point = sum;
                System.out.println("Point is set to " + point + ". Keep rolling to make your point!");

                boolean continueRolling = true;
                while (continueRolling) {
                    System.out.println("Rolling again...");
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point! You win!");
                        continueRolling = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}