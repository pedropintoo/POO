package aula02;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        // Declarations
        int sec,min,hor;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Tempo em segundos: ");
        sec = sc.nextInt();
        sc.close();

        // h/m/s calculations
        hor = sec/3600;
        sec = sec%3600;
        min = sec/60;
        sec = sec%60;

        // Outputs
        System.out.printf("Tempo Total: %s:%s:%s",hor,min,sec);


    }
}
