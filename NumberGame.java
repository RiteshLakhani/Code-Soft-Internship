import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of Chances to Play The Game
        int chances = 10;

        // if we play the game another time
        boolean playAgain = true;

        System.out.println("Welcome to the Number Game");

        System.out.println("You Have " + chances + " chances to Guess The Correct Number and Win the Game ");

        System.out.println("Please choose a number between 1 and 100.");

        while (playAgain) {
            int rand = getRandNumber(1, 100);
            boolean guess = false;
            int attempts = 0; // Variable to track the number of attempts

            for (int i = 0; i < chances; i++) {
                int user = 0;
                boolean validInput = false;

                // Prompt for user to Enter Number between 1 to 100
                while (!validInput) {
                    System.out.println("Enter Your Guess Number " + (i + 1) + ":  ");
                    user = sc.nextInt();
                    if (user >= 1 && user <= 100) {
                        validInput = true;
                    } else {
                        System.out.println("Please choose a number between 1 and 100.");
                    }
                }

                attempts++;

                if (user == rand) {
                    guess = true;
                    System.out.println("Your guess is correct, and you won the game!!!!");
                    System.out.println("You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (user > rand) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
            }

            if (guess == false) {
                System.out.println(
                        "Your Max number of Guess attempts is Used!!!!! You Lose the Game!!!! The Random Number is "
                                + rand);
            }

            System.out.println("Do You Want To Play Again(Y/N)??");
            String ans = sc.next();
            playAgain = ans.equalsIgnoreCase("y");
        }

        System.out.println("Hope You Like this Game!!!");

        sc.close();
    }

    public static int getRandNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
