package aula02;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        // Declarations
        int number;
        Scanner sc = new Scanner(System.in);

        // Inputs
        do{
            System.out.print("Positive number: ");
            number = sc.nextInt();
            sc.close();
        }while (number <= 0);

        // Outputs
        for (int i = number; i>0; i--) {
            System.out.print(i + ", ");
            if(i % 10 == 0)
                System.out.println();
        }
        System.out.print(0);
    }
}
