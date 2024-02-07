import java.util.Scanner;
public class Equals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("You are playing a game! Press q or Q to quit!");
        String response = scan.next();
        // response.equals("q") || responde.equals("Q")   (OR)
        if(response.toLowerCase().equals("q")) {
            System.out.println("You quit the game");
        }
        else {
            System.out.println("You are still playing the game *pew pew*");
        }
    }
}
