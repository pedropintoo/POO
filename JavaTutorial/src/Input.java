import java.util.Scanner;  // IMPORTANTE
public class Input {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "";
        while(name.isBlank()) {
            System.out.println("What is your name? ");
            name = scan.nextLine();
        }

        System.out.println("How old are you?");
        int age = scan.nextInt();
        scan.nextLine(); // nextInt() dá problemas para novos input (solução!)
        System.out.println("What is your favourite food?");
        String food = scan.nextLine();

        System.out.println("Hello "+name);
        System.out.println("You are "+age+" years old!");
        System.out.println("You like "+food);

        scan.close();


    }

}
