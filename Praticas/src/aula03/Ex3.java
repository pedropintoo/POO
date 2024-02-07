package aula03;
import java.util.Random;
import java.util.Scanner;
import utils.UserInput;

public class Ex3 {
    public static void main(String[] args) {
        // Declarations
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess,attemps=0;
        String option;

        // The game
        do {

            // random.nextInt(100) return integer between 0 and 99
            int number = random.nextInt(100) + 1;


            do{
                // UserInput: integer between 0 and 100
                guess = UserInput.IntegerInput(0,100,"Integer between [0,100]: ");
                attemps++;

                // Tips
                tipGuess(guess, number);

            }while (guess != number);

            // Output
            System.out.println("Congratulations you got it right in "+attemps+" attempts!!!");
            System.out.print("\nDo you pretend to continue? Press (Y)es: ");
            option = sc.next();
        } while(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("Yes"));
        sc.close();
    }

    private static void tipGuess(int guess, int number) {
        if(guess < number) {
            System.out.println("Too low!");
        }
        if(guess > number) {
            System.out.println("Too high!");
        }
    }
}
