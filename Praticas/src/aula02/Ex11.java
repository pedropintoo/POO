package aula02;

import utils.UserInput;

import java.util.Scanner;


public class Ex11 {
    public static void main(String[] args) {
        int min = -10;
        int max = 20;
        int number = UserInput.IntegerInput(min,max,"Integer between [-10,20]");
        

        System.out.println("This Integer valid: " + number);
    }
    //
    public static int IntegerInput(int min, int max) {
        // Declarations
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Integer between ["+min+","+max+"]: ");
        double number = sc.nextDouble();

        // Validation
        while (number != (int) number || number < min || number > max) {
            System.out.println("Invalid value!");
            System.out.print("Integer between ["+min+","+max+"]: ");
            number = sc.nextDouble();
        }

        sc.close();

        // Return Integer
        return (int) number;
    }

}
